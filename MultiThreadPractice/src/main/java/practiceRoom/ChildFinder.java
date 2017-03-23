package practiceRoom;

import org.apache.log4j.Logger;

import java.util.Date;
import java.lang.Thread;

/**
 * Created by peter on 3/23/2017.
 */
public class ChildFinder implements Runnable
{
    private BalloonAnimalStation station;
    private final Logger logger = Logger.getLogger(this.getClass());

    public ChildFinder(BalloonAnimalStation station)
    {
        this.station = station;
    }

    public void run() {
        int maxNumberOfChildren = 100;
        for (int numberOfChildren=0; numberOfChildren < maxNumberOfChildren; numberOfChildren++)
        {
            Child child = new Child(station);
            child.setInTime(new Date());
            Thread thChild = new Thread(child);
            child.setName("Child Thread "+ thChild.getId());
            thChild.start();

            try
            {
                Thread.sleep((long)(Math.random()*100));
            }
            catch(InterruptedException iex)
            {
                iex.printStackTrace();
            }
        }
        logger.info("All children have been found");
    }

}
