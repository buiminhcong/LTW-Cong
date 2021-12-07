package com.example.frontend.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.*;
import com.example.frontend.enity.BacSi;
import java.util.*;
@Controller
public class BacSiController {
    private RestTemplate rest = new RestTemplate();

    @GetMapping("/bacsi")
    public ModelAndView addModeltoView()
    {
        List<BacSi> listBacSi = Arrays.asList(rest.getForObject("http://localhost:8089/bacsi", BacSi[].class));
        ModelAndView modelAndView = new ModelAndView("/bacsi/dsBacSi");
        modelAndView.addObject("listBacsi",listBacSi);
        return modelAndView;
    }

    @GetMapping("bacsi/them-moi")
    public String addNew(Model model)
    {
        BacSi bacsi = new BacSi();
        model.addAttribute("bacsi",bacsi);
        return "/bacsi/addBacSi";
    }

    @PostMapping("bacsi/luu")
    public String save(BacSi bacsi)
    {
        bacsi.setBacsyBacNghe(bacsi.getBacsyBacNghe());
        bacsi.setBacsyChuyenMon(bacsi.getBacsyChuyenMon());
        bacsi.setBacsyCMT(bacsi.getBacsyCMT());
        bacsi.setBacsyDiaChi(bacsi.getBacsyDiaChi());
        bacsi.setBacsyNgaySinh(bacsi.getBacsyNgaySinh());
        bacsi.setBacsySDT(bacsi.getBacsySDT());
        bacsi.setBacsyTen(bacsi.getBacsyTen());
        bacsi.setBacsyTrinhDoDaoTao(bacsi.getBacsyTrinhDoDaoTao());
        bacsi.setBacsyThamNien(bacsi.getBacsyThamNien());
        rest.postForObject("http://localhost:8089/bacsi", bacsi, BacSi.class);
        return "redirect:/bacsi";
    }

    @PutMapping("bacsi/luu")
    public String update(BacSi bacsi)
    {
        bacsi.setBacsyBacNghe(bacsi.getBacsyBacNghe());
        bacsi.setBacsyChuyenMon(bacsi.getBacsyChuyenMon());
        bacsi.setBacsyCMT(bacsi.getBacsyCMT());
        bacsi.setBacsyDiaChi(bacsi.getBacsyDiaChi());
        bacsi.setBacsyNgaySinh(bacsi.getBacsyNgaySinh());
        bacsi.setBacsySDT(bacsi.getBacsySDT());
        bacsi.setBacsyTen(bacsi.getBacsyTen());
        bacsi.setBacsyTrinhDoDaoTao(bacsi.getBacsyTrinhDoDaoTao());
        bacsi.setBacsyThamNien(bacsi.getBacsyThamNien());
        rest.put("http://localhost:8089/bacsi", bacsi, bacsi.getId());
        return "redirect:/bacsi";
    }

    @RequestMapping("/bacsi/cap-nhat")
    public String edit(@RequestParam("id") int id ,Model model)
    {
        BacSi bacsiEdit = rest.getForObject("http://localhost:8089/bacsi/{id}", BacSi.class,id);
        model.addAttribute("bacsi",bacsiEdit);
        return "/bacsi/editBacSi";
    }

    @GetMapping("bacsi/xoa")
    public String delete(@RequestParam int id)
    {
        rest.delete("http://localhost:8089/bacsi/{id}",id);
        return "redirect:/bacsi";
    }

    @GetMapping("bacsi/tim-kiem")
    public ModelAndView search(@RequestParam String keyword,Model model)
    {
        List<BacSi> listBacsi = Arrays.asList(rest.getForObject("http://localhost:8089/bacsi/search/{keyword}", BacSi[].class,keyword));
        ModelAndView modelAndView = new ModelAndView("/doctor/dsBacSi");
        modelAndView.addObject("listBacsi",listBacsi);
        return modelAndView;
    }


}
