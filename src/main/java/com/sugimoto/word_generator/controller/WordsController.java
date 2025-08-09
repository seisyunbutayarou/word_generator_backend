package com.sugimoto.word_generator.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sugimoto.word_generator.entity.Words;
import com.sugimoto.word_generator.repository.WordsRepository;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class WordsController {

    private final WordsRepository wordsRepository;

    public WordsController(WordsRepository wordsRepository) {
        this.wordsRepository = wordsRepository;
    }

    @PostMapping("/words")
    public ResponseEntity<List<Words>> getRandomWord(@RequestBody Map<String, Integer> payload) {
        int num = payload.get("num");
    
        List<Words> wordsList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Words word = wordsRepository.findRandomWord();
            wordsList.add(word);
        }

        return ResponseEntity.ok(wordsList);
    }
}

