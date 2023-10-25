

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
        while(!statisten.isEmpty()) {
            tmp.enqueue(statisten.getFront());
            statisten.dequeue();
        }
        statisten = tmp;
        return x;
    }

    public void neuerStatist(Statist neuerStatist) {
        this.statisten.enqueue(neuerStatist);
    }

    public void sortiereNachScore() {
        
    }
    public Statist Find(Statist refObject) {
        QueueNode<Statist> tmp = this.statisten.getHead();
        boolean found = false;
        while(!found) {
            if(tmp == null) {
                return null;
            }
            if (tmp.getContent() == refObject) {
                found = true;
                return tmp.getContent();
            }
            else{
                tmp = tmp.getNext();
            }
        }
        return null;
    }





    public static void main(String[] args) {
        Argentur a = new Argentur("1");
        a.neuerStatist(new Statist("Hans", "M", 25));
        System.out.println(a.statistVermitteln().toString());
        System.out.println("test");
    }
}
