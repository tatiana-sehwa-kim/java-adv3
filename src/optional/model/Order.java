package optional.model;

public class Order {
    private long id;
    private Delevery delivery;

    public Order(long id, Delevery delivery) {
        this.id = id;
        this.delivery = delivery;
    }

    public long getId() {
        return id;
    }

    public Delevery getDelivery() {
        return delivery;
    }
}
