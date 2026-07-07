package com.aplikasi.manajementugas.service;

import com.aplikasi.manajementugas.dto.TugasRequest;
import com.aplikasi.manajementugas.model.Tugas;
import java.util.List;

public interface TugasService {
    List<Tugas> getAllTugas();
    Tugas createTugas(TugasRequest request);
    Tugas updateTugas(Long id, TugasRequest request);
    void deleteTugas(Long id);
}
