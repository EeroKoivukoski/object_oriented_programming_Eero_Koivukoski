package EventCode;

import java.util.PriorityQueue;

public class EventList {
    private final PriorityQueue<Event> queue = new PriorityQueue<>();

    public void addEvent(Event e) {
        queue.add(e);
    }

    public Event getNextEvent() {
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
