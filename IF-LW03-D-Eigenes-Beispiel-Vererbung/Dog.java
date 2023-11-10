public class Dog extends Animal {
    private static int DogPopulation = 0;

    public static int getDogPopulation() {
        return DogPopulation;
    }
    
    private String type;

    public String getType() {
        return type;
    }


    public Dog(String type) {
        super(4, false, true, "Carnivore");
        Dog.DogPopulation++;
        this.type = type;
    }

    public void Bark() {
        System.out.println("Woof Woof");
    }

    public void makeSound() {
        super.makeSound();
        System.out.println("I'm also a dog :)");
    }

    public void finalize() {
        Dog.DogPopulation--;
    }
}
