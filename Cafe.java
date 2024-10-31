/* This is a stub for the Cafe class */
public class Cafe extends Building {
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    /**
     * constructor
     * @param name
     * @param address
     * @param nFloors
     */
    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors);
        this.nCoffeeOunces = 50;
        this.nSugarPackets = 50;
        this.nCreams = 30;
        this.nCups = 50;
        System.out.println("You have built a cafe: ☕");
    }

    /** method to sell coffee
     * @param size
     * @param nSugarPackets
     * @param nCreams
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if ((this.nCoffeeOunces < size)||(this.nSugarPackets < nSugarPackets)||(this.nCreams<nCreams)||this.nCups==0) {
            this.restock();
            throw new RuntimeException("Hold on! We are restocking our inventory");
        }
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups--;
        System.out.println("Your coffee is now ready.");
    }

    /**
     * restocks the cafe's inventory
     */
    private void restock() {
        this.nCoffeeOunces = 50;
        this.nSugarPackets = 50;
        this.nCreams = 30;
        this.nCups = 50;
        System.out.println("Inventory restocked.");
    }

    /**
     * is entrypoint for the Cafe class and allows creation of a Cafe object
     * @param args
     */
    public static void main(String[] args) {
        Cafe c = new Cafe("Campus Center", "Central Campus", 1 );
        c.sellCoffee(16, 2, 0);
    }
}
