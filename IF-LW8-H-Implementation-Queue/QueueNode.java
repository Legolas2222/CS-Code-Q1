public class QueueNode<ContentType> {
    private ContentType contentObj;
    private QueueNode<ContentType> nextNode = null;
    public QueueNode(ContentType t) {
        this.contentObj = t;
    }
    public QueueNode<ContentType> getNext() {
        return this.nextNode;
    }
    public void setNext(QueueNode<ContentType> qn) {
        this.nextNode = qn;
    }
    public ContentType getContent() {
        return this.contentObj;
    }
}
