package com.keyboard.works.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keyboard.works.models.MutasiRekening;

@Repository
public interface MutasiRekeningRepository extends JpaRepository<MutasiRekening, Long> {

}
