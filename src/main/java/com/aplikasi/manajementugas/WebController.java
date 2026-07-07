package com.aplikasi.manajementugas;

import com.aplikasi.manajementugas.dto.TugasRequest;
import com.aplikasi.manajementugas.model.Tugas;
import com.aplikasi.manajementugas.service.TugasService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/web")
public class WebController {

    private final TugasService tugasService;

    // Constructor Injection menggantikan @Autowired
    public WebController(TugasService tugasService) {
        this.tugasService = tugasService;
    }

    @GetMapping("/tugas")
    public String halamanUtama(Model model) {
        model.addAttribute("tugasBaru", new TugasRequest());
        model.addAttribute("tugasEdit", new TugasRequest());
        try {
            List<Tugas> listTugas = tugasService.getAllTugas();
            model.addAttribute("semuaTugas", listTugas);
        } catch (Exception e) {
            model.addAttribute("semuaTugas", new java.util.ArrayList<Tugas>());
        }
        return "index";
    }

    @PostMapping("/tambah")
    public String tambahTugasDariWeb(@ModelAttribute("tugasBaru") TugasRequest request) {
        tugasService.createTugas(request);
        return "redirect:/web/tugas";
    }

    @PostMapping("/ubah/{id}")
    public String ubahTugasDariWeb(@PathVariable("id") Long id, @ModelAttribute("tugasEdit") TugasRequest request) {
        tugasService.updateTugas(id, request);
        return "redirect:/web/tugas";
    }

    @GetMapping("/hapus/{id}")
    public String hapusTugasDariWeb(@PathVariable("id") Long id) {
        tugasService.deleteTugas(id);
        return "redirect:/web/tugas";
    }
}
