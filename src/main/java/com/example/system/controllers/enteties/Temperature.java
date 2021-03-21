package com.example.system.controllers.enteties;


import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "temperature")
public class Temperature {
    @Column(name = "cityId")
    private Long cityId;
    @Column(name = "temp")
    private float temp;
    @Column(name = "day")
    private Date day;
    @Column(name = "id")
    private Long id;

    public  Temperature(){

    }
    public Temperature(float value,Date day,Long cityId){
        setCityId(cityId);
        setDay(day);
        setTemp(value);
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

    public Long getCityId(){
        return  this.cityId;
    }
    public void setCityId(Long cityId){
        this.cityId=cityId;
    }

    public void setDay(Date day){
        this.day=day;
    }

    public Date getDay() {
        return day;
    }

    public float getTemp() {
        return this.temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }
}