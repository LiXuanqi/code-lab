package datastructure.trie;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class TrieWithChildrenNumber implements Trie {

    static class TrieNode {
        TrieNode[] children;
        boolean isWord;
        int numWords;

        public TrieNode() {
            children = new TrieNode[26]; // assume all words are lowercase.
            isWord = false;
            numWords = 0;
        }
    }

    private TrieNode root;

    public TrieWithChildrenNumber() {
        root = new TrieNode();
    }

    @Override
    public boolean add(String word) {
        if (!isValid(word)) {
            return false;
        }
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            if (curr.children[pos] == null) {
                curr.children[pos] = new TrieNode();
            }
            curr.children[pos].numWords += 1;
            curr = curr.children[pos];
        }
        curr.isWord = true;
        return true;
    }

    @Override
    public boolean search(String word) {
        if (!isValid(word)) {
            return false;
        }
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            if (curr.children[pos] == null) {
                return false;
            }
            curr = curr.children[pos];
        }
        return curr.isWord;
    }

    @Override
    public boolean delete(String word) {
        if (!isValid(word) || !search(word)) {
            return false;
        }
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            if (curr.children[pos].numWords == 1) {
                curr.children[pos] = null;
                return true;
            }
            curr.children[pos].numWords -= 1;
            curr = curr.children[pos];
        }
        curr.isWord = false;
        return true;
    }

    @Override
    public List<String> findByPrefix(String word) {
        return null;
    }

    private boolean isValid(String word) {
        return word != null && word.length() != 0;
    }
}