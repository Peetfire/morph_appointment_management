package com.example.BookingSystem.components;


import com.example.BookingSystem.models.*;
import com.example.BookingSystem.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    ProviderRespository providerRepository;
    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    LocationRepository locationRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    RoomRepository roomRepository;


    public DataLoader(){
    }

    public void run(ApplicationArguments args){
        Provider provider = new Provider("Dave","Andrews","DA25","1234");
        providerRepository.save(provider);

        Provider provider2 = new Provider("Jenny","Andrews","JA25","1234");
        providerRepository.save(provider2);

        Provider provider3 = new Provider("Bernie","Andrews","BA25","1234");
        providerRepository.save(provider3);

        Admin admin = new Admin("Freya","Jules","FJ25","1234");
        adminRepository.save(admin);

        Admin admin2 = new Admin("Jessica","Mathews","JM25","1234");
        adminRepository.save(admin2);

        Admin admin3 = new Admin("Alfred","Doyle","AD25","1234");
        adminRepository.save(admin3);

        Client client = new Client("John","Smith","JS25","1234");
        clientRepository.save(client);

        Client client2 = new Client("Mandy","Mendoza","MM25","1234");
        clientRepository.save(client2);

        Client client3 = new Client("Sally","Simpleton","SS25","1234");
        clientRepository.save(client3);

        Location location = new Location("Big Building","35 Big Road","123456789","BigBuilding@Gmail.com");
        locationRepository.save(location);
        Location location2 = new Location("Bigger Building","35 Bigger Road","123456789","BiggerBuilding@Gmail.com");
        locationRepository.save(location2);
        Location location3 = new Location("Small Building","35 Small Road","123456789","SmallBuilding@Gmail.com");
        locationRepository.save(location3);

        Room room = new Room("Room 1", 3, location);
        roomRepository.save(room);
        Room room2 = new Room("Room 2", 3, location);
        roomRepository.save(room2);
        Room room3 = new Room("Room 3", 3, location);
        roomRepository.save(room3);

        Appointment appointment1 = new Appointment(client, provider, location, "massage","19:00","18:00");
        appointmentRepository.save(appointment1);

        Appointment appointment2 = new Appointment(client, provider2, location,"Dentist","2:00","3:00");
        appointmentRepository.save(appointment2);

        location.addRoom(room);
        location.addRoom(room2);
        location.addRoom(room3);
        locationRepository.save(location);

        provider.addLocation(location);
        provider.addLocation(location2);
        provider.addLocation(location3);
        providerRepository.save(provider);
        provider2.addLocation(location);
        provider2.addLocation(location2);
        provider2.addLocation(location3);
        providerRepository.save(provider2);
        provider3.addLocation(location);
        provider3.addLocation(location2);
        provider3.addLocation(location3);
        providerRepository.save(provider3);













    }
}
