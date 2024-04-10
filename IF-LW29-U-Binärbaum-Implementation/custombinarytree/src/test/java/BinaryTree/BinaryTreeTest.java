package BinaryTree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.binary.tree.custom.BinaryTree;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {

    private BinaryTree<Integer> binaryTree;

    @BeforeEach
    public void setUp() {
        binaryTree = new BinaryTree<>(10);
    }

    @Test
    public void testSetContent() {
        binaryTree.setContent(10);
        assertEquals(10, binaryTree.getContent());
    }

    @Test
    public void testSetLeftTree() {
        BinaryTree<Integer> leftTree = new BinaryTree<>(5);
        binaryTree.setLeftTree(leftTree);
        assertEquals(leftTree, binaryTree.getLeftTree());
    }

    @Test
    public void testSetRightTree() {
        BinaryTree<Integer> rightTree = new BinaryTree<>(15);
        binaryTree.setRightTree(rightTree);
        assertEquals(rightTree, binaryTree.getRightTree());
    }
}
