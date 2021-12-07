package com.example.ltw_longptit.controller;

import com.example.ltw_longptit.model.HoTro;
import com.example.ltw_longptit.model.Kham;
import com.example.ltw_longptit.repo.HoTroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/hotro", produces = "application/json")
@CrossOrigin(origins = "*")
public class HoTroController {
    @Autowired
    private HoTroRepository hoTroRepository;
    @Autowired
    public HoTroController(HoTroRepository hoTroRepository) {
        this.hoTroRepository = hoTroRepository;
    }

    @GetMapping()
    public Iterable<HoTro> getAllHoTro() {
        return hoTroRepository.findAll();
    }

    @GetMapping("/{id}")
    public HoTro getHoTroById(@PathVariable("id") int id) {
        Optional<HoTro> optionalHoTro = hoTroRepository.findById(id);
        if (optionalHoTro.isPresent()) {
            return optionalHoTro.get();
        }
        return null;
    }

    @PostMapping(consumes = "application/json")
    public HoTro postHoTro(@RequestBody HoTro hoTro) {
        return hoTroRepository.save(hoTro);
    }

    @PutMapping("/{id}")
    public HoTro putHoTro(@RequestBody HoTro hoTro) {
        return hoTroRepository.save(hoTro);
    }

    @DeleteMapping("/{id}")
    public void deleteHoTro(@PathVariable("id") Integer id) {
        try {
            hoTroRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }

    @GetMapping("dsYtaFromKhamId/{id}")
    public Iterable<HoTro> getYtaFromKhamId(@PathVariable("id") String id) {
        return hoTroRepository.getYTaTheoIdKham(id);
    }

    @GetMapping("tk/yta/{keyword}/{id}")
    public  Iterable<HoTro> getHoTroByIdYta(@PathVariable("keyword") String keyword, @PathVariable("id") String id) {
        return hoTroRepository.getHoTroTheoIdYTa(keyword, id);
    }
}
