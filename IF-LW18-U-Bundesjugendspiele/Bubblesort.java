public class Bubblesort {
    public List<Integer> liste = new List<Integer>();

    public Bubblesort() {
    }

    public void bs() {
        this.liste.toFirst();
        boolean vertauscht = true;
        while (vertauscht) {
            vertauscht = false;
            int aktuell = this.liste.getContent();
            this.liste.remove();
            if (aktuell > this.liste.getContent()) {
                this.liste.next();
            } else {
                if (this.liste.hasAccess()) {
                    this.liste.insert(aktuell);
                    aktuell = this.liste.getContent();
                    vertauscht = true;
                } else {
                    this.liste.append(aktuell);
                    this.liste.toFirst();
                    aktuell = this.liste.getContent();
                    this.liste.next();
                    vertauscht = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Bubblesort bs = new Bubblesort();
        bs.liste.append(9);
        bs.liste.append(2);
        bs.liste.append(1);
        bs.liste.append(8);
        bs.liste.append(4);
        bs.bs();
    }
}
