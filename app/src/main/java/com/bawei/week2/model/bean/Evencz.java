package com.bawei.week2.model.bean;

public class Evencz {
    String name;
    int age;

    @Override
    public String toString() {
        return "Evencz{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Evencz(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
