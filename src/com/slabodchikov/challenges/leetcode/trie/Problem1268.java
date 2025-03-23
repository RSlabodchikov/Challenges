package com.slabodchikov.challenges.leetcode.trie;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/search-suggestions-system">Problem 1268</a>
 */
public class Problem1268 {

    public static void main(String[] args) {

        Problem1268 problem1268 = new Problem1268();
        String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";
        System.out.println(problem1268.suggestedProducts(products, searchWord));
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        List<List<String>> result = new ArrayList<>();
        Trie trie = new Trie();
        for (String product : products) {
            trie.insert(product);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : searchWord.toCharArray()) {
            sb.append(c);
            result.add(trie.findWordsByPrefix(sb.toString().toCharArray(), 3));
        }
        return result;
    }

    static class Trie {

        TrieNode[] nodes;

        public Trie() {

            this.nodes = new TrieNode[26];
        }

        public void insert(String word) {

            char[] chars = word.toCharArray();
            TrieNode currentNode = nodes[chars[0] - 'a'];
            StringBuilder sb = new StringBuilder();
            sb.append(chars[0]);
            if (currentNode == null) {
                currentNode = new TrieNode(sb.toString(), false);
                nodes[chars[0] - 'a'] = currentNode;
            }
            for (int i = 1; i < chars.length; i++) {
                sb.append(chars[i]);
                if (currentNode.nextNodes[(chars[i] - 'a')] == null) {
                    currentNode.nextNodes[chars[i] - 'a'] = new TrieNode(sb.toString(), false);
                }
                currentNode = currentNode.nextNodes[(chars[i] - 'a')];
            }
            currentNode.endOfWord = true;
        }

        public List<String> findWordsByPrefix(char[] prefix, int limit) {

            TrieNode currentNode = searchByPrefix(prefix);
            List<String> result = new ArrayList<>();

            if (currentNode == null) {
                return result;
            }

            LinkedList<TrieNode> nodes = new LinkedList<>();
            nodes.add(currentNode);

            while (!nodes.isEmpty()) {
                currentNode = nodes.pop();
                if (currentNode.endOfWord) {
                    result.add(currentNode.value);
                    if (result.size() == limit) {
                        return result;
                    }
                }
                for (int j = currentNode.nextNodes.length - 1; j >= 0; j--) {
                    if (currentNode.nextNodes[j] != null) {
                        nodes.addFirst(currentNode.nextNodes[j]);
                    }
                }
            }

            return result;
        }

        public boolean search(String word) {

            TrieNode currentNode = searchByPrefix(word.toCharArray());
            return currentNode != null && currentNode.endOfWord;
        }

        public TrieNode startsWith(String prefix) {

            return searchByPrefix(prefix.toCharArray());
        }

        private TrieNode searchByPrefix(char[] chars) {

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

            String value;
            boolean endOfWord;
            TrieNode[] nextNodes;

            public TrieNode(String value, boolean endOfWord) {

                this.value = value;
                this.endOfWord = endOfWord;
                this.nextNodes = new TrieNode[26];
            }
        }
    }
}
