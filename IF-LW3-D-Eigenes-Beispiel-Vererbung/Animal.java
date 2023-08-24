public class Animal {
    private static int population = 0;
    
    public static int getPopulation() {
        return population;
    }

    private int numberOfLegs;
    private boolean canFly;
    private boolean canSwim;
    private String diet;

    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    public boolean isCanFly() {
        return canFly;
    }

    public boolean isCanSwim() {
        return canSwim;
    }

    public String getDiet() {
        return diet;
    }

    public Animal(int numberOfLegs, boolean canFly, boolean canSwim, String diet) {
        Animal.population++;
        this.diet = diet;
        this.canFly = canFly;
        this.canSwim = canSwim;
        this.numberOfLegs = numberOfLegs;
    }

    public void makeSound() {
        System.out.println("I'm an animal :)");
    }
    
    public void finalize() {
        Animal.population--;
    }
}
