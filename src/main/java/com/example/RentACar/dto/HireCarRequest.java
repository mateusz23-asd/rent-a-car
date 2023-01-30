package com.example.RentACar.dto;
import lombok.Data;
@Data
public class HireCarRequest {
    private String userName;
    private String email;
    private String address;
    private String phone;
    private int numberOfDays;
    private int sumOfPrice;
    private Long carId;
}
