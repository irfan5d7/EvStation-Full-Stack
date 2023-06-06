package com.example.irfan.evstation.irfan.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "ImageBlob")
public class EvStation {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private double pricing;
    private String address;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String image;

    public EvStation(Long id, String name, double pricing, String address, String image) {
        super();
        this.id = id;
        this.name = name;
        this.pricing = pricing;
        this.address = address;
        this.image = image;
    }

    public EvStation(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPricing() {
        return pricing;
    }

    public void setPricing(double pricing) {
        this.pricing = pricing;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "EvStation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pricing=" + pricing +
                ", address='" + address + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
