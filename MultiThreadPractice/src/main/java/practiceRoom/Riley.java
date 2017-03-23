package practiceRoom;

/**
 * Easily bored provider of balloon animals to children at Easter Party
 * Created by peter on 3/23/2017.
 */
public class Riley implements Runnable {
    private BalloonAnimalStation station;

    Riley(BalloonAnimalStation station)
    {
        this.station = station;
    }

    public void run()
    {
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException iex)
        {
            iex.printStackTrace();
        }
        System.out.println("Riley started..");

        station.makeAnimals();

    }
}
