package entity;

import java.util.Date;

public class Teacher {
    private String id;
    private String name;
    private Date date;
    private int amount;

    @Override
    public String toString() {
        return id + "|" + name + "|" + amount;
    }

    public Teacher() {
    }

    public Teacher(String id, String name, Date date, int amount) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
