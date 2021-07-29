package com.app.model;

public class ObjectWithBuilder { //Заполнять объект можно через конструктор/сеттер/билдер
    private String name;        //Заполняя через конструктор падает читаемость кода(нет подсказок в github)
    private String surname;
    private int age;
    private String phone;
    private String email;

    public static class Builder {
        private ObjectWithBuilder objectWithBuilder;

        public Builder() {
            objectWithBuilder = new ObjectWithBuilder();
        }

        public Builder withName(String name) {
            objectWithBuilder.name = name;
            return this;
        }

        public Builder withSurname(String surname) {
            objectWithBuilder.surname = surname;
            return this;
        }

        public Builder withAge(int age) {
            objectWithBuilder.age = age;
            return this;
        }

        public Builder withPhone(String phone) {
            objectWithBuilder.phone = phone;
            return this;
        }

        public Builder withEmail(String email) {
            objectWithBuilder.email = email;
            return this;
        }

        public ObjectWithBuilder build() {
            return objectWithBuilder;
        }
    }
}
