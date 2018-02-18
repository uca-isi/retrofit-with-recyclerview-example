package chocoyolabs.myapplication.models;

/**
 * Created by moisolutions on 13/2/18.
 */

public class Penalty {
    private String text;
    private String price;
    private String type;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
