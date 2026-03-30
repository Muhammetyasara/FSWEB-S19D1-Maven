package com.workintech.s18d2.controller;

import com.workintech.s18d2.dto.FruitResponse;
import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.services.FruitService;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/fruit")
public class FruitController {

    private final FruitService fruitService;

    @GetMapping
    public List<Fruit> get(){
        return fruitService.getByPriceAsc();
    }

    @GetMapping("/desc")
    public List<Fruit> getDesc(){
        return fruitService.getByPriceDesc();
    }

    @GetMapping("/{id}")
    public FruitResponse get(@Positive(message = "id sıfırdan küçük olamaz") @PathVariable Long id){
        return new FruitResponse("get by id succeed", fruitService.getById(id));
    }

    @GetMapping("/name/{name}")
    public List<Fruit> getByName(@Size(min=3,max = 45, message = "Name size must be between 3 to 45") @PathVariable("name") String name){
        return fruitService.searchByName(name);
    }

    @PostMapping
    public Fruit save(@Validated @RequestBody Fruit fruit){
        return fruitService.save(fruit);
    }

    @DeleteMapping("/{id}")
    public Fruit delete(@NotNull @Positive @PathVariable Long id){
        return fruitService.delete(id);
    }
}
