package practiceRoom;

import java.util.Date;

/**
 * Created by peter on 3/23/2017.
 */
public class Child implements Runnable {
    String name;
    Date inTime;

    BalloonAnimalStation station;

    public Child(BalloonAnimalStation station)
    {
        this.station = station;
    }

    public String getName() {
        return name;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public void run()
    {
        goForBalloonAnimal();
    }
    private synchronized void goForBalloonAnimal()
    {
        station.add(this);
    }
}
