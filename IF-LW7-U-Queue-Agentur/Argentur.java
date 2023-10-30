
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
    // front of the Queue and the number of already Sorted items from the back
    private int IndexOfBiggestScore(/* int alreadySorted */) {
        int minIndex = 0;
        int biggestScore = 0;
        for (int i = 0; i < this.statisten.getLength(); i++) {
            Statist tmp = this.statisten.getFront();
            this.statisten.dequeue();
            if (tmp.getScore() > biggestScore /* && i <= this.statisten.getLength() - alreadySorted */) {
                biggestScore = tmp.getScore();
                minIndex = i;
            }
            statisten.enqueue(tmp);
        }
        return minIndex;
    }

    public void sortByScore() {
        Queue<Statist> hilfe = new Queue<Statist>();
        int tmpLength = this.statisten.getLength();
        for (int i = 0; i < tmpLength; i++) {
            int maxIndex = IndexOfBiggestScore();
            this.statisten.cycle(maxIndex);
            hilfe.enqueue(this.statisten.getFront());
            this.statisten.dequeue();
        }
        this.statisten = hilfe;
    }

    public void sortByScoreUnterricht() {
        Queue<Statist> tmpQ = new Queue<Statist>();
        Queue<Statist> ergQ = new Queue<Statist>();
        Statist maxScore = null;
        while(!statisten.isEmpty()) {
            maxScore = this.statisten.getFront();
            statisten.dequeue();
            while (!statisten.isEmpty()) {
                if (statisten.getFront().getScore() > maxScore.getScore()) {
                    tmpQ.enqueue(maxScore);
                    maxScore = statisten.getFront();
                    statisten.dequeue();
                }
                else {
                    tmpQ.enqueue(statisten.getFront());
                    statisten.dequeue();
                }
            }
            ergQ.enqueue(maxScore);
            statisten = tmpQ;
            tmpQ = new Queue<Statist>();
        }
        statisten = ergQ;
    }

    public void print(Queue<Statist> q) {
        System.out.println("\n=========================");
        QueueNode<Statist> tmp = q.getHead();
        while (tmp != q.getTail()) {
            tmp.getContent().print();
            tmp = tmp.getNext();
            System.out.println("-------------------------");
        }
        q.getTail().getContent().print();
    }

    public static void main(String[] args) {
        Argentur a = new Argentur("1");
        a.neuerStatist(new Statist("Hans", "M", 1));
        a.neuerStatist(new Statist("Max", "M", 82));
        a.neuerStatist(new Statist("Bob", "M", 23));
        a.neuerStatist(new Statist("Jan", "W", 122));
        a.neuerStatist(new Statist("Theo", "M", 14));
        a.sortByScoreUnterricht();
        a.print(a.statisten);
    }
}
