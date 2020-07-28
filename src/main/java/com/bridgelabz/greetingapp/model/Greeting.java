package com.bridgelabz.greetingapp.model;

public class Greeting {

    public int greetingId;

    public String greetingMessage;

    public Greeting(String greetingMessage) {
        this.greetingMessage = greetingMessage;
    }

    public Greeting() {

    }

    public int getGreetingId() {
        return greetingId;
    }

    public void setGreetingId(int greetingId) {
        this.greetingId = greetingId;
    }

    public String getGreetingMessage() {
        return greetingMessage;
    }

    public void setGreetingMessage(String greetingMessage) {
        this.greetingMessage = greetingMessage;
    }
}
