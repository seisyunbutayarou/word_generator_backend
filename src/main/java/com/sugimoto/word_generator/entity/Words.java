package com.sugimoto.word_generator.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Words {

    @Id
    private Long id;
    
    private String word;
    
    private String meaning;
}
