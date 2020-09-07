package com.example.myapplication;

public class registereduser {
    String familyead, nme, familid, pasword, emalid;

    public registereduser() {
    }

    public registereduser(String familyead, String nme, String familid, String pasword, String emalid) {
        this.familyead = familyead;
        this.nme = nme;
        this.familid = familid;
        this.pasword = pasword;
        this.emalid = emalid;
    }

    public String getFamilyead() {
        return familyead;
    }

    public void setFamilyead(String familyead) {
        this.familyead = familyead;
    }

    public String getNme() {
        return nme;
    }

    public void setNme(String nme) {
        this.nme = nme;
    }

    public String getFamilid() {
        return familid;
    }

    public void setFamilid(String familid) {
        this.familid = familid;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    public String getEmalid() {
        return emalid;
    }

    public void setEmalid(String emalid) {
        this.emalid = emalid;
    }
}
