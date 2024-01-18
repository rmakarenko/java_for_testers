package model;

public record groupData(String name, String header, String footer) {

    public groupData () {

        this("", "", "");
    }


}