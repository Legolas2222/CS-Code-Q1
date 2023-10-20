public class Queue<ContentType> {
    private QueueNode<ContentType> head = null;
    private QueueNode<ContentType> tail = null;

    public Queue() {
        
    }
    public boolean isEmpty() {
        return (this.head == null && this.tail == null) ? true : false;
    }
    private boolean isOneElement() {
        return (this.head == this.tail) ? true : false;
    }
    public ContentType getFront() {
        return this.head.getContent();
    }
    private QueueNode tail() {
        return this.tail;
    }
    public void enqueue(ContentType t) {
        QueueNode newNode = new QueueNode<ContentType>(t);
        if (this.isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        }
        else {
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
    }
    public void dequeue() {
        // QueueNode firstNode = this.head;
        QueueNode secondNode = this.head.getNext();
        this.head = secondNode;
    }
    

}