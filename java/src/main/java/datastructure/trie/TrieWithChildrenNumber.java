package datastructure.trie;

import java.util.ArrayList;
import java.util.List;

class TrieNode {
    List<TrieNode> children;
    boolean isWord;
    int numWords;

    public TrieNode() {
        children = new ArrayList<>();
        isWord = false;
        numWords = 0;
    }
}

public class TrieWithChildrenNumber implements Trie {

    private TrieNode root;

    public TrieWithChildrenNumber() {
        root = new TrieNode();
    }

    @Override
    public boolean add(String word) {
        return true;
    }

    @Override
    public boolean search(String word) {
        return false;
    }

    @Override
    public boolean delete(String word) {
        return false;
    }

    @Override
    public List<String> findByPrefix(String word) {
        return null;
    }
}