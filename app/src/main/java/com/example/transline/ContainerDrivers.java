package com.example.transline;

public class ContainerDrivers {
    private String Name;
    private String Details;
    private String Clearance;
    private String Transit;
    private String container;

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public ContainerDrivers(){
    }
    ContainerDrivers(String name, String Contacts, String Rating, String Destination,String container) {
        this.Name = name;
        this.Details = Contacts;
        this.Clearance = Rating;
        this.Transit = Destination;
        this.container=container;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        Details = details;
    }

    public String getClearance() {
        return Clearance;
    }

    public void setClearance(String clearance) {
        Clearance = clearance;
    }

    public String getTransit() {
        return Transit;
    }

    public void setTransit(String transit) {
        Transit = transit;
    }
}
