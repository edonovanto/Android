package com.novanto.fragmen;

public class CallModel {
    private int id;
    private String name, duration;

    public CallModel(int id, String name, String duration) {
        this.id = id;
        this.name = name;
        this.duration = duration;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDuration() {
        return duration;
    }
}
