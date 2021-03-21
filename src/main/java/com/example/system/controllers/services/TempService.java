package com.example.system.controllers.services;




import com.example.system.controllers.enteties.Temperature;
import com.example.system.controllers.repositories.TempRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class TempService {
    @Autowired
    private final TempRepository tempRepository;

    @Autowired
    CityService cityService;

    @Autowired
    public TempService(TempRepository tempRepository) {
        this.tempRepository=tempRepository;
    }

    public void addTemp(float val, Date day,Long cityId){
        Temperature t =new Temperature(val,day,cityId);
        tempRepository.save(t);
    }
    public double [] getAllTempsByYears(String cityName){
        double answ[]=new double[20];
        Long cityId=cityService.findByName(cityName).getId();
        List<Temperature> temps=tempRepository.findAllByCityId(cityId);
        int idx;
        int prevIdx=0;
        double temp=0;
        for(int i=0;i<temps.size();i++){
            idx=i/360;
            temp+= temps.get(i).getTemp();
            if(idx!=prevIdx||i==temps.size()-1){
                prevIdx=idx;
                answ[idx-1]=temp/360;
                temp=0;
            }
        }
        return answ;
    }

    public double [] getAllTempsByMounths(String cityName){
        double answ[]=new double[20*12];
        Long cityId=cityService.findByName(cityName).getId();
        List<Temperature> temps=tempRepository.findAllByCityId(cityId);
        int idx;
        int prevIdx=0;
        double temp=0;
        for(int i=0;i<temps.size();i++){
            idx=i/360;
            temp+= temps.get(i).getTemp();
            if(idx!=prevIdx||i==temps.size()-1){
                prevIdx=idx;
                answ[idx-1]=temp/360;
                temp=0;
            }
        }
        return answ;
    }
    public double [] getAllTempsByDays(String cityName){
        double answ[]=new double[20*12*365];
        Long cityId=cityService.findByName(cityName).getId();
        List<Temperature> temps=tempRepository.findAllByCityId(cityId);
        for(int i=0;i<temps.size();i++){
            answ[i]=temps.get(i).getTemp();
        }
        return answ;
    }
}