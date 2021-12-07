package com.example.frontend.Controller;

import com.example.frontend.enity.YTa;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/yta")
public class YTaController {
    private RestTemplate rest = new RestTemplate();

    @GetMapping("/current")
    public String yTaForm(Model model) {
        List<YTa> yTaList = Arrays.asList(rest.getForObject("http://localhost:8080/yta",YTa[].class));
        model.addAttribute("listYta", yTaList);
        return "yta/dsYTa";
    }

    @GetMapping("/create")
    public String createYTa(Model model) {
       // List<YTa> yTaList = Arrays.asList(rest.getForObject("http://localhost:8080/yta",YTa[].class));
       //model.addAttribute("listYta", yTaList);
        YTa yta = new YTa();
        model.addAttribute("yta", yta);
        return "yta/addYTa";
    }



    @PostMapping("/save")
    public String save(YTa yta) {
        //yta.setYtaThamNien(5);

        rest.postForObject("http://localhost:8080/yta",yta, YTa.class);
        System.out.println(yta.toString());
        return "redirect:/yta/current";
    }

    @GetMapping("/update")
    public String edit(@RequestParam("id") String id, Model model) {

    YTa yTa =rest.getForObject("http://localhost:8080/yta/{id}", YTa.class,id);
    model.addAttribute("yta", yTa);
    return "/yta/editYTa";

    }

    @PostMapping("/saveEdit")
    public String update(YTa yTa) {
        System.out.println(yTa.getId());
        rest.put("http://localhost:8080/yta/{id}", yTa, yTa.getId());
        return "redirect:/yta/current";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") String id) {
        rest.delete("http://localhost:8080/yta/{id}", id);
        return "redirect:/yta/current";
    }

    @GetMapping("/search")
    public String search(@RequestParam("keywordabc") String keyword, Model model) {
        if (keyword.equals(""))  return "redirect:/yta/current";
        List<YTa> yTaList = Arrays.asList(rest.getForObject("http://localhost:8080/yta/search/{keyword}",YTa[].class, keyword));
        model.addAttribute("listYta", yTaList);
        return "/yta/dsYTa";
    }











}
