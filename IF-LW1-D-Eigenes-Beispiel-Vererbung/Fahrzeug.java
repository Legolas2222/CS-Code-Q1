
/**
 * Write a description of class Fahrzeug here.
 *
 * @author Patrick
 * @version 8/10/2023
 */
public class Fahrzeug {

    private int numberOfWheels;
    private String colour;
    private int numberOfPassangers;
    private int horsePower;

    public Fahrzeug(int pNumberOfWheels, String pColour, int pNumberOfPassangers, int pHhorsePower) {
        this.numberOfWheels = pNumberOfWheels;
        this.colour = pColour;
        this.numberOfPassangers = pNumberOfPassangers;
        this.horsePower = pHhorsePower;
    }

    public int getNumberOfWheels() {
        return this.numberOfWheels;
    }

    public int getNumberOfPassangers() {
        return this.numberOfPassangers;
    }

    public int getHorsePower() {
        return this.horsePower;
    }

    public String getColour() {
        return this.colour;
    }

    public void setNumberOfWheels(int newNumber) {
        // maybe check for negatives...
        this.numberOfWheels = newNumber;
    }

    public void setNumberOfPassangers(int newNumber) {
        // maybe check for negatives...
        this.numberOfWheels = newNumber;
    }

    public void setHorsepower(int newPower) {
        // maybe check for negatives...
        this.numberOfWheels = newPower;
    }

    public void setColour(String newColour) {
        // maybe check for real colour names...
        this.colour = newColour;
    }

}
