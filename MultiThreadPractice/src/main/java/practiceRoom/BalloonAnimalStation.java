package practiceRoom;

import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

/**
 * The booth where the balloon animals are made
 * Created by peter on 3/23/2017.
 */
public class BalloonAnimalStation {
    final private int nchair = 10;
    private List<Child> listChild;
    private final String animal[] = {"swan", "pony", "dachshund", "unicorn", "snake", "lizard", "TRex", "brontosaurus"};
    final private int species = animal.length;
    private final Logger logger = Logger.getLogger(this.getClass());
    private boolean childrenAllFound = false;

    public BalloonAnimalStation()
    {
        listChild = new LinkedList<Child>();
    }

    public void makeAnimals() {
        for (int count=0; count < 25; count++) makeAnimal();
    }

    public void makeAnimal()
    {
        Child child;
        logger.info("Riley looking at line of children.");
        synchronized (listChild)
        {

            while(listChild.size()==0)
            {
                logger.info("Riley is relaxing with lemon-aid while waiting for children to stop by...");
                try
                {
                    listChild.wait();
                }
                catch(InterruptedException iex)
                {
                    iex.printStackTrace();
                }
            }
            logger.info("Riley found " + listChild.size() + " children in the queue.");
            child = (Child)((LinkedList<?>)listChild).poll();
        }
        long duration=0;
        int index = (int) (Math.random() * species);
        try
        {
            logger.info("Making " + animal[index] + " for " + child.getName());
            duration = (long) (Math.random() * 100);
            Thread.sleep(duration);
        }
        catch(InterruptedException iex)
        {
            iex.printStackTrace();
        }
        logger.info("Completed making " + animal[index] + " for " + child.getName() + " in " + duration + " seconds");
    }

    public void add(Child child)
    {
        logger.info("Child : "+child.getName()+ " arriving at the station at "+child.getInTime());

        synchronized (listChild)
        {
            if(listChild.size() == nchair)
            {
                logger.info("No chair available for child "+child.getName());
                logger.info("Child " + child.getName() + " exists but has no chair to use while getting a balloon animal");
                return ;
            }

            ((LinkedList<Child>)listChild).offer(child);
            logger.info("Child : "+child.getName()+ " got a chair.");

            if(listChild.size()==1)
                listChild.notify();
        }
    }

    public void setChildrenAllFound(boolean value) {
        this.childrenAllFound = value;
    }

    public boolean isChildrenAllFound() {
        return childrenAllFound;
    }
}
