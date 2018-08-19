package datastructure.trie;

import java.util.List;

public interface Trie {

    public boolean add(String word);

    public boolean search(String word);

    public boolean delete(String word);

    public List<String> findByPrefix(String word);
}
