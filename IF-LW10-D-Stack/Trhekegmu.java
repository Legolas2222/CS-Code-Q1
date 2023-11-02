
public class Trhekegmu {
    public void ausgabe_zahlenfolge(Queue<Integer> zahlenfolge) {
        Stack<Integer> reverse_folge = new Stack<Integer>();
        System.out.println("Zahlenfolge Vorwärts: ");
        while (!zahlenfolge.isEmpty()) {
            reverse_folge.push(zahlenfolge.getFront());
            System.out.print(zahlenfolge.getFront() + ", ");
            zahlenfolge.dequeue();
        }
        System.out.println("Zahlenfolge Rückwärts:");
        while (!reverse_folge.isEmpty()) {
            System.out.print(reverse_folge.top() + ", ");
            reverse_folge.pop();
        }
    }

    public static void main(String[] args) {
        Trhekegmu t = new Trhekegmu();
        Queue<Integer> q = new Queue<Integer>();
        q.enqueue(10);
        q.enqueue(4);
        q.enqueue(6);
        q.enqueue(8);
        q.enqueue(1);
        q.enqueue(3);
        q.enqueue(2);
        t.ausgabe_zahlenfolge(q);
    }
}
