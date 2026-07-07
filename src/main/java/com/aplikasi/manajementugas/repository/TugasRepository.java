package com.aplikasi.manajementugas.repository;

import com.aplikasi.manajementugas.model.Tugas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TugasRepository extends JpaRepository<Tugas, Long> {
}
