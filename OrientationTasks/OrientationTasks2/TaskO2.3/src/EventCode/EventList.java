package EventCode;

import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class EventList {
    private final PriorityQueue<Event> queue = new PriorityQueue<>();

    public void addEvent(Event event) {
        queue.add(event);
    }

    public Event getNextEvent() {
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public List<Event> getOrderedEvents() {
        List<Event> ordered = new ArrayList<>(queue);
        Collections.sort(ordered);
        return ordered;
    }

    // Tulostaa tapahtumat siististi
    public void printOrderedEvents() {
        for (Event e : getOrderedEvents()) {
            System.out.printf("- %s event at time %.2f%n", e.getType(), e.getTime());
        }
    }
}
