public class Queue<ContentType> {
    private QueueNode head = null;
    private QueueNode tail = null;

    public Queue() {
        
    }
    public boolean isEmpty() {
        return (this.head == null && this.tail == null) ? true : false;
    }
    private boolean isOneElement() {
        return (this.head == this.tail) ? true : false;
    }
    public QueueNode front() {
        return this.head;
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
        QueueNode firstNode = this.head;
        
    }


}