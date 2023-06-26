package com.example.ideas.category.dto;

import lombok.Data;

import java.util.UUID;
@Data
public class CategoryWithStatisticsDto {

    private UUID id;

    private String name;

    private long questions;

    private long answers;

    public CategoryWithStatisticsDto(UUID id, String name, long questions, long answers) {
        this.id = id;
        this.name = name;
        this.questions = questions;
        this.answers = answers;
    }
}
