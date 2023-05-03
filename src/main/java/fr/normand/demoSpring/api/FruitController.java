package fr.normand.demoSpring.api;

import fr.normand.demoSpring.entity.CreateFruitRequest;
import fr.normand.demoSpring.entity.Fruit;
import fr.normand.demoSpring.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fruits")
public class FruitController {

    @Autowired
    private FruitService fruitService;
//    private static FruitService fruitService = new FruitService();
    @GetMapping
    public Optional<List<Fruit>> all(){
        Optional<List<Fruit>> fruits = fruitService.fetchAllFruits();
        return fruits;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Fruit> fetchFruitById(@PathVariable long id) {
        Fruit fruit = fruitService.fetchFruitById(id);
        if (fruit == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(fruit);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFruit(@PathVariable("id") long id) {
        fruitService.delete(id);
        return new ResponseEntity<>("Le fruit a été supprimé avec succès.", HttpStatus.OK);
    }

    @PostMapping
   public ResponseEntity<Fruit> createFruit(@RequestBody CreateFruitRequest request) {
      String name = request.getName();
       Fruit fruit = fruitService.createFruit(name);
        return ResponseEntity.ok(fruit);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Fruit> updateFruit(@PathVariable long id, @RequestBody Fruit fruit) {
//        Fruit updatedFruit = fruitService.updateFruit(id,fruit);
//        if (updatedFruit == null) {
//            return ResponseEntity.notFound().build();
//        } else {
//            return ResponseEntity.ok(updatedFruit);
//        }
//    }


}
