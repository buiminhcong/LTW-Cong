package com.example.ltw_longptit.controller;


import com.example.ltw_longptit.model.BenhNhan;
import com.example.ltw_longptit.model.HoTro;
import com.example.ltw_longptit.model.Kham;
import com.example.ltw_longptit.repo.KhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/kham", produces = "application/json")
@CrossOrigin(origins = "*")
public class KhamController {
    @Autowired
    private KhamRepository khamRepository;

    @Autowired
    public KhamController(KhamRepository khamRepository) {
            this.khamRepository = khamRepository;
    }

    @GetMapping
    public Iterable<Kham> getAllKham() {
        return khamRepository.findAll();
    }

    @GetMapping("/{id}")
    public Kham getKhamById(@PathVariable("id") int id) {
        Optional<Kham> optKham = khamRepository.findById(id);
        if (optKham.isPresent()) {
            return optKham.get();
        }
        return null;
    }

    @PostMapping(consumes = "application/json")
    public Kham postKham(@RequestBody Kham test) {
        return khamRepository.save(test);
    }

    @PutMapping("/{id}")
    public Kham putKham(@RequestBody Kham test) {
        return khamRepository.save(test);
    }

    @DeleteMapping("/{id}")
    public void deleteKham(@PathVariable("id") Integer id) {
        try {
            khamRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }

    @GetMapping("tk/bacsy/{keyword}/{id}")
    public Iterable<Kham> getKhamByBacsy(@PathVariable("keyword") String keyword , @PathVariable("id") String id) {
       List<Integer> list =  khamRepository.getAllKhamByBacSy(keyword, id);
       List<Kham> listKham = new ArrayList<>();

        for(int i=0 ; i<list.size() ; i++) {
            int idBn = list.get(i);
            listKham.add(khamRepository.getKham(String.valueOf(idBn), id));
        }

        return listKham;
    }

    @GetMapping("tk/benh/{keyword}")
    public Iterable<Kham> getKhamByDate(@PathVariable("keyword") String keyword) {
        return khamRepository.getAllKhamByThang(keyword);
    }

    @GetMapping("tk/benhnhan/{keyword}/{id}")
    public Iterable<Kham> getKhamByBenhNhan(@PathVariable("keyword") String keyword , @PathVariable("id") String id) {
        ArrayList<Kham> listKham = (ArrayList<Kham>) khamRepository.getAllKhamByBenhNhan(keyword, id);
        for(int i=0 ; i<listKham.size()-1; i++) {
                long maBenh = (int) listKham.get(i).getBenh().getId();
                long maBenh1 = listKham.get(i+1).getBenh().getId();
            String status =  listKham.get(i).getStatus();
            String status1 =  listKham.get(i+1).getStatus();

//            if( listKham.get(i).getBacSy().getId() != listKham.get(i+1).getBacSy().getId() ) {
//                continue;
//            }
            if(status.equals("normal") && status1.equals("have") && maBenh == maBenh1 ) {
                listKham.remove(i);
                i--;
                continue;
            }
            if(status1.equals("normal") && maBenh != maBenh1 ) {
                listKham.remove(i+1);
                continue;
            }
            if (maBenh == maBenh1) {
                    listKham.remove(i+1);
                    i--;
                }
            }
        return listKham;
    }

}
