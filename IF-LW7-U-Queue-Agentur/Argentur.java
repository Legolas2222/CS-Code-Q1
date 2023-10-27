
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



    // This function should return the Index of the Biggest Element between the
    // start of the Queue and the number of already Sorted items from the back
    public int minIndex(/*int alreadySorted*/) {
        int minIndex = 0;
        int biggestScore = 0;
        for (int i = 0; i < this.statisten.getLength(); i++) {
            Statist tmp = this.statisten.getFront();
            this.statisten.dequeue();
            if (tmp.getScore() > biggestScore /*&& i <= this.statisten.getLength() - alreadySorted*/) {
                biggestScore = tmp.getScore();
                minIndex = i;
            }
            statisten.enqueue(tmp);
        }
        return minIndex;
    }

    public void sortByScore() {
        Queue<Statist> hilfe = new Queue<Statist>();
        for (int i = 0; i < this.statisten.getLength(); i++) {
            int maxIndex = minIndex();
            this.statisten.cycle(maxIndex);
            this.statisten.getFront().print();
            hilfe.enqueue(this.statisten.getFront());
            this.statisten.dequeue();
        }
        print(hilfe);
    }

    public void print(Queue<Statist> q) {
        System.out.println("\n=========================");
        QueueNode<Statist> tmp = q.getHead();
        while(tmp != q.getTail()) {
            tmp.getContent().print();
            tmp = tmp.getNext();
            System.out.println("-------------------------");
        } 
        q.getTail().getContent().print();
    }

    
    public static void main(String[] args) {
        Argentur a = new Argentur("1");
        a.neuerStatist(new Statist("Hans", "M", 2));
        a.neuerStatist(new Statist("Bob", "M", 88));
        a.neuerStatist(new Statist("Theo", "M", 88));
        a.neuerStatist(new Statist("Max", "M", 8));
        a.neuerStatist(new Statist("Jan", "W", 34));
        a.sortByScore();
    }
}
