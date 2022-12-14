package com.example.demo.Controlador;

import com.example.demo.Modelo.Farm;
import com.example.demo.Servicio.FarmService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jonathan
 */

@RestController
@RequestMapping("/api/Farm")
public class FarmController {
     @Autowired
    private FarmService farmService;
    
    @GetMapping("/all")
    public List<Farm> getAll(){
        return farmService.getAll();
    }
    
    @GetMapping("/(id)")
    public Optional<Farm> getFarm(@PathVariable("id") int id){
        return farmService.getFarm(id);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Farm save (@RequestBody Farm farm){
        return farmService.save(farm);
    }
}
