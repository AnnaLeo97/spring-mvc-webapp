package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    @GetMapping(value = "/cars")
    public String printCar(ModelMap model) {
        List<String> car = new ArrayList<>();
        car.add("Car1");
        car.add("Car2");
        car.add("Car3");
        model.addAttribute("cars", car);
        return "cars";
    }

}