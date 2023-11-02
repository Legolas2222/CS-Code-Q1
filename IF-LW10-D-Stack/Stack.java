public class Stack<ContentType> {
  private StackNode<ContentType> head = null;

  public boolean isEmpty() {
    return (this.head == null);
  }

  public void push(ContentType pContent) {
    if (pContent != null) {
      // Warum gibt man als Parameter this bei der StackNode an ???
      StackNode<ContentType> node = new StackNode<ContentType>(/* this, */ pContent);
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
      return (ContentType) this.head.getContent();
    return null;
  }
}
