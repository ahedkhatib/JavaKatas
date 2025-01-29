package katas.exercises;

import org.junit.jupiter.api.Test;

import static katas.exercises.KthSmallestElementInBST.kthSmallest;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class KthSmallestElementInBSTTest {

    @Test
    public void testKthSmallestElementInBST() {
        KthSmallestElementInBST.TreeNode root = new KthSmallestElementInBST.TreeNode(5);
        root.left = new KthSmallestElementInBST.TreeNode(3);
        root.right = new KthSmallestElementInBST.TreeNode(6);
        root.left.left = new KthSmallestElementInBST.TreeNode(2);
        root.left.right = new KthSmallestElementInBST.TreeNode(4);

        assertEquals(4, kthSmallest(root, 3));
        assertEquals(2, kthSmallest(root, 1));
        assertEquals(3, kthSmallest(root, 2));
        assertEquals(5, kthSmallest(root, 4));
        assertEquals(6, kthSmallest(root, 5));
    }

    @Test
    public void testAllNegativeInBST() {
        KthSmallestElementInBST.TreeNode root = new KthSmallestElementInBST.TreeNode(-5);
        root.left = new KthSmallestElementInBST.TreeNode(-8);
        root.right = new KthSmallestElementInBST.TreeNode(-4);
        root.left.left = new KthSmallestElementInBST.TreeNode(-10);
        root.left.right = new KthSmallestElementInBST.TreeNode(-6);

        int k = 3;
        int kthSmallestValue = kthSmallest(root, k);
        assertEquals(-6, kthSmallestValue);
    }

    @Test
    public void testOneElementBst() {
        KthSmallestElementInBST.TreeNode root = new KthSmallestElementInBST.TreeNode(5);

        int k = 1;
        int kthSmallestValue = kthSmallest(root, k);
        assertEquals(5, kthSmallestValue);
    }

    @Test
    public void testAllInLeft() {
        KthSmallestElementInBST.TreeNode root = new KthSmallestElementInBST.TreeNode(5);
        root.left = new KthSmallestElementInBST.TreeNode(4);
        root.left.left = new KthSmallestElementInBST.TreeNode(3);
        root.left.left.left = new KthSmallestElementInBST.TreeNode(2);

        assertEquals(4, kthSmallest(root, 3));
    }

    @Test
    public void testAllInRight() {
        KthSmallestElementInBST.TreeNode root = new KthSmallestElementInBST.TreeNode(5);
        root.right = new KthSmallestElementInBST.TreeNode(6);
        root.right.right = new KthSmallestElementInBST.TreeNode(7);
        root.right.right.right = new KthSmallestElementInBST.TreeNode(8);

        assertEquals(7, kthSmallest(root, 3));
    }

}
