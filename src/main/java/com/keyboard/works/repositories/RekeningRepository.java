package com.keyboard.works.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keyboard.works.models.Rekening;

@Repository
public interface RekeningRepository extends JpaRepository<Rekening, Long> {

}
