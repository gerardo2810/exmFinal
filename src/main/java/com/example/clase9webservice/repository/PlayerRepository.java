package com.example.clase9webservice.repository;


import com.example.clase9webservice.entity.Juegos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Juegos, Integer> {

}
