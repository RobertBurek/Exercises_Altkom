package pl.robertburek.nameday.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import pl.robertburek.nameday.model.NameDay;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class NameDayController {

    List<NameDay> nameDays;

    public NameDayController() {
        this.nameDays = new ArrayList<>();
        nameDays.add(new NameDay("Robert", "17-04"));
        nameDays.add(new NameDay("Monika", "04-05"));
        nameDays.add(new NameDay("Monika", "18-01"));
        nameDays.add(new NameDay("Monika", "27-08"));
        nameDays.add(new NameDay("Monika", "10-09"));
        nameDays.add(new NameDay("Robert", "21-02"));
        nameDays.add(new NameDay("Jerzy", "27-01"));
    }

    @GetMapping("/nameDay")
    public List<NameDay> getAll() {
        return nameDays;
    }

    @GetMapping("/nameDay/{name}")
    public List<NameDay> getNameAll(@PathVariable String name) {
        log.info("@PathVariable : " + name);
        return nameDays.stream().filter(nameDay -> (nameDay.getName()).equals(name)).collect(Collectors.toList());
    }

    @PostMapping("/nameDay")
    public boolean saveNameDay(@RequestBody NameDay nameDay) {
        return nameDays.add(nameDay);
    }

    @DeleteMapping("/nameDay/{index}")
    public void saveNameDay(@PathVariable int index) {
        nameDays.remove(index);
    }

}
