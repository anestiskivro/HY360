/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainClasses;

/**
 *
 * @author anestiskivroglou
 */
public class Rented {
    private String name;
    private String date;
    private int duration;
    private int payment;
    private int id_vehicle;
    private String model;
    private int number_vehicle;
    private String color;
    private int kmh_vehicle;

    public void set_Id_vehicle(int id_vehicle) {
        this.id_vehicle = id_vehicle;
    }
    public int getId_vehicle() {
        return id_vehicle;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    public int getPayment() {
        return payment;
    }

    public void setpayment(int payment) {
        this.payment = payment;
    }

    public String getmodel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

     public int get_number_vehicle() {
        return number_vehicle;
    }

    public void set_number_vehicle(int number_vehicle) {
        this.number_vehicle = number_vehicle;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int get_kmh_vehicle() {
        return kmh_vehicle;
    }

    public void set_kmh_vehicle(int kmh_vehicle) {
        this.kmh_vehicle = kmh_vehicle;
    }

}
