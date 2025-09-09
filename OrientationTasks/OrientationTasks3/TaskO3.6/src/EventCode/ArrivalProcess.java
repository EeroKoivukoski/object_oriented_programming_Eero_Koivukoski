package EventCode;

import DistributionLib.*;

public class ArrivalProcess {
    private final EventType type;
    private final ContinuousGenerator generator;
    private double currentTime;

    public ArrivalProcess(EventType type, ContinuousGenerator generator) {
        this.type = type;
        this.generator = generator;
        this.currentTime = 0.0;
    }

    public void generateNext(EventList list) {
        // luodaan uusi väli generatorin avulla
        double interval = generator.sample();
        currentTime += interval;

        // uusi tapahtuma lisätään event listiin
        Event e = new Event(currentTime, type);
        list.addEvent(e);
    }
}
