public class QueueNode<ContentType> {
    private ContentType contentObj;
    private QueueNode nextNode = null;
    public QueueNode(ContentType t) {
        this.contentObj = t;
    }
    public QueueNode getNext() {
        return this.nextNode;
    }
    public void setNext(QueueNode qn) {
        this.nextNode = qn;
    }
    public ContentType getContent() {
        return this.contentObj;
    }
}
