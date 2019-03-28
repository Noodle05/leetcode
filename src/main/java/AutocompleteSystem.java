import java.util.*;

/**
 * <p>Design a search autocomplete system for a search engine. Users may input a sentence (at least one word and end with a special character '#'). For each character they type except '#', you need to return the top 3 historical hot sentences that have prefix the same as the part of sentence already typed. Here are the specific rules:
 *
 * <ol><li>The hot degree for a sentence is defined as the number of times a user typed the exactly same sentence before.</li>
 * <li>The returned top 3 hot sentences should be sorted by hot degree (The first is the hottest one). If several sentences have the same degree of hot, you need to use ASCII-code order (smaller one appears first).</li>
 * <li>If less than 3 hot sentences exist, then just return as many as you can.</li>
 * <li>When the input is a special character, it means the sentence ends, and in this case, you need to return an empty list.</li></ol></p>
 * <p>Your job is to implement the following functions:<br />
 *
 * The constructor function:<br />
 *
 * AutocompleteSystem(String[] sentences, int[] times): This is the constructor. The input is historical data. Sentences is a string array consists of previously typed sentences. Times is the corresponding times a sentence has been typed. Your system should record these historical data.<br />
 *
 * Now, the user wants to input a new sentence. The following function will provide the next character the user types:<br />
 *
 * List&lt;String&gt; input(char c): The input c is the next character typed by the user. The character will only be lower-case letters ('a' to 'z'), blank space (' ') or a special character ('#'). Also, the previously typed sentence should be recorded in your system. The output will be the top 3 historical hot sentences that have prefix the same as the part of sentence already typed.</p>
 *
 * <p><b>Example:</b><br />
 * <b>Operation:</b> AutocompleteSystem(["i love you", "island","ironman", "i love leetcode"], [5,3,2,2])
 * The system have already tracked down the following sentences and their corresponding times:<br />
 * "i love you" : 5 times<br />
 * "island" : 3 times<br />
 * "ironman" : 2 times<br />
 * "i love leetcode" : 2 times<br />
 * Now, the user begins another search:<br />
 *<br />
 * <b>Operation:</b> input('i')<br />
 * <b>Output:</b> ["i love you", "island","i love leetcode"]<br />
 * <b>Explanation:</b><br />
 * There are four sentences that have prefix "i". Among them, "ironman" and "i love leetcode" have same hot degree. Since ' ' has ASCII code 32 and 'r' has ASCII code 114, "i love leetcode" should be in front of "ironman". Also we only need to output top 3 hot sentences, so "ironman" will be ignored.<br />
 *<br />
 * <b>Operation:</b> input(' ')<br />
 * <b>Output:</b> ["i love you","i love leetcode"]<br />
 * <b>Explanation:</b><br />
 * There are only two sentences that have prefix "i ".<br />
 *<br />
 * <b>Operation:</b> input('a')<br />
 * <b>Output:</b> []<br />
 * <b>Explanation:</b><br />
 * There are no sentences that have prefix "i a".<br />
 *<br />
 * <b>Operation:</b> input('#')<br />
 * <b>Output:</b> []<br />
 * <b>Explanation:</b><br />
 * The user finished the input, the sentence "i a" should be saved as a historical sentence in system. And the following input will be counted as a new search.<br /></p>
 *
 * <p><b>Note:</b><br />
 *
 * <ol><li>The input sentence will always start with a letter and end with '#', and only one blank space will exist between two words.</li>
 * <li>The number of complete sentences that to be searched won't exceed 100. The length of each sentence including those in the historical data won't exceed 100.</li>
 * <li>Please use double-quote instead of single-quote when you write test cases even for a character input.</li>
 * <li>Please remember to RESET your class variables declared in class AutocompleteSystem, as static/class variables are persisted across multiple test cases. Please see here for more details.</li></ol></p>
 */
public class AutocompleteSystem {
    private static final int MAX_WORDS = 3;
    private final TrieNode root;
    private final Deque<TrieNode> deque;

    public AutocompleteSystem(String[] sentences, int[] times) {
        this.root = new TrieNode('.');
        for (int i = 0; i < sentences.length; i ++) {
            buildTrie(sentences[i], times[i]);
        }
        this.deque = new ArrayDeque<>();
    }

    private int getIndex(char ch) {
        int idx = ch - 'a';
        if (ch == ' ')
            idx = 26;
        return idx;
    }

    private void buildTrie(String str, int frequency) {
        char[] chs = str.toCharArray();
        TrieNode parent = root;
        for (int i = 0; i < chs.length; i ++) {
            int idx = getIndex(chs[i]);
            if (parent.children[idx] == null) {
                parent.children[idx] = new TrieNode(chs[i]);
            }
            parent = parent.children[idx];
            parent.setWords(str, frequency);
            if (i == chs.length - 1) {
                parent.frequency = frequency;
            }
        }
    }

    public List<String> input(char c) {
        if (c == '#') {
            if (!deque.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<TrieNode> ite = deque.descendingIterator();
                while (ite.hasNext())
                    sb.append(ite.next().aChar);
                String str = sb.toString();
                TrieNode last = deque.peek();
                last.frequency ++;
                int times = last.frequency;
                while (!deque.isEmpty()) {
                    TrieNode node = deque.pop();
                    node.setWords(str, times);
                }
            }
            return Collections.emptyList();
        }
        TrieNode parent = deque.isEmpty() ? root : deque.peek();
        int idx = getIndex(c);
        TrieNode child = parent.children[idx];
        if (child == null) {
            child = new TrieNode(c);
            parent.children[idx] = child;
        }
        deque.push(child);
        List<String> result = new ArrayList<>(MAX_WORDS);
        Iterator<WordTime> ite = child.words.descendingIterator();
        while (ite.hasNext())
            result.add(ite.next().word);
        return result;
    }

    private static class TrieNode {
        private final char aChar;
        private final TrieNode[] children;
        private int frequency;
        private final NavigableSet<WordTime> words;

        private TrieNode(char aChar) {
            this.aChar = aChar;
            this.children = new TrieNode[27];
            this.frequency = 0;
            words = new TreeSet<>();
        }

        private void setWords(String word, int time) {
            Iterator<WordTime> ite = words.iterator();
            WordTime wordTime = null;
            while (ite.hasNext()) {
                WordTime wt = ite.next();
                if (wt.word.equals(word)) {
                    wordTime = wt;
                    ite.remove();
                    break;
                }
            }
            if (wordTime == null) {
                wordTime = new WordTime(word, time);
            } else {
                wordTime.time = time;
            }
            if (words.size() < MAX_WORDS) {
                words.add(wordTime);
            } else {
                if (words.first().compareTo(wordTime) < 0) {
                    words.pollFirst();
                    words.add(wordTime);
                }
            }
        }
    }

    private static class WordTime implements Comparable<WordTime> {
        private final String word;
        private int time;

        private WordTime(String word, int time) {
            this.word = word;
            this.time = time;
        }


        @Override
        public int compareTo(WordTime o) {
            if (o == null)
                return 1;
            if (time > o.time)
                return 1;
            else if (time < o.time)
                return -1;
            else
                return o.word.compareTo(word);
        }
    }
}
