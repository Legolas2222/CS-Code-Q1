public class Queue<ContentType> {
    private QueueNode<ContentType> head = null;
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

    public ContentType enqueue(ContentType t) {
        QueueNode<ContentType> newNode = new QueueNode<ContentType>(t);
        if (this.isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
            this.length++;
            return newNode.contentObj;
        } else {
            this.tail.setNext(newNode);
            this.tail = newNode;
            this.length++;
            return newNode.contentObj;
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

    public ContentType findElement(ContentType r) {
        if (this.isEmpty()) {
            return null;
        }
        if (this.isOneElement()) {
            return (r == this.getFront()) ? this.getFront() : null;
        }
        return recursiveFind(this.head, r, 0);

    }

    private ContentType recursiveFind(QueueNode<ContentType> previousNode, ContentType refObject, int currentCounter) {
        if (previousNode == null || currentCounter == this.length) {
            return null;
        }
        currentCounter++;
        if (previousNode.contentObj != refObject) {
            recursiveFind(previousNode.getNext(), refObject, currentCounter);
        }
        return previousNode.getContent();
    }

    public static void main(String[] args) {
        // Arrange
        Queue<Person> q = new Queue<Person>();
        Person p1 = new Person("Bob");
        Person p2 = new Person("Max");

        // Act
        q.enqueue(p1);
        q.enqueue(p2);
        if (q.findElement(p2) == p2) {
            System.out.println("gefunden");
        }
        
        //Person result = find(p2);
        // Assert

    }

    public class QueueNode<SubContentType> {
        private SubContentType contentObj;
        private QueueNode<SubContentType> nextNode = null;

        public QueueNode(SubContentType t) {
            this.contentObj = t;
        }

        public QueueNode<SubContentType> getNext() {
            return this.nextNode;
        }

        public void setNext(QueueNode<SubContentType> qn) {
            this.nextNode = qn;
        }

        public SubContentType getContent() {
            return this.contentObj;
        }
    }

}