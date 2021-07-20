package com.example.demo.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "question_typed")
public class QuestionType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long questionTypedId;
    private String questionTypedName;

    public QuestionType() {
    }

    public long getQuestionTypedId() {
        return questionTypedId;
    }

    public void setQuestionTypedId(long questionTypedId) {
        this.questionTypedId = questionTypedId;
    }

    public String getQuestionTypedName() {
        return questionTypedName;
    }

    public void setQuestionTypedName(String questionTypedName) {
        this.questionTypedName = questionTypedName;
    }
}
