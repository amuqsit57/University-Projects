package Classes;

import Costumer.Cart;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {

    private String name;
    private String gender;
    private String address;
    private Boolean membershipStatus;
    private String userName;
    private String password;

    private ArrayList<Item> cart = new ArrayList<Item>();

    private ArrayList< ArrayList<Item> > orders = new ArrayList<ArrayList<Item>>();


    public User(String name, String gender, String address, Boolean membershipStatus, String userName, String password) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.membershipStatus = membershipStatus;
        this.userName = userName;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getMembershipStatus() {
        return membershipStatus;
    }

    public void setMembershipStatus(Boolean membershipStatus) {
        this.membershipStatus = membershipStatus;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Item> getCart() {
        return cart;
    }

    public ArrayList<ArrayList<Item>> getOrders() {
        return orders;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", membershipStatus=" + membershipStatus +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void addToCart(Item item){
        cart.add(item);
    }

    public void removeFromCart(Item item){

        for(int i = 0 ; i < cart.size();i++){
            if(cart.get(i).getName().equals(item.getName())){
                cart.remove(i);
            }
        }

    }

    public void buy(){

        ArrayList<Item> newCart= new ArrayList<Item>();
        for(int i = 0 ; i<cart.size();i++){
            newCart.add(cart.get(i)) ;
        }
        orders.add(newCart);
    }

}
