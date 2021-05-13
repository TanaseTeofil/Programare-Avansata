package com.example.SpringProject;

public class Person {

    private long id;
    private String name;

    public Person( long initialId, String initialName){
        this.id = initialId;
        this.name = initialName;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(long newId) {
        this.id = newId;
    }

    public void setName(String newName) {
        this.name = newName;
    }
}