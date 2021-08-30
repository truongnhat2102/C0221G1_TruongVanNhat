package com.example.demo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class QuestionDto {
    @NotBlank(message = "Your title is null !")
    @Size(min = 5,max = 100,message = "Size min 5 and max 100")
    private String title;
    @NotBlank(message = "Your question is null !")
    @Size(min = 10,max = 500,message = "Size min 10 and max 500")
    private String question;

    public QuestionDto(@NotBlank(message = "Your title is null !") @Size(min = 5, max = 100, message = "Size min 5 and max 100") String title, @NotBlank(message = "Your question is null !") @Size(min = 10, max = 500, message = "Size min 10 and max 500") String question) {
        this.title = title;
        this.question = question;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
