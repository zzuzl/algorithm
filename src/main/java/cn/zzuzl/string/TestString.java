package cn.zzuzl.string;

import java.util.Arrays;

public class TestString {

    // 反转字符串
    static void reverseString(char[] chars) {
        for (int i=0;i<chars.length-i-1;i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length-i-1];
            chars[chars.length-i-1] = temp;
        }
    }

    // 反转字符串里的单词
    static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length() - 1;
        int high = n;

        while (true) {
            while (high >= 0 && s.charAt(high) == ' ') {
                high --;
            }
            if (high < 0) {
                break;
            }
            int low = high;
            while (low >= 0 && s.charAt(low) != ' ') {
                low --;
            }

            sb.append(s.substring(low + 1, high + 1)).append(' ');
            high = low;
        }

        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    static int myAtoi(String str) {
        char[] chars = str.toCharArray();
        for (int i=0;i<chars.length;i++) {
            if (chars[i] == '+' || chars[i] == '-') {
                int n = 0;
                for (int j=i+1;j<chars.length;j++) {
                    if (chars[j] >= '0' && chars[j] <= '9') {
                        if (chars[i] == '+') {
                            n = n * 10 + chars[j] - '0';
                        } else {
                            n = n * 10 - (chars[j] - '0');
                        }
                    } else {
                        break;
                    }
                }
                return n;
            } else if (chars[i] >= '0' && chars[i] <= '9') {
                int n = 0;
                for (int j=i;j<chars.length;j++) {
                    if (chars[j] >= '0' && chars[j] <= '9') {
                        n = n * 10 + chars[j] - '0';
                    } else {
                        break;
                    }
                }
                return n;
            } else if (chars[i] != ' ') {
                return 0;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        char[] chars = "hellow".toCharArray();
        // reverseString(chars);
        System.out.println(Arrays.toString(chars));
        System.out.println(reverseWords("  hello world!  "));
        System.out.println(myAtoi("words and 987"));
    }
}
