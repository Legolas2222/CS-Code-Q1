public class S68Nr3b {

    public static boolean StackPasstZurQueue(Stack<Teller> teller, Queue<Biber> biber) {
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