public class Bahnhof {
    private Stack<Wagon> gleisA;
    private Stack<Wagon> gleisB;
    private Stack<Wagon> gleisC;
    
    public void zugKommtAnGleisA(Wagon w) {
        this.gleisA.push(w);
    }

    public Bahnhof() {
        this.gleisA = new Stack<Wagon>();
        this.gleisB = new Stack<Wagon>();
        this.gleisC = new Stack<Wagon>();
    }

    public void vonAnachB() {
        this.gleisB.push(this.gleisA.top());
        this.gleisA.pop();
    }
    public void vonAnachC() {
        this.gleisC.push(this.gleisA.top());
        this.gleisA.pop();
    }
    public void vonBnachC() {
        this.gleisC.push(this.gleisB.top());
        this.gleisB.pop();
    }
    public void vonBnachA() {
        this.gleisA.push(this.gleisB.top());
        this.gleisB.pop();
    }
    public void vonCnachA() {
        this.gleisA.push(this.gleisC.top());
        this.gleisC.pop();
    }
    public void vonCnachB() {
        this.gleisB.push(this.gleisC.top());
        this.gleisC.pop();
    }
    public void alleVonCnachA() {
        while (!this.gleisC.isEmpty()) {
            this.gleisA.push(this.gleisC.top());
            this.gleisC.pop();
        }
    }
    public void alleVonBnachA() {
        while (!this.gleisB.isEmpty()) {
            this.gleisA.push(this.gleisB.top());
            this.gleisB.pop();
        }
    }

    public void rangieren() {
        alleVonBnachA();
        alleVonCnachA();
        boolean fertig = false;
        while (!fertig) {
            boolean lokalEinfachVerschoben = false;
            vonAnachB();
            while (!gleisA.isEmpty()) {
                Wagon a = this.gleisA.top();
                Wagon b = this.gleisB.top();
                if (a.getGewicht() > b.getGewicht()) {
                    vonBnachC();
                    vonAnachB();
                }
                else {
                    lokalEinfachVerschoben = true;
                    vonAnachC();
                }
            }
            vonBnachC();
            if (!lokalEinfachVerschoben) {
                fertig = true;
            }
            if (!fertig) {
                alleVonCnachA();
            }
        }
    }

    public static void main(String[] args) {
        Bahnhof b = new Bahnhof();
        b.zugKommtAnGleisA(new Wagon(7));
        b.zugKommtAnGleisA(new Wagon(2));
        b.zugKommtAnGleisA(new Wagon(5));
        b.zugKommtAnGleisA(new Wagon(13));
        b.zugKommtAnGleisA(new Wagon(6));
        b.zugKommtAnGleisA(new Wagon(1));
        b.rangieren();
    }
}

