package week2.Streams.model;

import java.util.Objects;

public class User {
    private String name;
    private String surname;
    private Sex sex;

    public User(String name, String surname, Sex sex) {
        this.name = name;
        this.surname = surname;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Sex getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", sex=" + sex +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(surname, user.surname) &&
                sex == user.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, sex);
    }
}
