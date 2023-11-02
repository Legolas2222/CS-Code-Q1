public class StackNode<ContentType> {
    private StackNode<ContentType> nextNode;

    public StackNode<ContentType> getNext() {
        return nextNode;
    }

    public void setNext(StackNode<ContentType> nextNode) {
        this.nextNode = nextNode;
    }

    private ContentType content;

    public ContentType getContent() {
        return content;
    }

    public StackNode(ContentType data) {
        this.content = data;

    }
}
