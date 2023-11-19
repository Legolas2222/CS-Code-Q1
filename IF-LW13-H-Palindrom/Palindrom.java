public class Palindrom {
  Stack<Character> s = new Stack<Character>();
  Queue<Character> q = new Queue<Character>();

  public Palindrom() {
  }

  public void testeStringMethoden() {
    String s = "Hallo";
    System.out.println(s);
    System.out.println(s.charAt(1));
    System.out.println(s.charAt(4));
    System.out.println("length: " + s.length());
    System.out.println(s.charAt(1));
    System.out.println(s.substring(4));
    System.out.println(s.substring(2, 4));
  }

  public boolean palindrom(String wort) {
    // Input the word into the Stack and Queue so that one is forwards and one is
    // backwards
    for (int i = 0; i < wort.length(); i++) {
      this.q.enqueue(wort.charAt(i));
      this.s.push(wort.charAt(i));
    }
    // Check if every character matches the other one when running through the Queue
    // and Stack
    for (int i = 0; i < wort.length(); i++) {
      if (s.top() != q.getFront()) {
        // Reset the Stack and the Queue, so that they can be reused, even if the loop
        // is terminated early
        this.q = new Queue<Character>();
        this.s = new Stack<Character>();
        return false;
      }
      s.pop();
      q.dequeue();
    }
    return true;
  }

  public String palindromErzeugen(String wort) {
    StringBuilder sb = new StringBuilder();
    // Input the word into the Stack and Queue so that one is forwards and one is
    // backwards
    for (int i = 0; i < wort.length(); i++) {
      this.q.enqueue(wort.charAt(i));
      this.s.push(wort.charAt(i));
    }
    // Merge the Queue with the Stack to create a word of double length, that is
    // definitely a palindrome
    while (!q.isEmpty()) {
      sb.append(q.getFront());
      q.dequeue();
    }
    while (!s.isEmpty()) {
      sb.append(s.top());
      s.pop();
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    Palindrom p = new Palindrom();
    System.out.println(p.palindrom("otto"));
    System.out.println(p.palindromErzeugen("Teschke"));
    System.out.println(p.palindrom(p.palindromErzeugen("Teschke")));
  }

}
