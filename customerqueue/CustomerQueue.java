package customerqueue;

public class CustomerQueue {
    private Node front;
    private Node rear;
    private int size;

    public CustomerQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(String customerName) {
        Node newNode = new Node(customerName);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.setNext(newNode);
        }
        rear = newNode;
        size++;
        System.out.println("Pelanggan " + customerName + " ditambahkan ke antrean.");
    }

    public String dequeue() {
        if (isEmpty()) {
            System.out.println("Antrean kosong.");
            return null;
        }
        String customerName = front.getCustomerName();
        front = front.getNext();
        if (front == null) {
            rear = null;
        }
        size--;
        return customerName;
    }

    public String peek() {
        if (isEmpty()) {
            System.out.println("Antrean kosong.");
            return null;
        }
        return front.getCustomerName();
    }

    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Antrean kosong.");
            return;
        }
        System.out.print("Pelanggan dalam antrean: ");
        Node current = front;
        int position = 1;
        while (current != null) {
            System.out.print(position + ". " + current.getCustomerName() + " ");
            current = current.getNext();
            position++;
        }
        System.out.println();
    }

    public int getSize() {
        return size;
    }
}
