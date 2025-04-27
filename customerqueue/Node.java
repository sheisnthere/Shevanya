package customerqueue;

public class Node {
    private String customerName;
    private Node next;

    public Node(String customerName) {
        this.customerName = customerName;
        this.next = null;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
