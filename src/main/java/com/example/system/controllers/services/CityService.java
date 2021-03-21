package com.example.system.controllers.services;




import com.example.system.controllers.repositories.CityRepository;
import com.example.system.controllers.repositories.TempRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class CityService {
    @Autowired
    private final CityRepository cityRepository;
    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository= cityRepository;
    }
}