import java.util.Random;
public class Statist {
  private int score;

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  private String name;
  private String geschlecht;

  public Statist(String name, String geschlecht, int score) {
    this.name = name;
    this.geschlecht = geschlecht;
    this.score = score;
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

  public static Statist demoRandomStatist() {
    Random r = new Random();
    String g = (r.nextInt(2) == 0) ? "male" : "female";
    return new Statist(String.valueOf(r.nextInt(6)), g, r.nextInt(11));
  }
}