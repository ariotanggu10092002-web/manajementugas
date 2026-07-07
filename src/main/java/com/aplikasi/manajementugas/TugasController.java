package com.aplikasi.manajementugas;

import com.aplikasi.manajementugas.dto.TugasRequest;
import com.aplikasi.manajementugas.model.Tugas;
import com.aplikasi.manajementugas.service.TugasService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tugas")
public class TugasController {

    private final TugasService tugasService;

    // Constructor Injection menggantikan @Autowired
    public TugasController(TugasService tugasService) {
        this.tugasService = tugasService;
    }

    @GetMapping
    public List<Tugas> getAll() {
        return tugasService.getAllTugas();
    }

    @PostMapping
    public Tugas create(@RequestBody TugasRequest request) {
        return tugasService.createTugas(request);
    }

    @PutMapping("/{id}")
    public Tugas update(@PathVariable Long id, @RequestBody TugasRequest request) {
        return tugasService.updateTugas(id, request);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        tugasService.deleteTugas(id);
        return "Tugas berhasil dihapus";
    }
}
