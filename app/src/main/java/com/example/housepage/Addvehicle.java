package com.example.housepage;

public class Addvehicle {
    String vehicletype,vehiclenum,vehicleowner;

    public Addvehicle() {
    }

    public Addvehicle(String vehicletype, String vehiclenum, String vehicleowner) {
        this.vehicletype = vehicletype;
        this.vehiclenum = vehiclenum;
        this.vehicleowner = vehicleowner;
    }

    public String getVehicletype() {
        return vehicletype;
    }

    public void setVehicletype(String vehicletype) {
        this.vehicletype = vehicletype;
    }

    public String getVehiclenum() {
        return vehiclenum;
    }

    public void setVehiclenum(String vehiclenum) {
        this.vehiclenum = vehiclenum;
    }

    public String getVehicleowner() {
        return vehicleowner;
    }

    public void setVehicleowner(String vehicleowner) {
        this.vehicleowner = vehicleowner;
    }
}
