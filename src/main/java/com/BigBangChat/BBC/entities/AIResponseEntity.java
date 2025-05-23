package com.BigBangChat.BBC.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class AIResponseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "user_message_id")
    @   JsonBackReference // This is the "back" part that won't be serialized
    private MessageEntity userMessage;

    @Column(columnDefinition = "LONGTEXT")
    private String deepSeekResponse;

    @Column(columnDefinition = "LONGTEXT")
    private String geminiResponse;

    @Column(columnDefinition = "LONGTEXT")
    private String finalSelectedResponse; // AI-selected best response

    // Constructors
    public AIResponseEntity() {}

    public AIResponseEntity(MessageEntity userMessage, String deepSeekResponse, String geminiResponse) {
        this.userMessage = userMessage;
        this.deepSeekResponse = deepSeekResponse;
        this.geminiResponse = geminiResponse;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer  id) {
        this.id = id;
    }

    public MessageEntity getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(MessageEntity userMessage) {
        this.userMessage = userMessage;
    }

    public String getDeepSeekResponse() {
        return deepSeekResponse;
    }

    public void setDeepSeekResponse(String deepSeekResponse) {
        this.deepSeekResponse = deepSeekResponse;
    }

    public String getGeminiResponse() {
        return geminiResponse;
    }

    public void setGeminiResponse(String geminiResponse) {
        this.geminiResponse = geminiResponse;
    }

    public String getFinalSelectedResponse() {
        return finalSelectedResponse;
    }

    public void setFinalSelectedResponse(String finalSelectedResponse) {
        this.finalSelectedResponse = finalSelectedResponse;
    }

}
