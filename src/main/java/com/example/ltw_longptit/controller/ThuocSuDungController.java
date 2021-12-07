package com.example.ltw_longptit.controller;

import com.example.ltw_longptit.model.HoTro;
import com.example.ltw_longptit.model.ThuocSuDung;
import com.example.ltw_longptit.repo.HoTroRepository;
import com.example.ltw_longptit.repo.ThuocSuDungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/thuocsd", produces = "application/json")
@CrossOrigin(origins = "*")
public class ThuocSuDungController {

    @Autowired
    private ThuocSuDungRepository tsdRepository;
    @Autowired
    public ThuocSuDungController(ThuocSuDungRepository tsdRepository) {
        this.tsdRepository = tsdRepository;
    }

    @GetMapping()
    public Iterable<ThuocSuDung> getAllHoTro() {
        return tsdRepository.findAll();
    }

    @GetMapping("/{id}")
    public ThuocSuDung getThuocSdId(@PathVariable("id") int id) {
        Optional<ThuocSuDung> optionalThuocSd = tsdRepository.findById(id);
        if (optionalThuocSd.isPresent()) {
            return optionalThuocSd.get();
        }
        return null;
    }

    @PostMapping(consumes = "application/json")
    public ThuocSuDung postThuocsd(@RequestBody ThuocSuDung Thuocsd) {
        return tsdRepository.save(Thuocsd);
    }

    @PutMapping("/{id}")
    public ThuocSuDung putThuocsd(@RequestBody ThuocSuDung Thuocsd) {
        return tsdRepository.save(Thuocsd);
    }

    @DeleteMapping("/{id}")
    public void deleteThuocsd(@PathVariable("id") Integer id) {
        try {
            tsdRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }

    @GetMapping("thuoctronghoadon/{id}")
    public Iterable<ThuocSuDung> getThuocTrongHoaDon(@PathVariable("id") String id ) {
        return tsdRepository.statisticMedicineUsedbyPrescriptionId(id);
    }


}
