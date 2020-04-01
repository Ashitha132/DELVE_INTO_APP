package com.example.housepage;

public class Survey {
    String wardnumber,housenumber,address,ownername,aplbpl,rationcardnumber,religion,cast;
    int membernumber;

    public Survey()
    {
    }

    public Survey(String wardnumber, String housenumber, String address, String ownername, String aplbpl, String rationcardnumber, String religion, String cast, int membernumber) {
        this.wardnumber = wardnumber;
        this.housenumber = housenumber;
        this.address = address;
        this.ownername = ownername;
        this.aplbpl = aplbpl;
        this.rationcardnumber = rationcardnumber;
        this.religion = religion;
        this.cast = cast;
        this.membernumber = membernumber;
    }

    public String getWardnumber() {
        return wardnumber;
    }

    public void setWardnumber(String wardnumber) {
        this.wardnumber = wardnumber;
    }

    public String getHousenumber() {
        return housenumber;
    }

    public void setHousenumber(String housenumber) {
        this.housenumber = housenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

    public String getAplbpl() {
        return aplbpl;
    }

    public void setAplbpl(String aplbpl) {
        this.aplbpl = aplbpl;
    }

    public String getRationcardnumber() {
        return rationcardnumber;
    }

    public void setRationcardnumber(String rationcardnumber) {
        this.rationcardnumber = rationcardnumber;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public int getMembernumber() {
        return membernumber;
    }

    public void setMembernumber(int membernumber) {
        this.membernumber = membernumber;
    }
}
