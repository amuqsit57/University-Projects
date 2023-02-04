package Classes;

import java.io.Serializable;

public class Item implements Serializable {

    private String name;
    private String id;

    private int costPrice;
    private int price;

    private int userQuantity;

    private int soldItems;
    private int totalQuantity;
    String imageLocation;

    public Item(String name, String id, int price, int totalQuantity, String imageLocation,int costPrice) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.totalQuantity = totalQuantity;
        this.imageLocation = imageLocation;
        this.costPrice = costPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }

    public int getUserQuantity() {
        return userQuantity;
    }

    public void setUserQuantity(int userQuantity) {
        this.userQuantity = userQuantity;
    }

    public int getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(int costPrice) {
        this.costPrice = costPrice;
    }

    public int getSoldItems() {
        return soldItems;
    }

    public void setSoldItems(int soldItems) {
        this.soldItems = soldItems;
    }

    @Override
    public String toString() {
        return "Classes.Item{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", price=" + price +
                ", totalQuantity=" + totalQuantity +
                ", imageLocation='" + imageLocation + '\'' +
                '}';
    }
}
