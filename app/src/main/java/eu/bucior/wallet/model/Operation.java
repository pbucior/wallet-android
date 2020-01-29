package eu.bucior.wallet.model;

public class Operation {
    private int id;
    private Long dateAdded;
    private String dateOperation;
    private double amount;
    private String description;
    private String postingKey;

    public Operation(Long dateAdded, String dateOperation, double amount, String description, String postingKey) {
        this.dateAdded = dateAdded;
        this.dateOperation = dateOperation;
        this.amount = amount;
        this.description = description;
        this.postingKey = postingKey;
    }

    public Operation() {

    }

    public Operation(int id, Long dateAdded, String dateOperation, double amount, String description, String postingKey) {
        this.id = id;
        this.dateAdded = dateAdded;
        this.dateOperation = dateOperation;
        this.amount = amount;
        this.description = description;
        this.postingKey = postingKey;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Long dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(String dateOperation) {
        this.dateOperation = dateOperation;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPostingKey() {
        return postingKey;
    }

    public void setPostingKey(String postingKey) {
        this.postingKey = postingKey;
    }
}
