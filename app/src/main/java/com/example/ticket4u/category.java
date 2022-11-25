package com.example.ticket4u;

public class category {
    String name;
    Number id;

    public category(String name, Number id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Number getId() {
        return id;
    }

    public void setId(Number id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "category{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
