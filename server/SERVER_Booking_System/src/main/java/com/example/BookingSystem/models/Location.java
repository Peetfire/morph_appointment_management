package com.example.BookingSystem.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="address")
    private String address;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="email")
    private String email;

    @JsonIgnoreProperties(value="location")
    @OneToMany(mappedBy = "location",fetch = FetchType.LAZY)
    private List<Room> workspaces;

    @JsonIgnoreProperties(value="location")
    @OneToMany(mappedBy = "location",fetch = FetchType.LAZY)
    private List<Appointment> appointments;

    @ManyToMany
    @JsonIgnoreProperties({"locations"})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "locations_providers",
            joinColumns = { @JoinColumn(
                    name = "location_id",
                    nullable = false,
                    updatable = false)
            },
            inverseJoinColumns = { @JoinColumn(
                    name = "provider_id",
                    nullable = false,
                    updatable = false)
            }
            )
    private List<Provider> providers;

    public Location(String name, String address, String phoneNumber, String email) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.workspaces =new ArrayList<>();
        this.providers =new ArrayList<>();
    }

    public Location(){
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addProvider(Provider provider){
        this.providers.add(provider);
    }

    public List<Room> getWorkspaces() {
        return workspaces;
    }

    public void setWorkspaces(List<Room> workspaces) {
        this.workspaces = workspaces;
    }

    public List<Provider> getProviders() {
        return providers;
    }

    public void setProviders(List<Provider> providers) {
        this.providers = providers;
    }

    public void addRoom(Room room){
        this.workspaces.add(room);
    }
}
