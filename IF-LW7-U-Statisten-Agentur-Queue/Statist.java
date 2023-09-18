public class Statist {
  private String name;
  private String geschlecht;
  public Statist(String name, String geschlecht) {
    this.name = name;
    this.geschlecht = geschlecht;
  }
  public String getName() {
    return this.name;
  }
  public void setName(String newName) {
    this.name = newName;
  }
  public String getGeschlecht() {
    return this.geschlecht;
  }
  public void setGeschlecht(String newGeschlecht) {
    this.geschlecht = newGeschlecht;
  }
}