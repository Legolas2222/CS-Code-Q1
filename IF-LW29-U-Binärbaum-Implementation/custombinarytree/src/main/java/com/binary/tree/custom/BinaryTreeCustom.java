package com.binary.tree.custom;

public class BinaryTreeCustom<ContentType> {
    private BTNode<ContentType> node;
    
    public BinaryTreeCustom(ContentType value) {
        this.node = new BTNode<ContentType>(value);
    }

    public BinaryTreeCustom(ContentType value, BinaryTreeCustom<ContentType> left, BinaryTreeCustom<ContentType> right) {
        this.node = new BTNode<ContentType>(value, left, right);
    }

    public BinaryTreeCustom() {
        this.node = new BTNode<ContentType>();
    }

    public boolean isEmpty() {
        return node == null;
    }

    public ContentType getContent() {
        return node.content;
    }

    public void setContent(ContentType value) {
        node.content = value;
    }

    public BinaryTreeCustom<ContentType> getLeftTree() {
        return this.node.left;
    }

    public void SetLeftTree(BinaryTreeCustom<ContentType> left) {
        this.node.left = left;
    }
    
    public BinaryTreeCustom<ContentType> getRightTree() {
        return this.node.right;
    }

    public void SetRightTree(BinaryTreeCustom<ContentType> right) {
        this.node.right = right;
    }


    private class BTNode<CT> {
        public CT content;
        public BinaryTreeCustom<ContentType> left;
        public BinaryTreeCustom<ContentType> right;

        public BTNode(CT value) {
            this.content = value;
        }

        public BTNode(CT value, BinaryTreeCustom<ContentType> left, BinaryTreeCustom<ContentType> right) {
            this.content = value;
            this.left = left;
            this.right = right;
        }

        public BTNode() {
            
        }
    }
}
