// Question link: https://leetcode.com/problems/design-add-and-search-words-data-structure/description/

class WordDictionary {
    public Node root;

    public WordDictionary() {
        this.root = new Node('0');
    }

    public void addWord(String word) {
        Node currNode = this.root;
        for (int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);
            int charIdx = (int) currChar - 97;

            if (currNode.getChildren()[charIdx] == null) {
                currNode.getChildren()[charIdx] = new Node(currChar);
            }
            currNode = currNode.getChildren()[charIdx];
        }
        currNode.setIsWord(true);
    }

    public boolean search(String word) {
        return helperSearch(word, this.root);
    }

    public boolean helperSearch(String word, Node currNode) {
        for (int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);
            int charIdx = (int) currChar - 97;

            // This is a wildcard for all possible letters.
            if (currChar == '.') {
                for (int j = 0; j < 26; j++) {
                    if (currNode.getChildren()[j] != null) {
                        boolean res = helperSearch(word.substring(i + 1), currNode.getChildren()[j]);
                        if (res) {
                            return true;
                        }
                    }
                }
                return false;
            } else {
                if (currNode.getChildren()[charIdx] == null) {
                    return false;
                }

                currNode = currNode.getChildren()[charIdx];
            }
        }

        return currNode != null && currNode.getIsWord();
    }
}

public class Node {
    private Node[] children;
    private boolean isWord;
    private char value;

    public Node(char value) {
        this.value = value;
        // 26 characters in the US dictionary (small)
        this.children = new Node[26];
        this.isWord = false;
    }

    public void setIsWord(boolean isWord) {
        this.isWord = isWord;
    }

    public boolean getIsWord() {
        return this.isWord;
    }

    public Node[] getChildren() {
        return this.children;
    }

    public char getValue() {
        return this.value;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */