package BinaryTree;

import com.binary.tree.custom.BinaryTree;

public class BinaryTreeNumbers {
    public BinaryTree<Integer> zahlenbaum; 

    public BinaryTreeNumbers() {
        this.zahlenbaum = new BinaryTree<Integer>();
        this.SetUp();
        System.out.println("PreOrder: ");
        this.zahlenbaum.preOrder(zahlenbaum);
        System.out.println("InOrder: ");
        this.zahlenbaum.inOrder(zahlenbaum);
        System.out.println("PostOrder: ");
        this.zahlenbaum.postOrder(zahlenbaum);
    }

    public static void main(String[] args) {
        new BinaryTreeNumbers();
    }
    
    public void SetUp() {
        BinaryTree<Integer> zehn = new BinaryTree<Integer>(10);
        BinaryTree<Integer> elf = new BinaryTree<Integer>(11, zehn, null);
        
        BinaryTree<Integer> sieben = new BinaryTree<Integer>(7);
        BinaryTree<Integer> sechs = new BinaryTree<Integer>(6, null, sieben);

        BinaryTree<Integer> neun = new BinaryTree<Integer>(9, sechs, elf);

        BinaryTree<Integer> drei = new BinaryTree<Integer>(3);

        BinaryTree<Integer> fuenf = new BinaryTree<Integer>(5, drei, neun);

        this.zahlenbaum = fuenf;
    }
}
