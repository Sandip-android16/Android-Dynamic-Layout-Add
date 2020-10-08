package com.example.androidaddedittextdynamically;

public class ListDataModel {


    String Name1,Name2,Name3;

    public ListDataModel(String name1, String name2, String name3) {
        Name1 = name1;
        Name2 = name2;
        Name3 = name3;
    }

    public String getName1() {
        return Name1;
    }

    public void setName1(String name1) {
        Name1 = name1;
    }

    public String getName2() {
        return Name2;
    }

    public void setName2(String name2) {
        Name2 = name2;
    }

    public String getName3() {
        return Name3;
    }

    public void setName3(String name3) {
        Name3 = name3;
    }
}
