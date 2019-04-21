package cn.zzuzl.structrue;

// trie树，存储由26个英文字母组成的字符串集
public class TrieTree {
    TrieNode root = new TrieNode('/');

    // 插入一个字符串
    void insert(String s) {
        TrieNode p = root;
        char[] chars = s.toCharArray();
        for (int i=0;i<chars.length;i++) {
            if (p.children[chars[i] - 'a'] == null) {
                p.children[chars[i] - 'a'] = new TrieNode(chars[i]);
                if (i == chars.length - 1) {
                    p.children[chars[i] - 'a'].isEndingChar = true;
                }
            }
            p = p.children[chars[i] - 'a'];
        }
        p.isEndingChar = true;
    }

    boolean find(String s) {
        TrieNode p = root;
        char[] chars = s.toCharArray();
        for (int i=0;i<chars.length;i++) {
            if (p.children[chars[i] - 'a'] == null) {
                return false;
            } else {
                p = p.children[chars[i] - 'a'];
            }
        }
        return p.isEndingChar;
    }

    public static void main(String[] args) {
        TrieTree trieTree = new TrieTree();
        trieTree.insert("hello");
        System.out.println(trieTree.find("hello"));
    }

}

class TrieNode {
    char data;
    TrieNode[] children = new TrieNode[26];
    boolean isEndingChar = false;

    public TrieNode(char data) {
        this.data = data;
    }
}
