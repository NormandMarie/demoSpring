package fr.normand.demoSpring.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/fruits")
public class FruitController {
    @GetMapping
    public List<String> all(){
        return Arrays.asList("kiwi","fraises","framboise");
    }
}
