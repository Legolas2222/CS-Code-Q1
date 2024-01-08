public class Vokabel {

  private String englisch;
  private String deutsch;

  public Vokabel(String pE, String pD) {
    englisch = pE;
    deutsch = pD;
  }

  public String getEnglisch() {
    return englisch;
  }

  public String getDeutsch() {
    return deutsch;
  }

  public boolean istGleich(Vokabel pVokabel) {
    return (englisch.toUpperCase().compareTo(pVokabel.getEnglisch().toUpperCase()) == 0) && (deutsch.toUpperCase().compareTo(pVokabel.getDeutsch().toUpperCase()) == 0);
  }

  public boolean istGroesserAls(Vokabel pVokabel) {
    return (englisch.toUpperCase().compareTo(pVokabel.getEnglisch().toUpperCase()) > 0);
  }

  public boolean istKleinerAls(Vokabel pVokabel) {
    return (englisch.toUpperCase().compareTo(pVokabel.getEnglisch().toUpperCase()) < 0);
  }
}
