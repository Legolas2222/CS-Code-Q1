public class Queue<ContentType> {
    private QueueNode<ContentType> head = null;
    private QueueNode<ContentType> tail = null;

    public Queue() {
        
    }
    private boolean isOneElement() {
        return (this.head == this.tail) ? true : false;
    }
    public boolean isEmpty() {
        return (this.head == null && this.tail == null) ? true : false;
    }
    public ContentType getFront() {
        return this.head.getContent();
    }
    public void enqueue(ContentType t) {
        QueueNode<ContentType> newNode = new QueueNode<ContentType>(t);
        if (this.isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }
        else {
            this.tail.setNext(newNode);
            this.tail = newNode;
            return;
        }
    }
    public void dequeue() {
        if (this.isEmpty()) {
            return;
        }
        if (this.isOneElement()) {
            this.head = null;
            this.tail = null;
            return;
        }
        else {
            QueueNode<ContentType> secondNode = this.head.getNext();
            this.head = secondNode;
            return;
        }
    }
    
    public static void main(String[] args) {
        // Arrange
        Queue<Person> q = new Queue<Person>();
        Person p = new Person("Bob");
        // Act
        q.enqueue(p);
        // Assert
        if (p.equals(q.getFront())) {
            System.out.println("Gleiche Elemente");
        }
        // Act
        q.dequeue();
        // Assert
        if (q.isEmpty()) {
            System.out.println("Ist leer");
        }
    }

}