package com.example.system.controllers.repositories;


import com.example.system.controllers.enteties.Temperature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface TempRepository extends JpaRepository<Temperature, Long> {

}
