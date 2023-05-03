package fr.normand.demoSpring.controllers;

//import ch.qos.logback.core.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import fr.normand.demoSpring.entity.Fruit;
import fr.normand.demoSpring.service.FruitService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/my-fruits")
public class FruitControllerWeb {

    @Autowired
    private FruitService fruitService;

    @GetMapping
    public String getFruits(Model model) {
        Optional<List<Fruit>> optionalFruits = fruitService.fetchAllFruits();
        if (optionalFruits.isPresent()) {
            List<Fruit> fruits = optionalFruits.get();
            model.addAttribute("fruits", fruits);
        }
        return "fruits";
    }

    @PostMapping("/saveFruit")
    public String saveFruit(@RequestParam String name) {
        fruitService.createFruit(name);
        return "redirect:/my-fruits";
    }
    @GetMapping("/{id}")
    public String getFruitDetails(@PathVariable("id") Long id, Model model) {
        Fruit fruit = fruitService.fetchFruitById(id);
        model.addAttribute("fruit", fruit);
        return "fruit-details";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteFruit(@PathVariable("id") Long id) {
        fruitService.delete(id);
        return "redirect:/my-fruits";
    }
}
