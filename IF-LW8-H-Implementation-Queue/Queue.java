public class Queue<ContentType> {
    private QueueNode<ContentType> head = null;
    public QueueNode<ContentType> getTail() {
        return tail;
    }

    public QueueNode<ContentType> getHead() {
        return head;
    }

    private QueueNode<ContentType> tail = null;
    private int length = 0;

    public int getLength() {
        return length;
    }

    public Queue() {

    }

    private boolean isOneElement() {
        return (this.head == this.tail && this.length == 1) ? true : false;
    }

    public boolean isEmpty() {
        return (this.head == null && this.tail == null) ? true : false;
    }

    public ContentType getFront() {
        return (this.head != null) ? this.head.getContent() : null;
    }

    public void enqueue(ContentType t) {
        QueueNode<ContentType> newNode = new QueueNode<ContentType>(t);
        if (this.isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
            this.length++;
        } else {
            this.tail.setNext(newNode);
            this.tail = newNode;
            this.length++;
        }
    }

    public void dequeue() {
        if (this.isEmpty()) {
            return;
        }
        if (this.isOneElement()) {
            this.head = null;
            this.tail = null;
            this.length = 0;
            return;
        } else {
            QueueNode<ContentType> secondNode = this.head.getNext();
            this.head = secondNode;
            this.length--;
            return;
        }
    }
    
    public void cycle(int numberOfTimes) {
        for (int i = 0; i < numberOfTimes; i++) {
            ContentType tmp = this.getFront();
            this.dequeue();
            this.enqueue(tmp);
        }
    }
    public void concat(Queue<ContentType> neu ) {

    }
    
}