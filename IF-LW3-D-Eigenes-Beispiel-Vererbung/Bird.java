public class Bird extends Animal {
    private static int birdPopulation = 0;

    public static int getBirdPopulation() {
        return birdPopulation;
    }

    private String birdMelody;

    public String getBirdMelody() {
        return birdMelody;
    }

    public Bird(boolean canSwim, String birdMelody, String diet, boolean canFly) {
        super(2, canFly, canSwim, diet);
        Bird.birdPopulation++;
        this.birdMelody = birdMelody;
    }

    public void sing() {
        System.out.println(birdMelody);
    }

    public void finalize() {
        Bird.birdPopulation--;
    }

    public void makeSound() {
        super.makeSound();
        System.out.println("I'm also a bird :)");
    }

}

