package datastrucrture.trie;

import datastructure.trie.TrieWithChildrenNumber;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrieWithChildrenNumberTests {
    @Test
    public void addAndSearchTest() {
        TrieWithChildrenNumber trie = new TrieWithChildrenNumber();
        trie.add("apple");
        trie.add("app");
        trie.add("banana");
        assertTrue(trie.search("apple"));
        assertFalse(trie.search("appl"));
        assertTrue(trie.search("app"));
        assertTrue(trie.search("banana"));
    }

    @Test
    public void deleteTest() {
        TrieWithChildrenNumber trie = new TrieWithChildrenNumber();
        trie.add("apple");
        trie.add("app");
        assertTrue(trie.search("apple"));
        assertTrue(trie.search("app"));
        assertFalse(trie.search("banana"));
        trie.delete("app");
        assertTrue(trie.search("apple"));
        assertFalse(trie.search("app"));
        trie.delete("apple");
        assertFalse(trie.search("apple"));
        assertFalse(trie.search("app"));

    }
}
