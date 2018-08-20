package datastrucrture.bst;

import datastructure.bst.BinarySearchTree;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTreeTests {
    @Test
    public void insertTests() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insertByIteration(1);
        bst.insertByIteration(2);
        bst.insertByIteration(3);
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        assertEquals(expected, bst.inorderTraverse());
    }
}
