//add comments to explain the code


import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Task1 {

    static class TicketReservationSystem {

        private int availableSeats;
        private final Lock lock = new ReentrantLock();

        public TicketReservationSystem(int totalSeats) {
            this.availableSeats = totalSeats;
        }

        public void reserveTickets(int customerId, int numTickets) {
            lock.lock();

            try {
                if (numTickets <= availableSeats) {
                    availableSeats -= numTickets;
                    System.out.printf("Customer %d reserved %d tickets.%n", customerId, numTickets);
                } else {
                    System.out.printf("Customer %d couldn't reserve %d tickets.%n", customerId, numTickets);
                }
            }

            finally {
                lock.unlock();
            }
        }
    }

    static class CustomerThread extends Thread {

        private final TicketReservationSystem reservationSystem;
        private final int customerId;
        private final int numTickets;

        public CustomerThread(TicketReservationSystem reservationSystem, int customerId, int numTickets) {
            this.reservationSystem = reservationSystem;
            this.customerId = customerId;
            this.numTickets = numTickets;
        }

        @Override
        public void run() {
            reservationSystem.reserveTickets(customerId, numTickets);
        }
    }

    public static void main(String[] args) {

        int totalSeats = 10;
        TicketReservationSystem reservationSystem = new TicketReservationSystem(totalSeats);
        Random random = new Random();
        Thread[] customers = new Thread[15];

        for (int i = 0; i < customers.length; i++) {
            int numTickets = random.nextInt(4) + 1;
            customers[i] = new CustomerThread(reservationSystem, i + 1, numTickets);
            customers[i].start();
        }

        for (Thread customer : customers) {
            try {
                customer.join();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
