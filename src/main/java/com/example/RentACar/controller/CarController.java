package com.example.RentACar.controller;
import com.example.RentACar.service.CarService;
import com.example.RentACar.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
@Controller
public class CarController {
    @Autowired
    private CarService carService;
    @GetMapping("/cars")
    public String listCars(Model model){
        List<Car> carsList = carService.getFreeCars();
        model.addAttribute("cars", carsList);
        return "cars";
    }
}
