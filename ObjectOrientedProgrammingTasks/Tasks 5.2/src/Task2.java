public class Task2 {

    private static class ThreadSafeStringCollection {
        private final java.util.ArrayList<String> collection = new java.util.ArrayList<>();
        private final Object lock = new Object();

        public void add(String element) {
            synchronized (lock) {
                collection.add(element);
                System.out.printf("Added: %s | New Size: %d%n", element, collection.size());
            }
        }

        public int size() {
            synchronized (lock) {
                return collection.size();
            }
        }

        public void remove(String element) {
            synchronized (lock) {
                boolean removed = collection.remove(element);
                if (removed) {
                    System.out.printf("Removed: %s | New Size: %d%n", element, collection.size());
                } else {
                    System.out.printf("Element not found for removal: %s%n", element);
                }
            }
        }
    }

    private static class AddThread extends Thread {
        private final ThreadSafeStringCollection collection;
        private final String element;

        public AddThread(ThreadSafeStringCollection collection, String element) {
            this.collection = collection;
            this.element = element;
        }

        @Override
        public void run() {
            collection.add(element);
        }
    }

    private static class RemoveThread extends Thread {
        private final ThreadSafeStringCollection collection;
        private final String element;

        public RemoveThread(ThreadSafeStringCollection collection, String element) {
            this.collection = collection;
            this.element = element;
        }

        @Override
        public void run() {
            collection.remove(element);
        }
    }

    public static void main(String[] args) {
        ThreadSafeStringCollection collection = new ThreadSafeStringCollection();
        Thread[] threads = new Thread[20];

        for (int i = 0; i < 10; i++) {
            threads[i] = new AddThread(collection, "Element-" + i);
            threads[i].start();
        }

        for (int i = 10; i < 20; i++) {
            threads[i] = new RemoveThread(collection, "Element-" + (i - 10));
            threads[i].start();
        }
    }
}