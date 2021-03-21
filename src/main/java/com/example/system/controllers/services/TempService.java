package com.example.system.controllers.services;




import com.example.system.controllers.enteties.Temperature;
import com.example.system.controllers.repositories.TempRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class TempService {
    @Autowired
    private final TempRepository tempRepository;

    @Autowired
    public TempService(TempRepository tempRepository) {
        this.tempRepository=tempRepository;
    }

    public void addTemp(float val, Date day,Long cityId){
        Temperature t =new Temperature(val,day,cityId);
        tempRepository.save(t);
    }
}