import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>Write a program to solve a Sudoku puzzle by filling the empty cells.</p>
 *
 * <p>Empty cells are indicated by the character <font color="red">'.'</font>.</p>
 *
 * <p>You may assume that there will be only one unique solution.</p>
 *
 * <p><img src="http://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Sudoku-by-L2G-20050714.svg/250px-Sudoku-by-L2G-20050714.svg.png" /><br />
 * A sudoku puzzle...</p>
 *
 * <p></p><img src="http://upload.wikimedia.org/wikipedia/commons/thumb/3/31/Sudoku-by-L2G-20050714_solution.svg/250px-Sudoku-by-L2G-20050714_solution.svg.png" /><br />
 * ...and its solution numbers marked in red</p>
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        if (board == null) {
            throw new NullPointerException("board is mandatory");
        }
        if (board.length != 9 || board[0].length != 9) {
            throw new IllegalArgumentException("board must be a 9x9 array.");
        }
        Map<Integer, Set<Integer>> columnMissingNumbers = new HashMap<>(9);
        Map<Integer, Set<Integer>> rowMissingNumbers = new HashMap<>(9);
        Map<Integer, Set<Integer>> subGridMissingNumbers = new HashMap<>(9);
        for (int i = 0; i < 9; i ++) {
            columnMissingNumbers.put(i, new HashSet(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)));
            rowMissingNumbers.put(i, new HashSet(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)));
            subGridMissingNumbers.put(i, new HashSet(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)));
        }
        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j ++) {
                if (board[i][j] != '.') {
                    int t = board[i][j] - '0';
                    columnMissingNumbers.get(i).remove(t);
                    rowMissingNumbers.get(j).remove(t);
                    subGridMissingNumbers.get(((i / 3) * 3) + (j / 3)).remove(t);
                }
            }
        }
        solve(board, columnMissingNumbers, rowMissingNumbers, subGridMissingNumbers);
    }

    private boolean solve(char[][] board, Map<Integer, Set<Integer>> columns,
                          Map<Integer, Set<Integer>> rows,
                          Map<Integer, Set<Integer>> subGrids) {
        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j ++) {
                if (board[i][j] == '.') {
                    List<Integer> possibleValues = new ArrayList<>(columns.get(i));
                    possibleValues.retainAll(rows.get(j));
                    possibleValues.retainAll(subGrids.get(((i / 3) * 3) + (j / 3)));
                    for (int t : possibleValues) {
                        board[i][j] = (char) (t + '0');
                        columns.get(i).remove(t);
                        rows.get(j).remove(t);
                        subGrids.get(((i / 3) * 3) + (j / 3)).remove(t);
                        if (solve(board, columns, rows, subGrids)) {
                            return true;
                        } else {
                            board[i][j] = '.';
                            columns.get(i).add(t);
                            rows.get(j).add(t);
                            subGrids.get(((i / 3) * 3) + (j / 3)).add(t);
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
