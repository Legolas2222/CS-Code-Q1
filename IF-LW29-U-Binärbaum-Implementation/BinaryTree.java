public class BinaryTree<ContentType> {
    private ContentType value;
    private BinaryTree<ContentType> left;
    private BinaryTree<ContentType> right;
    
    public BinaryTree(ContentType value) {
        this.value = value;
    }

    public BinaryTree(ContentType value, BinaryTree<ContentType> left, BinaryTree<ContentType> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public BinaryTree() {
        
    }

    public void setValue(ContentType value) {
        this.value = value;
    }

    public ContentType getValue() {
        return value;
    }

    public BinaryTree<ContentType> getLeft() {
        return left;
    }

    public BinaryTree<ContentType> getRight() {
        return right;
    }

    public void setLeft(BinaryTree<ContentType> left) {
        this.left = left;
    }

    public void setRight(BinaryTree<ContentType> right) {
        this.right = right;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public boolean isEmpty() {
        return value == null;
    }


}
