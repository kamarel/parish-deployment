package com.parishservice.parishservice.Repository;

import com.parishservice.parishservice.Entity.Parish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ParishRepository extends JpaRepository<Parish, Long> {




}
