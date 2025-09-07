package EventCode;

public class Event implements Comparable<Event> {
    private final double time;
    private final String name;  // tapahtuman nimi, esim. "Arrival" tms.

    public Event(double time, String name) {
        this.time = time;
        this.name = name;
    }

    public double getTime() {
        return time;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Event other) {
        return Double.compare(this.time, other.time);
    }

    @Override
    public String toString() {
        return String.format("EventCode.Event{name='%s', time=%.2f}", name, time);
    }
}
