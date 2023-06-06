package com.example.irfan.evstation.irfan.dao;

import com.example.irfan.evstation.irfan.entities.EvStation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvStationDao extends JpaRepository<EvStation,Long>  {
}
