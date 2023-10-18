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
    public QueueNode getFront() {
        return this.head;
    }
    public QueueNode tail() {
        return this.tail;
    }
    public void enqueue(ContentType t) {
        QueueNode newNode = new QueueNode<ContentType>(t);
        if (this.isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        }
        else if (this.isOneElement()) {
            this.head.setNext(newNode);
            this.tail = newNode;
        }
        else {
            
        }

    }


}