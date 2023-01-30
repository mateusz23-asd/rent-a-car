package com.example.RentACar.controller;
import com.example.RentACar.entity.Car;
import com.example.RentACar.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller
public class AdminController {
    @Autowired
    CarService carService;

    @GetMapping("/admin")
    public String listCars(Model model){
        List<Car> carsList = carService.getAllCars();
        model.addAttribute("cars", carsList);
        return "admin";
    }
    @GetMapping("/cars/new")
    public String createNewCar(Model model){
        Car car = new Car();
        model.addAttribute("car", car);
        return "new_car";
    }
    @PostMapping("/cars")
    public String saveCar(@ModelAttribute("car") Car car){
        carService.saveCars(car);
        return "redirect:/admin";
    }
    @GetMapping("/cars/edit/{id}")
    public String editCar(@PathVariable Long id, Model model){
        model.addAttribute("car", carService.getCarById(id));
        return "edit_car";
    }
    @PostMapping("/cars/{id}")
    public String updateCar(@PathVariable Long id, @ModelAttribute("car") Car car){
        Car existingCar = carService.getCarById(id);
        existingCar.setId(id);
        existingCar.setCarType(car.getCarType());
        existingCar.setPrice(car.getPrice());
        carService.saveCars(existingCar);
        return "redirect:/admin";
    }
    @GetMapping("/cars/reset/{id}")
    public String resetRentStatus(@PathVariable Long id){
        Car car = carService.getCarById(id);
        car.setRented(false);
        car.setUser(null);
        carService.saveCars(car);
        return "redirect:/admin";
    }
}
