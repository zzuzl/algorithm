package cn.zzuzl.string;

// 朴素字符串匹配
public class BfString {

    static boolean has(String s, String pattern) {
        char[] chars = s.toCharArray();
        char[] patterns = pattern.toCharArray();

        boolean find = false;
        for (int i=0;i<chars.length - patterns.length;i++) {
            find = true;
            for (int j=0;j<patterns.length;j++) {
                if (patterns[j] != chars[i+j]) {
                    find = false;
                    break;
                }
            }
            if (find) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(has("hello", "ell"));
    }
}
