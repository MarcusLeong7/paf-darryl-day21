package vttp.paf.day21.model;

public class Room {

    private int id;
    private String room_type;
    private float price;

    public Room() {
    }

    public Room(int id, String room_type, float price) {
        this.id = id;
        this.room_type = room_type;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
