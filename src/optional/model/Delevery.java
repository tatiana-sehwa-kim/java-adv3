package optional.model;

public class Delevery {
    private String status;
    private boolean canceled;

    public Delevery(String status, boolean canceled) {
        this.status = status;
        this.canceled = canceled;
    }

    public String getStatus() {
        return status;
    }

    public boolean isCanceled() {
        return canceled;
    }
}
