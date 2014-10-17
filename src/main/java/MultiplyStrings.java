import java.util.Arrays;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int carry = 0;
        char[] chs1 = num1.toCharArray();
        char[] chs2 = num2.toCharArray();
        char[] res = new char[chs1.length + chs2.length];
        Arrays.fill(res, '0');
        for (int i = chs1.length - 1; i >= 0; i--) {
            carry = 0;
            for (int j = chs2.length - 1; j >= 0; j--) {
                int v = (chs2[j] - '0') * (chs1[i] - '0') + res[i + j + 1]
                        - '0' + carry;
                if (v >= 10) {
                    carry = v / 10;
                    v = v % 10;
                } else {
                    carry = 0;
                }
                res[i + j + 1] = (char) (v + '0');
            }
            if (carry > 0) {
                res[i] = (char) (carry + '0');
            }
        }
        int offset = 0;
        while (offset < res.length - 1 && res[offset] == '0') {
            offset++;
        }
        return new String(res, offset, res.length - offset);
    }
}
