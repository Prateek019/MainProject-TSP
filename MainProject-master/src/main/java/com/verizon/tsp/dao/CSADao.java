package com.verizon.tsp.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verizon.tsp.models.CSA;
import com.verizon.tsp.models.TelecomCircle;
import com.verizon.tsp.models.Tickets;
import com.verizon.tsp.models.User;

@Repository
public interface CSADao extends JpaRepository<CSA, Long>{

     List<CSA> findByTc(TelecomCircle tc);
}
