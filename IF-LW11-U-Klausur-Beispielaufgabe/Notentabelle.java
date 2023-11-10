public class Notentabelle {

    private int[] tabelle;

    public Notentabelle(int punkte6, int punkte5, int punkte4, int punkte3, int punkte2, int punkte1) {
        this.tabelle = new int[6];
        tabelle[0] = punkte1;
        tabelle[1] = punkte2;
        tabelle[2] = punkte3;
        tabelle[3] = punkte4;
        tabelle[4] = punkte5;
        tabelle[5] = punkte6;
    }

    public int bestimmeNote(int pPunkte) {
        for (int i = tabelle.length; i > 0; i--) {
            if (pPunkte <= tabelle[i]) {
                return i + 1;
            }
        }
        return 1;
    }
}
