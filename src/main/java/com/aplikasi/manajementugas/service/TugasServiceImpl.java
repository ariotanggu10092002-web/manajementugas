package com.aplikasi.manajementugas.service;

import com.aplikasi.manajementugas.dto.TugasRequest;
import com.aplikasi.manajementugas.model.Tugas;
import com.aplikasi.manajementugas.repository.TugasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TugasServiceImpl implements TugasService {

    private final TugasRepository tugasRepository;

    // Constructor Injection menggantikan @Autowired
    public TugasServiceImpl(TugasRepository tugasRepository) {
        this.tugasRepository = tugasRepository;
    }

    @Override
    public List<Tugas> getAllTugas() {
        return tugasRepository.findAll();
    }

    @Override
    public Tugas createTugas(TugasRequest request) {
        Tugas tugas = new Tugas();
        tugas.setTitle(request.getTitle());
        tugas.setDescription(request.getDescription());
        return tugasRepository.save(tugas);
    }

    @Override
    public Tugas updateTugas(Long id, TugasRequest request) {
        Tugas tugas = tugasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tugas tidak ditemukan"));
        tugas.setTitle(request.getTitle());
        tugas.setDescription(request.getDescription());
        return tugasRepository.save(tugas);
    }

    @Override
    public void deleteTugas(Long id) {
        tugasRepository.deleteById(id);
    }
}
