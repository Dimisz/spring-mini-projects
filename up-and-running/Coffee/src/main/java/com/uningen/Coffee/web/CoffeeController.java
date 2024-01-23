package com.uningen.Coffee.web;

import com.uningen.Coffee.domain.Coffee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/coffees")
public class CoffeeController {
    private List<Coffee> coffees = new ArrayList<>();

    public CoffeeController(){
        coffees.addAll(List.of(
                new Coffee("Cafe Cereza"),
                new Coffee("Cafe Ganador"),
                new Coffee("Cafe Lareno"),
                new Coffee("Cafe Tres Pontas")
        ));
    }

    @GetMapping
    Iterable<Coffee> getCoffees(){
        return coffees;
    }

    @GetMapping("/{id}")
    Optional<Coffee> getCoffeeById(@PathVariable String id){
        for(Coffee c: coffees){
            if(c.getId().equals(id)){
                return Optional.of(c);
            }
        }
        return Optional.empty();
    }

    @PostMapping
    Coffee postCoffee(@RequestBody Coffee coffee){
        coffees.add(coffee);
        return coffee;
    }

    @PutMapping("/{id}")
    Coffee putCoffee(@PathVariable String id, @RequestBody String name){
        int coffeeIndex = -1;
        Coffee newCoffee = new Coffee(id, name);

        for(Coffee c: coffees){
            if(c.getId().equals(id)){
                coffeeIndex = coffees.indexOf(c);
                coffees.set(coffeeIndex, newCoffee);
                return newCoffee;
            }
        }
        return postCoffee(newCoffee);
    }

    @DeleteMapping("/{id}")
    void deleteCoffee(@PathVariable String id){
        coffees.removeIf(c -> c.getId().equals(id));
    }
}
