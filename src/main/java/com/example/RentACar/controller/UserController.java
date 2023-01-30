package com.example.RentACar.controller;

import com.example.RentACar.dto.HireCarRequest;
import com.example.RentACar.entity.Car;
import com.example.RentACar.entity.User;
import com.example.RentACar.service.CarService;
import com.example.RentACar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private CarService carService;
    @GetMapping("/cars/hire/{id}")
    public String createUser(@PathVariable Long id, Model model){
        Car car = carService.getCarById(id);
        model.addAttribute("car", car);
        User user = new User();
        model.addAttribute("user", user);
        return "hire";
    }
    @PostMapping("/cars/hire")
    public String saveUser(@ModelAttribute("hireCarRequest") HireCarRequest hireCarRequest){
        User user = new User();
        user.setName(hireCarRequest.getUserName());
        user.setEmail(hireCarRequest.getEmail());
        userService.saveUser(user);
        Car car = carService.getCarById(hireCarRequest.getCarId());
        car.setRented(true);
        car.setUser(user);
        carService.saveCars(car);
        return "redirect:/cars";
    }
}
