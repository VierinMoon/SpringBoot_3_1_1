package ru.vierinmoon.springboot.demo.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private Long id;

    @Column(name = "name", nullable = false)
    @NotBlank(message = "Name cannot be blank")
    @Size(min =  2, max =  50, message = "Name must be between  2 and  50 characters")
    private String name;

    @Column(name = "surname", nullable = false)
    @NotBlank(message = "Surname cannot be blank")
    @Size(min =  2, max =  100, message = "Surname must be between  2 and  100 characters")
    private String surname;

    @Column(name = "age", nullable = false)
    @Min(value =  18, message = "Age must be at least  18")
    @Max(value =  100, message = "Age must not exceed  100")
    private Integer age;

    public User() {
    }

    public User(String name, String surmane, Integer age) {
        this.name = name;
        this.surname = surmane;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(age, user.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, age);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
