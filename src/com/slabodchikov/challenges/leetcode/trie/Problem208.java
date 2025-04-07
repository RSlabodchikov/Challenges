package com.slabodchikov.challenges.leetcode.trie;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/implement-trie-prefix-tree/">Problem 208</a>
 */
public class Problem208 {

    public static void main(String[] args) {

        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // return True
        System.out.println(trie.search("app"));     // return False
        System.out.println(trie.startsWith("app")); // return True
        trie.insert("app");
        System.out.println(trie.search("app")); // return True
    }

    static class Trie {

        TrieNode[] nodes;

        public Trie() {

            this.nodes = new TrieNode[26];
        }

        public void insert(String word) {

            char[] chars = word.toCharArray();
            TrieNode currentNode = nodes[chars[0] - 'a'];
            if (currentNode == null) {
                currentNode = new TrieNode(false);
                nodes[chars[0] - 'a'] = currentNode;
            }
            for (int i = 1; i < chars.length; i++) {
                if (currentNode.nextNodes[(chars[i] - 'a')] != null) {
                    currentNode = currentNode.nextNodes[(chars[i] - 'a')];
                } else {
                    currentNode.nextNodes[chars[i] - 'a'] = new TrieNode(false);
                    currentNode = currentNode.nextNodes[(chars[i] - 'a')];
                }
            }
            currentNode.endOfWord = true;
        }

        public boolean search(String word) {

            TrieNode currentNode = searchByPrefix(word);
            return currentNode != null && currentNode.endOfWord;
        }

        public boolean startsWith(String prefix) {

            TrieNode currentNode = searchByPrefix(prefix);
            return currentNode != null;
        }

        private TrieNode searchByPrefix(String prefix) {

            char[] chars = prefix.toCharArray();
            TrieNode currentNode = nodes[chars[0] - 'a'];
            for (int i = 1; i < chars.length; i++) {
                if (currentNode == null) {
                    break;
                }
                currentNode = currentNode.nextNodes[chars[i] - 'a'];
            }
            return currentNode;
        }

        static class TrieNode {

            boolean endOfWord;
            TrieNode[] nextNodes;

            public TrieNode(boolean endOfWord) {

                this.endOfWord = endOfWord;
                this.nextNodes = new TrieNode[26];
            }
        }
    }
}
