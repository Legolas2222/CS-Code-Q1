
public class Argentur {
    private Queue<Statist> statisten;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Argentur(String name) {
        this.statisten = new Queue<Statist>();
        this.name = name;
    }

    public Statist statistVermitteln() {
        Statist tmp = this.statisten.getFront();
        this.statisten.dequeue();
        return tmp;
    }

    public Statist statistVermittlen(String g) {
        Queue<Statist> tmp = new Queue<Statist>();
        Statist x = null;
        boolean fertig = false;
        while (!this.statisten.isEmpty() || fertig) {
            if (this.statisten.getFront().getGeschlecht() == g) {
                x = this.statisten.getFront();
                this.statisten.dequeue();

            } else {
                tmp.enqueue(this.statisten.getFront());
                this.statisten.dequeue();
            }
        }
        while (!statisten.isEmpty()) {
            tmp.enqueue(statisten.getFront());
            statisten.dequeue();
        }
        statisten = tmp;
        return x;
    }

    public void neuerStatist(Statist neuerStatist) {
        this.statisten.enqueue(neuerStatist);
    }

    // TODO need work
    public void sortiereNachScore() {
        int maximumsFound = 0;
        int tmpLength = this.statisten.getLength();
        // 4. Repeat steps 1-3 for each element of the queue until it's sorted
        for (int i = 0; i < tmpLength; i++) {
            // 1. find the biggest score in the Queue
            Statist biggestScoreStatist = null;
            for (int j = 0; j < tmpLength; j++) {
                // skip search times equal to the maximumsFound to avoid already sorted elements
                if(j > maximumsFound) {
                    continue;
                }
                if(biggestScoreStatist != null) {
                    this.statisten.enqueue(biggestScoreStatist);
                }

                Statist tmp = this.statisten.getFront();
                // Compare for Bigger Score
                if (tmp.getScore() > biggestScoreStatist.getScore()) {
                    biggestScoreStatist = tmp;
                }
                // Dequeue current element
                this.statisten.dequeue();
                // Re-Enqueue the element in the back of the Queue
                this.statisten.enqueue(tmp);
                //! wrong approach
                // 2. put on the start of the Queue and increment the maximums found
                
            }
        }



    }
    // This function should return the Index of the Biggest Element between the start of the Queue and alreadySortedIndex
    public int minIndex(int alreadySortedIndex) {
        int minIndex = 0;
        int biggestScore = -1;
        for (int i = 0; i < this.statisten.getLength(); i++) {
            Statist tmp = this.statisten.getFront();
            if (tmp.getScore() > biggestScore && i <= alreadySortedIndex) {
                minIndex++;
            }
        }
        return minIndex;
    }


    public Statist getBiggestScore() {
        Statist biggestScore = new Statist("tmp", "-", 0);
        int tmpLength = this.statisten.getLength();
        for (int i = 0; i < tmpLength; i++) {
            Statist tmp = this.statisten.getFront();
            // Compare for Bigger Score
            if (tmp.getScore() >= biggestScore.getScore()) {
                biggestScore = tmp;
            }
            // Dequeue current element
            this.statisten.dequeue();
            // Re-Enqueue the element in the back of the Queue
            this.statisten.enqueue(tmp);
        }
        //! Useless Method!!!!
        return biggestScore;
    }

    public void print() {
        System.out.println("\n== Printing the Queue ==");
        Queue<Statist> tmp = this.statisten;
        while (!tmp.isEmpty()) {
            tmp.getFront().print();
            System.out.println("");
            tmp.dequeue();
        }
    }

    public static void main(String[] args) {
        Argentur a = new Argentur("1");
        a.neuerStatist(new Statist("Hans", "M", 2));
        a.neuerStatist(new Statist("Bob", "M", 17));
        a.neuerStatist(new Statist("Max", "M", 8));
        a.print();
        System.out.println(a.minIndex(0));
    }
}
