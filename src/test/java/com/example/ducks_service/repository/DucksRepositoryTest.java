package com.example.ducks_service.repository;

import com.example.ducks_service.model.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DucksRepositoryTest {

    private DucksRepository ducksRepository;

    @TempDir
    Path tempDir;

    @BeforeEach
    void setUp() throws IOException {
        Path databasePath = tempDir.resolve("db.txt");
        Files.createFile(databasePath);
        ducksRepository = new DucksRepository(databasePath);
    }

    @Test
    void testAddDuck_Success() throws IOException {
        Duck duck = new MallardDuck(1);
        assertTrue(ducksRepository.addDuck(duck));
    }

    @Test
    void testAddDuck_Persisted() throws IOException {
        Duck duck = new RedheadDuck(2);
        ducksRepository.addDuck(duck);

        List<Duck> ducks = ducksRepository.getAllDucks();
        assertEquals(1, ducks.size());
        assertEquals(2, ducks.get(0).getId());
    }

    @Test
    void testGetDuck_Found() throws IOException {
        Duck duck = new RubberDuck(3);
        ducksRepository.addDuck(duck);

        Duck retrievedDuck = ducksRepository.getDuck(3);
        assertNotNull(retrievedDuck);
        assertEquals(3, retrievedDuck.getId());
    }

    @Test
    void testGetAllDucks() throws IOException {
        ducksRepository.addDuck(new MallardDuck(1));
        ducksRepository.addDuck(new RedheadDuck(2));

        List<Duck> ducks = ducksRepository.getAllDucks();
        assertEquals(2, ducks.size());
    }

    @Test
    void testSearch_ByType() throws IOException {
        ducksRepository.addDuck(new MallardDuck(1));
        ducksRepository.addDuck(new RedheadDuck(2));

        List<Duck> result = ducksRepository.search(Type.MALLARD);
        assertEquals(1, result.size());
        assertEquals(Type.MALLARD, result.get(0).getType());
    }
}
