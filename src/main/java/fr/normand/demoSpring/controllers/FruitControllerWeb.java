package fr.normand.demoSpring.controllers;

//import ch.qos.logback.core.model.Model;
import org.springframework.ui.Model;
import fr.normand.demoSpring.entity.Fruit;
import fr.normand.demoSpring.service.FruitService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
public class FruitControllerWeb {

    private FruitService fruitService = new FruitService();
    @GetMapping("/my-fruits")
    public String getFruits(Model model) {

        List<Fruit> fruits = fruitService.fetchAllFruits();
        model.addAttribute("fruits", fruits);
        return "fruits";
    }
}
