package datastructure.bst;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class BinarySearchTree {

    private TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    public boolean searchByIteration(int target) {
        if (root == null) {
            return false;
        }
        while (root != null) {
           if (root.val == target) {
               return true;
           }
           if (root.val < target) {
               root = root.right;
           } else {
               root = root.left;
           }
        }
        return false;
    }

    public boolean searchByRecursion(int target) {
        return searchByRecursionHelper(root, target);
    }

    private boolean searchByRecursionHelper(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        if (root.val == target) {
            return true;
        }
        if (root.val < target) {
            return searchByRecursionHelper(root.right, target);
        } else {
            return searchByRecursionHelper(root.left, target);
        }
    }

    public void insertByIteration(int val) {
        if (root == null) {
            root = new TreeNode(val);
            return;
        }
        while (root != null) {
            if (root.val == val) {
                return;
            }
            if (root.val < val) {
                if (root.right == null) {
                    root.right = new TreeNode(val);
                    return;
                }
                root = root.right;
            } else {
                if (root.left == null) {
                    root.left = new TreeNode(val);
                    return;
                }
                root = root.left;
            }
        }
    }

    public List<Integer> inorderTraverse() {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        inorderTraverseHelper(root, result);
        return result;
    }

    private void inorderTraverseHelper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorderTraverseHelper(root.left, result);
        result.add(root.val);
        inorderTraverseHelper(root.right, result);
    }
}
