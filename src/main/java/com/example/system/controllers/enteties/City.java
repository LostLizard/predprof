package com.example.system.controllers.enteties;


import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "city")
public class City {

    @Column(name = "id")
    private Long id;

    public City(){

    }
    public City(String  name){
        setName(name);
    }
    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GenericGenerator(name = "seq", strategy = "increment")
    @GeneratedValue(generator = "seq")
    @Column(name = "id")
    public Long getId() {
        return id;
    }
}
