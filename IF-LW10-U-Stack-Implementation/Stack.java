public class Stack<ContentType> {

    public class StackNode<SubContentType> {
        private SubContentType content;
        public SubContentType getContent() {
            return content;
        }

        private StackNode<SubContentType> next; 
        
        public StackNode<SubContentType> getNext() {
            return next;
        }

        public void setNext(StackNode<SubContentType> next) {
            this.next = next;
        }

        public StackNode(SubContentType data) {
            this.content = data;
        }
    }

    
    StackNode<ContentType> head;
    public Stack() {
        this.head = null;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public ContentType top() {
        return this.head.getContent();
    }

    public void push(ContentType data) {
        StackNode<ContentType> tmp = new StackNode<ContentType>(data);
        tmp.setNext(this.head);
        this.head = tmp;
    }

    public void pop() {
        if (this.head != null) {
            this.head = this.head.getNext();
        }
    }


}
