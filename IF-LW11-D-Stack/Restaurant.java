public class Restaurant {
    public Queue<Biber> biber;
    public CustomStack<Teller> teller;

    public Restaurant(Queue<Biber> biber, CustomStack<Teller> teller) {
        this.biber = biber;
        this.teller = teller;
    }

    public static void main(String[] args) {
        CustomStack<Teller> s = new CustomStack<Teller>();
        s.push(new Teller(2));
        s.push(new Teller(3));
        Queue<Biber> b = new Queue<Biber>();
        b.enqueue(new Biber(3));
        b.enqueue(new Biber(2));
        String passt = Restaurant.StackPasstZurQueue(s, b) ? "passt" : "passt nicht";
        System.out.println("Der Tellerstapel " + passt + " zur Warteschlange der Biber");
    }

    public static boolean StackPasstZurQueue(CustomStack<Teller> teller, Queue<Biber> biber) {
        while (!teller.isEmpty()) {
            if (biber.isEmpty()) {
                return false;
            }
            if (teller.top().getSize() != biber.getFront().getSize()) {
                return false;
            }
            teller.pop();
            biber.dequeue();
        }
        return true;
    } 
    
}