public class Nootebook {
    
    private String brand;
    private int ram;
    private int storage;
    private String os;
    private String color;

    public Nootebook(String brand, int ram, int storage, String os, String color) {
        this.brand = brand;
        this.ram = ram;
        this.storage = storage;
        this.os = os;
        this.color = color;
    }
    public String toString(){
        return "brand : " + brand + "| ram - " + ram + "| storage - " + storage + "| os - " + os + "| color - " + color;
    }


public Object getBrand() {
    return null;
}
public Object getOS() {
    return null;
}
public int getRam() {
    return 0;
}
public int getStorage() {
    return 0;
}
public Object getColor() {
    return null;
}
}
