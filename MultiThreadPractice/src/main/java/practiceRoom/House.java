package practiceRoom;

/**
 * Variation of barbershop for week 10 exercise
 * Created by peter on 3/23/2017.
 */
public class House {

    /**
     * Simulation main
     * @param args A place for passed arguments (not currently used)
     */
    public static void main(String[] args) {
        BalloonAnimalStation station = new BalloonAnimalStation(); // place to make balloon animals for party-goers
        Riley riley = new Riley(station);
        ChildFinder cg = new ChildFinder(station);

        Thread thRiley = new Thread(riley); // Riley
        Thread thChild = new Thread(cg); // Child Finder
        thChild.start();
        thRiley.start();
    }
}
