public class Klausur {
  
  // Anfang Attribute
  private String name;
  private int punkte;
  private int note;
  // Ende Attribute
  
  public Klausur(String name) {
    this.name = name;
    this.punkte = -1;
    this.note = -1;
  }

  // Anfang Methoden
  public String getName() {
    return name;
  }

  public int getPunkte() {
    return punkte;
  }

  public void setPunkte(int punkte) {
    this.punkte = punkte;
  }

  public int getNote() {
    return note;
  }

  public void setNote(int note) {
    this.note = note;
  }

  // Ende Methoden
} // end of Klausur
