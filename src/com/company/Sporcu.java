package com.company;

import java.util.ArrayList;

public class Sporcu {
    private String nameSurname;
    private Date birthDate;
    private ArrayList<String> club;




    // constructor tanimlamasi.
    public Sporcu(String nameSurname, Date birthDate) {
        this.nameSurname = nameSurname;
        this.birthDate=birthDate;
        this.club = new ArrayList<String>();
    }

    // get set methodlari.
    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }


    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate=birthDate;
    }

    public void addClub(String club) {
        this.club.add(club);
    }

    // toString methodu.
    @Override
    public String toString(){
        return nameSurname + "\n"  + birthDate + "\n"  + club.toString();
    }

    public ArrayList<String> getClub() {
        return club;
    }

}
