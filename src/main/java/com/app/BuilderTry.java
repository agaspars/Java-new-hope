package com.app;

import com.app.model.ObjectWithBuilder;

public class BuilderTry {
    public static void main(String[] args) {
        ObjectWithBuilder person = new ObjectWithBuilder.Builder()
                .withName("Dmitrijs")
                .withSurname("The Tester")
                .withAge(35)
                .withPhone("+37122222222")
                .withEmail("test@test.lv")
                .build();
    }
}
