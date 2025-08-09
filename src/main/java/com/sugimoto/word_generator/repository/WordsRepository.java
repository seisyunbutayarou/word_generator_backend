package com.sugimoto.word_generator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sugimoto.word_generator.entity.Words;

@Repository
public interface WordsRepository extends JpaRepository<Words, Long> {
    @Query(value = "SELECT * FROM words ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Words findRandomWord();
}
