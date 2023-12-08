//package .workspaces.CS-Code-Q1.IF-LW14-U-Linschke-Addressbuch;

public class List<ContentType> {
  ListNode first = null;
  
  ListNode last = null;
  
  ListNode current = null;
  
  public boolean isEmpty() {
    return (this.first == null);
  }
  
  public boolean hasAccess() {
    return (this.current != null);
  }
  
  public void next() {
    if (hasAccess())
      this.current = this.current.getNextNode(); 
  }
  
  public void toFirst() {
    if (!isEmpty())
      this.current = this.first; 
  }
  
  public void toLast() {
    if (!isEmpty())
      this.current = this.last; 
  }
  
  public ContentType getContent() {
    if (hasAccess())
      return (ContentType)this.current.getContentObject(); 
    return null;
  }
  
  public void setContent(ContentType pContent) {
    if (pContent != null && hasAccess())
      this.current.setContentObject(pContent); 
  }
  
  public void insert(ContentType pContent) {
    if (pContent != null)
      if (hasAccess()) {
        ListNode newNode = new ListNode(this, pContent);
        if (this.current != this.first) {
          ListNode previous = getPrevious(this.current);
          newNode.setNextNode(previous.getNextNode());
          previous.setNextNode(newNode);
        } else {
          newNode.setNextNode(this.first);
          this.first = newNode;
        } 
      } else if (isEmpty()) {
        ListNode newNode = new ListNode(this, pContent);
        this.first = newNode;
        this.last = newNode;
      }  
  }
  
  public void append(ContentType pContent) {
    if (pContent != null)
      if (isEmpty()) {
        insert(pContent);
      } else {
        ListNode newNode = new ListNode(this, pContent);
        this.last.setNextNode(newNode);
        this.last = newNode;
      }  
  }
  
  public void concat(List<ContentType> pList) {
    if (pList != this && pList != null && !pList.isEmpty()) {
      if (isEmpty()) {
        this.first = pList.first;
        this.last = pList.last;
      } else {
        this.last.setNextNode(pList.first);
        this.last = pList.last;
      } 
      pList.first = null;
      pList.last = null;
      pList.current = null;
    } 
  }
  
  public void remove() {
    if (hasAccess() && !isEmpty()) {
      if (this.current == this.first) {
        this.first = this.first.getNextNode();
      } else {
        ListNode previous = getPrevious(this.current);
        if (this.current == this.last)
          this.last = previous; 
        previous.setNextNode(this.current.getNextNode());
      } 
      ListNode temp = this.current.getNextNode();
      this.current.setContentObject(null);
      this.current.setNextNode(null);
      this.current = temp;
      if (isEmpty())
        this.last = null; 
    } 
  }
  
  private ListNode getPrevious(ListNode pNode) {
    if (pNode != null && pNode != this.first && !isEmpty()) {
      ListNode temp = this.first;
      while (temp != null && temp.getNextNode() != pNode)
        temp = temp.getNextNode(); 
      return temp;
    } 
    return null;
  }
}
