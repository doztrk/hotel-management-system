package com.tpe.service;

import com.tpe.domain.Hotel;
import com.tpe.exception.HotelNotFoundException;
import com.tpe.repository.HotelRepository;


import java.util.List;
import java.util.Scanner;

public class HotelService {

    //1-C:

    private Scanner scanner = new Scanner(System.in);
    private final HotelRepository hotelRepository;


    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public void saveHotel() {

        Hotel hotel = new Hotel();
        System.out.println("Enter hotel ID: ");
        hotel.setId(scanner.nextLong());
        scanner.nextLine();

        System.out.println("Enter hotel name: ");
        hotel.setName(scanner.nextLine());

        System.out.println("Enter hotel location: ");
        hotel.setLocations(scanner.nextLine());

        hotelRepository.save(hotel);
        System.out.println("Hotel is saved successfully. Hotel ID: " + hotel.getId());

    }

    //2-c: Output hotel given by ID
    public Hotel findHotelById(Long id) {


        Hotel hotelFound = hotelRepository.findById(id);

        try {


            if (hotelFound != null) {
                System.out.println("--------------------------------------------");
                System.out.println(hotelFound);
                System.out.println("--------------------------------------------");
                return hotelFound;
            } else {
                throw new HotelNotFoundException("Hotel not found by ID: " + id);
            }
        }catch (HotelNotFoundException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    //3-e list all hotels
    public void getAllHotels(){
       List<Hotel> allHotels =  hotelRepository.findAll();
       if (!allHotels.isEmpty()){
           System.out.println("----------------------------ALL HOTELS----------------------------");
           for (Hotel hotel : allHotels){
               System.out.println(hotel);
           }
           System.out.println("------------------------------------------------------------------");
       }else{
           System.out.println("Hotel list is empty.");
       }
    }
}
