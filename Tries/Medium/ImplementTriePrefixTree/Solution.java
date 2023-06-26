package Tries.Medium.ImplementTriePrefixTree;

// Question link: https://leetcode.com/problems/implement-trie-prefix-tree/

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode('O');
    }

    public void insert(String word) {
        TrieNode currNode = root;
        for (int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);
            int charIdx = (int) currChar - 97;

            if (currNode.getChildren()[charIdx] == null) {
                currNode.getChildren()[charIdx] = new TrieNode(currChar);
            }

            currNode = currNode.getChildren()[charIdx];
        }
        currNode.setIsWord(true);
    }

    public boolean search(String word) {
        TrieNode currNode = root;
        for (int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);
            int charIdx = (int) currChar - 97;

            if (currNode.getChildren()[charIdx] == null) {
                return false;
            }

            currNode = currNode.getChildren()[charIdx];
        }

        return (currNode != null && currNode.getIsWord());
    }

    public boolean startsWith(String prefix) {
        TrieNode currNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            char currChar = prefix.charAt(i);
            int charIdx = (int) currChar - 97;

            if (currNode.getChildren()[charIdx] == null) {
                return false;
            }

            currNode = currNode.getChildren()[charIdx];
        }

        return (currNode != null);
    }
}

public class TrieNode {
    TrieNode[] children;
    char val;
    boolean isWord;

    public TrieNode(char val) {
        this.children = new TrieNode[26];
        this.val = val;
        this.isWord = false;
    }

    public void setIsWord(boolean newValue) {
        this.isWord = newValue;
    }

    public boolean getIsWord() {
        return this.isWord;
    }

    public TrieNode[] getChildren() {
        return this.children;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */