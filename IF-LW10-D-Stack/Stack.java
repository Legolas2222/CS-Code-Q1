public class Stack<ContentType> {
  private StackNode head = null;
  
  public boolean isEmpty() {
    return (this.head == null);
  }
  
  public void push(ContentType pContent) {
    if (pContent != null) {
      StackNode node = new StackNode(this, pContent);
      node.setNext(this.head);
      this.head = node;
    } 
  }
  
  public void pop() {
    if (!isEmpty())
      this.head = this.head.getNext(); 
  }
  
  public ContentType top() {
    if (!isEmpty())
      return (ContentType)this.head.getContent(); 
    return null;
  }
}
