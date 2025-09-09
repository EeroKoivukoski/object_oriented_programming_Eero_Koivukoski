package EventCode;

import DistributionLib.ContinuousGenerator;

public class ArrivalProcess {
    private final EventType type;
    private final ContinuousGenerator generator;
    private double currentTime;

    public ArrivalProcess(EventType type, ContinuousGenerator generator) {
        this.type = type;
        this.generator = generator;
        this.currentTime = 0.0;
    }

    public Event generateNext() {
        currentTime += generator.sample();
        return new Event(currentTime, type);
    }
}
