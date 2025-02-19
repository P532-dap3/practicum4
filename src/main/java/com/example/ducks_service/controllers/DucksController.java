package com.example.ducks_service.controllers;

import com.example.ducks_service.model.*;
import com.example.ducks_service.repository.DucksRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

class DuckDTO {
    public int id;
    public Type type;
}

@RestController
@RequestMapping("/ducks")
public class DucksController {
    private final DucksRepository repository = new DucksRepository();

    @PostMapping
    public boolean addDuck(@RequestBody DuckDTO duck) {
        try{
            Duck d = null;
            switch (duck.type) {
                case MALLARD -> d = new MallardDuck(duck.id);
                case REDHEAD -> d = new RedheadDuck(duck.id);
                case RUBBER_DUCK -> d = new RubberDuck(duck.id);
                case DECOY_DUCK -> d = new DecoyDuck(duck.id);
            };
            return repository.addDuck(d);
        }catch(IOException e){
            return false;
        }
    }

    @GetMapping
    public List<Duck> getAllDucks() {
        try{
            return repository.getAllDucks();
        }catch(IOException e){
            return null;
        }
    }

    @GetMapping("/{id}")
    public Duck getDuck(@PathVariable int id) {
        try{
            return repository.getDuck(id);
        }catch(IOException e){
            return null;
        }
    }

    @PostMapping("/{id}/image")
    public void uploadImage(@PathVariable int id, @RequestParam("file") MultipartFile file) throws IOException {
        repository.uploadImage(id, file);
    }

    @GetMapping("/{id}/image")
    public byte[] downloadImage(@PathVariable int id) throws IOException {
        return repository.downloadImage(id);
    }

    @PostMapping("/{id}/audio")
    public void uploadAudio(@PathVariable int id, @RequestParam("file") MultipartFile file) throws IOException {
        repository.uploadAudio(id, file);
    }

    @GetMapping("/{id}/audio")
    public byte[] downloadAudio(@PathVariable int id) throws IOException {
        return repository.downloadAudio(id);
    }

    @GetMapping("/search")
    public List<Duck> search(@RequestParam("type") Type type) throws IOException {
        return repository.search(type);
    }
}
