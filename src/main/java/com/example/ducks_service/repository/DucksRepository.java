package com.example.ducks_service.repository;

import com.example.ducks_service.model.*;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class DucksRepository {
    private static final String NEW_LINE = System.lineSeparator();

    private static final String DATABASE_NAME = "db.txt";

    private static final String imagePath = "ducks/images/";
    private static final String audioPath = "ducks/audio/";

    private static void appendToFile(Path path, String content) throws IOException{
        Files.write(path, content.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    public boolean addDuck(Duck duck) throws IOException{
        Path path = Paths.get(DATABASE_NAME);

        String data = duck.toString();

        appendToFile(path, data + NEW_LINE);
        return true;
    }

    public List<Duck> getAllDucks() throws IOException{
        List<Duck> result = new ArrayList<>();
        Path path = Paths.get(DATABASE_NAME);

        List<String> data = Files.readAllLines(path);

        for(String line: data){
            String[] words = line.split(", ");
            Duck d;
            switch (words[1]) {
                case "MALLARD" -> d = new MallardDuck(Integer.parseInt(words[0]));
                case "REDHEAD" -> d = new RedheadDuck(Integer.parseInt(words[0]));
                case "RUBBER_DUCK" -> d = new RubberDuck(Integer.parseInt(words[0]));
                case "DECOY_DUCK" -> d = new DecoyDuck(Integer.parseInt(words[0]));
                default -> d = null;
            }
            result.add(d);
        }

        return result;
    }

    public Duck getDuck(int id) throws IOException {
        List<Duck> ducks = getAllDucks();
        return ducks.stream().filter(d -> d.getId() == id).findFirst().orElse(null);
    }

    public List<Duck> search(Type type) throws IOException {
        List<Duck> ducks = getAllDucks();
        return ducks.stream().filter(d -> d.getType() == type).toList();
    }

    public void uploadImage(int id, MultipartFile file) throws IOException {
        Path path = Paths.get(imagePath + id + ".png");
        Files.createDirectories(path.getParent());
        Files.write(path, file.getBytes());
    }

    public byte[] downloadImage(int id) throws IOException {
        Path path = Paths.get(imagePath + id + ".png");
        return Files.readAllBytes(path);
    }

    public void uploadAudio(int id, MultipartFile file) throws IOException {
        Path path = Paths.get(audioPath + id + ".mp3");
        Files.createDirectories(path.getParent());
        Files.write(path, file.getBytes());
    }

    public byte[] downloadAudio(int id) throws IOException {
        Path path = Paths.get(audioPath + id + ".mp3");
        return Files.readAllBytes(path);
    }
}
