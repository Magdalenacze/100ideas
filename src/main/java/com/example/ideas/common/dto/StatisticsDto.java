package com.example.ideas.common.dto;

import lombok.Data;

@Data
public class StatisticsDto {
    private long questions;
    private long answers;

    public StatisticsDto(long questions, long answers) {
        this.questions = questions;
        this.answers = answers;
    }
}
