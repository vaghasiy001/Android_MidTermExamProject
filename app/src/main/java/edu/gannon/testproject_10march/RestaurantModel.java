package edu.gannon.testproject_10march;

/**
 * Created by vaghasiy001 on 3/10/2015.
 */
public class RestaurantModel {
    private String name;
    private String address;
    private int type;
    public RestaurantModel(String name, String address, int type) {
        this.name = name;
        this.address = address;
        this.type = type;
    }
    public String Name(){
        return name;
    }
    public String Address(){
        return address;
    }
    public int Type(){
        return type;
    }
    @Override
    public String toString(){
        return this.name;
    }
}
