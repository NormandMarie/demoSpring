package fr.normand.demoSpring.service;

import fr.normand.demoSpring.entity.Fruit;
import fr.normand.demoSpring.repository.FruitJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Component
@Service
public class FruitService {
  @Autowired
  private FruitJdbcRepository repository;

    public List<Fruit> fetchAllFruits(){
        return repository.getAll();
    }

    public Fruit fetchFruitById(long id) {
      return repository.getById(id);
    }
  public Fruit createFruit(String name) {
    return repository.create(name);
  }


//  public Fruit updateFruit(long id, Fruit updatedFruit) {
//    Fruit fruit = repository.getById(id);
//    if (fruit == null) {
//      return null;
//    } else {
//      fruit.setName(updatedFruit.getName());
//      repository.save(fruit);
//      return fruit;
//    }
  }


