package customerqueue;

public class Main {
    public static void main(String[] args) {
        CustomerQueue queue = new CustomerQueue();

        queue.enqueue("Fahmi");
        queue.enqueue("Faizal");
        queue.enqueue("Galih");
        queue.enqueue("Kevin");
        queue.enqueue("Shevanya");

        queue.displayQueue();

        String servedCustomer = queue.dequeue();
        System.out.println("Melayani pelanggan: " + servedCustomer);

        queue.displayQueue();
    }
}
