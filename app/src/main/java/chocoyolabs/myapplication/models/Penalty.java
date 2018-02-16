package chocoyolabs.myapplication.models;

/**
 * Created by moisolutions on 13/2/18.
 */

public class Penalty {
    private String text;
    private Double price;
    private String type;

    public Penalty(String text, Double price, String type) {
        this.text = text;
        this.price = price;
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
