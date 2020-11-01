package com.example.transline;

public class ContainerDepot {
    private String Name;
    private String Details;
    private String Clearance;
    private String Transit;
    private String Driver;
public ContainerDepot(){
    }
    public ContainerDepot(String name, String details, String clearance, String transit, String driver) {
        this.Name = name;
        this.Details = details;
        this.Clearance = clearance;
        this.Transit = transit;
        this.Driver = driver;
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

    public String getDriver() {
        return Driver;
    }

    public void setDriver(String driver) {
        Driver = driver;
    }


}
