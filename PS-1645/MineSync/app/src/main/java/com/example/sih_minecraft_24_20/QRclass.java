package com.example.sih_minecraft_24_20;

public class QRclass {
    String patient_name;
    String username;
    String password;


    public String getPatient_name() {
        return patient_name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public QRclass(){}

    public QRclass(String user_name , String pass , String name){

        this.patient_name = name;
        this.username = user_name;
        this.password = pass;



    }

    public QRclass(String TextFromQR) {
        String[] strsplit = TextFromQR.split("\\|");
        this.patient_name = strsplit[0];
        this.username = strsplit[1];
        this.password = strsplit[2];
    }
}
