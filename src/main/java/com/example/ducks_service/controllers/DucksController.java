package com.example.ducks_service.controllers;

import com.example.ducks_service.model.*;
import com.example.ducks_service.repository.DuckRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

class DuckDTO {
    public int id;
    public Type type;
}

@RestController
@RequestMapping("/ducks")
public class DucksController {
    private final DuckRepository repository;

    public DucksController(DuckRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Ducks addDuck(@RequestBody DuckDTO duck) {
        Ducks d = null;
        switch (duck.type) {
            case MALLARD -> d = new Ducks(duck.id, "MALLARD");
            case REDHEAD -> d = new Ducks(duck.id, "REDHEAD");
            case RUBBER_DUCK -> d = new Ducks(duck.id, "RUBBER_DUCK");
            case DECOY_DUCK -> d = new Ducks(duck.id, "DECOY_DUCK");
        };
        return repository.save(d);
    }

    @GetMapping
    public List<Ducks> getAllDucks() {
        return (List<Ducks>) repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Ducks> getDuck(@PathVariable int id) {
       return repository.findById(id);
    }
}
