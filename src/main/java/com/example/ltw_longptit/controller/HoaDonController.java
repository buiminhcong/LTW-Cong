package com.example.ltw_longptit.controller;


import com.example.ltw_longptit.model.HoTro;
import com.example.ltw_longptit.model.HoaDon;
import com.example.ltw_longptit.repo.HoTroRepository;
import com.example.ltw_longptit.repo.HoaDonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/donthuoc", produces = "application/json")
@CrossOrigin(origins = "*")
public class HoaDonController {

    @Autowired
    private HoaDonRepository hoaDonRepository;
    @Autowired
    public HoaDonController(HoaDonRepository hoaDonRepository) {
        this.hoaDonRepository = hoaDonRepository;
    }

    @GetMapping()
    public Iterable<HoaDon> getAllHoaDonThuoc() {
        return hoaDonRepository.findAll();
    }

    @GetMapping("/{id}")
    public HoaDon getHoaDonById(@PathVariable("id") int id) {
        Optional<HoaDon> optionalHoaDon = hoaDonRepository.findById(id);
        if (optionalHoaDon.isPresent()) {
            return optionalHoaDon.get();
        }
        return null;
    }

    @PostMapping(consumes = "application/json")
    public HoaDon postHoaDon(@RequestBody HoaDon hoaDon) {
        return hoaDonRepository.save(hoaDon);
    }

    @PutMapping("/{id}")
    public HoaDon putHoaDon(@RequestBody HoaDon hoaDon) {
        return hoaDonRepository.save(hoaDon);
    }

    @DeleteMapping("/{id}")
    public void deleteHoaDon(@PathVariable("id") Integer id) {
        try {
            hoaDonRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }
}
