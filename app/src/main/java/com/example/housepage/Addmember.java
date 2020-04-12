package com.example.housepage;

public class Addmember {
    String membername,membergender,memberage,memberoccupation,memberaadhar;


    public Addmember() {
    }

    public Addmember(String membername, String membergender, String memberage, String memberoccupation, String memberaadhar) {
        this.membername = membername;
        this.membergender = membergender;
        this.memberage = memberage;
        this.memberoccupation = memberoccupation;
        this.memberaadhar = memberaadhar;
    }

    public String getMembername() {
        return membername;
    }

    public void setMembername(String membername) {
        this.membername = membername;
    }

    public String getMembergender() {
        return membergender;
    }

    public void setMembergender(String membergender) {
        this.membergender = membergender;
    }

    public String getMemberage() {
        return memberage;
    }

    public void setMemberage(String memberage) {
        this.memberage = memberage;
    }

    public String getMemberoccupation() {
        return memberoccupation;
    }

    public void setMemberoccupation(String memberoccupation) {
        this.memberoccupation = memberoccupation;
    }

    public String getMemberaadhar() {
        return memberaadhar;
    }

    public void setMemberaadhar(String memberaadhar) {
        this.memberaadhar = memberaadhar;
    }
}
