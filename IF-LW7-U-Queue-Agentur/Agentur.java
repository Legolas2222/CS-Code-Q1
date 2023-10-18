public class Agentur {
    private Queue<Statist> statisten;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Agentur(String name) {
        this.statisten = new Queue<Statist>();
        this.name = name;
    }

    public Statist statistVermitteln() {
        Statist tmp = this.statisten.front();
        this.statisten.dequeue();
        return tmp;
    }

    public Statist statistVermittlen(String g) {
        Queue<Statist> tmp = new Queue<Statist>();
        Statist x = null;
        boolean fertig = false;
        while (!this.statisten.isEmpty() || fertig) {
            if (this.statisten.front().getGeschlecht() == g) {
                x = this.statisten.front();
                this.statisten.dequeue();

            } else {
                tmp.enqueue(this.statisten.front());
                this.statisten.dequeue();
            }
        }
        while(!statisten.isEmpty()) {
            hilf.enqueue(statisten.front());
            statisten.dequeue();
        }
        statisten = hilf;
        return x;
    }

    public void neuerStatist(Statist neuerStatist) {
        this.statisten.enqueue(neuerStatist);
    }

    public static void main(String[] args) {
        Agentur a = new Agentur("1");
        a.neuerStatist(new Statist("Hans", "M"));
        System.out.println(a.statistVermitteln().toString());
        System.out.println("test");
    }
}
