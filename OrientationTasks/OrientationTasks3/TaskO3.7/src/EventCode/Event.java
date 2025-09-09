package EventCode;

public class Event implements Comparable<Event> {
    private final double time;
    private final EventType type;

    public Event(double time, EventType type) {
        this.time = time;
        this.type = type;
    }

    public double getTime() {
        return time;
    }

    public EventType getType() {
        return type;
    }

    @Override
    public int compareTo(Event other) {
        return Double.compare(this.time, other.time);
    }

    @Override
    public String toString() {
        return "EventCode.Event{" + "time=" + time + ", type=" + type + '}';
    }
}
