
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
        while (!statisten.isEmpty()) {
            maxScore = this.statisten.getFront();
            statisten.dequeue();
            while (!statisten.isEmpty()) {
                if (statisten.getFront().getScore() > maxScore.getScore()) {
                    tmpQ.enqueue(maxScore);
                    maxScore = statisten.getFront();
                    statisten.dequeue();
                } else {
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

    public void sortByScoreInsertion() {
        Queue<Statist> sorted = new Queue<Statist>();
        Statist erster = statisten.getFront();
        statisten.dequeue();
        sorted.enqueue(erster);
        while (!statisten.isEmpty()) {
            // Damit die while-Schleife mit nur 1 Element nicht direkt terminiert.
            if (sorted.getFront().getScore() > statisten.getFront().getScore()) {
                sorted.enqueue(statisten.getFront());
                sorted.dequeue();
            } else {
                sorted.enqueue(statisten.getFront());
                statisten.dequeue();
                Statist tmp = sorted.getFront();
                sorted.dequeue();
                sorted.enqueue(tmp);
            }

            while (sorted.getFront() != erster) {
                // Falls der Score von dem den wir einfügen wollen kleiner ist, als der aktuell
                // sortierte, dann "shiften" die Schlange um 1 und vergleichen mit dem nächsten
                if (sorted.getFront().getScore() > statisten.getFront().getScore()) {
                    Statist tmp = sorted.getFront();
                    sorted.dequeue();
                    sorted.enqueue(tmp);
                } else {
                    // Falls der an der richtigen Stelle steht, fügen wir ihn dort ein (Insertion)
                    sorted.enqueue(statisten.getFront());
                    // Dekrementieren der Ursprungsschlange
                    statisten.dequeue();
                }
            }
        }

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
        a.sortierenOneNote();
        a.print(a.statisten);
    }

    public void sortierenOneNote() {
        Statist maxStat;
        Queue<Statist> ergQ = new Queue<Statist>();
        Queue<Statist> hilfQ = new Queue<Statist>();
        // Für jedes Element in der Queue
        while (!statisten.isEmpty()) {
            // Erstes Element herausnehmen
            maxStat = statisten.getFront();
            statisten.dequeue();
            // Schauen ob dieses das größte Element ist, sonst das Größte finden
            while (!statisten.isEmpty()) {
                //Falls aktuell > vorherig
                if (statisten.getFront().getScore() > maxStat.getScore()) {
                    // Das Vorherige weglegen
                    hilfQ.enqueue(maxStat);
                    // Neues größtes Element setzen
                    maxStat = statisten.getFront();
                }
                // Sonst einfach das aktuelle größte mit dem nächsten vergleichen
                else {
                    hilfQ.enqueue(statisten.getFront());
                }
                // Darauf achten, dass man nicht endlos das Größe sucht
                statisten.dequeue();
            }
            // An diesem Punkt hat man das größte Element aus Statisten gefunden (maxStat)
            // Das größte Element aus Statisten in die ErgQ packen
            ergQ.enqueue(maxStat);
            // Statisten wieder füllen
            statisten= hilfQ;
            // hilfQ neu aufsetzen
            hilfQ = new Queue<Statist>();
        }
        // ErgQ setzen, sodass
        statisten = ergQ;
    }
}
