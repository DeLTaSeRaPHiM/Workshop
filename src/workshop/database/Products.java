package workshop.database;

public class Products {
    private String product_ID;
    private String name;
    private String price;
    private String amountOnMonday;
    private String amountOnTuesday;
    private String amountOnWednesday;
    private String amountOnThursday;
    private String amountOnFriday;
    private String amountOnSaturday;
    private String amountOnSunday;

    public Products(String product_ID, String name, String price, String amountOnMonday,
                    String amountOnTuesday, String amountOnWednesday, String amountOnThursday,
                    String amountOnFriday, String amountOnSaturday, String amountOnSunday) {
        this.product_ID = product_ID;
        this.name = name;
        this.price = price;
        this.amountOnMonday = amountOnMonday;
        this.amountOnTuesday = amountOnTuesday;
        this.amountOnWednesday = amountOnWednesday;
        this.amountOnThursday = amountOnThursday;
        this.amountOnFriday = amountOnFriday;
        this.amountOnSaturday = amountOnSaturday;
        this.amountOnSunday = amountOnSunday;
    }

    public Products() {

    }

    public String getProduct_ID() {
        return product_ID;
    }

    public void setProduct_ID(String product_ID) {
        this.product_ID = product_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAmountOnMonday() {
        return amountOnMonday;
    }

    public void setAmountOnMonday(String amountOnMonday) {
        this.amountOnMonday = amountOnMonday;
    }

    public String getAmountOnTuesday() {
        return amountOnTuesday;
    }

    public void setAmountOnTuesday(String amountOnTuesday) {
        this.amountOnTuesday = amountOnTuesday;
    }

    public String getAmountOnWednesday() {
        return amountOnWednesday;
    }

    public void setAmountOnWednesday(String amountOnWednesday) {
        this.amountOnWednesday = amountOnWednesday;
    }

    public String getAmountOnThursday() {
        return amountOnThursday;
    }

    public void setAmountOnThursday(String amountOnThursday) {
        this.amountOnThursday = amountOnThursday;
    }

    public String getAmountOnFriday() {
        return amountOnFriday;
    }

    public void setAmountOnFriday(String amountOnFriday) {
        this.amountOnFriday = amountOnFriday;
    }

    public String getAmountOnSaturday() {
        return amountOnSaturday;
    }

    public void setAmountOnSaturday(String amountOnSaturday) {
        this.amountOnSaturday = amountOnSaturday;
    }

    public String getAmountOnSunday() {
        return amountOnSunday;
    }

    public void setAmountOnSunday(String amountOnSunday) {
        this.amountOnSunday = amountOnSunday;
    }
}
