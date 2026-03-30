package com.workintech.s18d2.controller;

import com.workintech.s18d2.dto.VegetableResponse;
import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.services.VegetableService;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/vegetable")
public class VegetableController {

    private final VegetableService vegetableService;

    @GetMapping
    public List<Vegetable> getByPriceAsc() {
        return vegetableService.getByPriceAsc();
    }

    @GetMapping("/desc")
    public List<Vegetable> getByPriceDesc() {
        return vegetableService.getByPriceDesc();
    }

    @GetMapping("/{id}")
    public VegetableResponse getById(@Positive(message = "id 0'dan küçük olamaz") @PathVariable("id") long id) {
        return new VegetableResponse("get by id succeed", vegetableService.getById(id));
    }

    @GetMapping("/name/{name}")
    public List<Vegetable> getByName(@Size(min = 3, max = 45, message = "Name size must be 3 to 45") @PathVariable("name") String name) {
        return vegetableService.searchByName(name);
    }

    @PostMapping
    public Vegetable save(@Validated @RequestBody Vegetable vegetable) {
        return vegetableService.save(vegetable);
    }

    @DeleteMapping("/{id}")
    public Vegetable delete(@Positive @NotNull @PathVariable long id) {
        return vegetableService.getById(id);
    }
}
