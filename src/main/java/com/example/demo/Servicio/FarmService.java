package com.example.demo.Servicio;

import com.example.demo.Modelo.Farm;
import com.example.demo.Repositorio.FarmRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jonathan
 */

@Service
public class FarmService {
    @Autowired
    
    private FarmRepository farmRepository;
    
    public List<Farm> getAll(){
        return farmRepository.getAll();
    }
    
    public Optional<Farm> getFarm(int id){
        return farmRepository.getFarm(id);    
    }
    
    public Farm save (Farm farm){
        if(farm.getId() == null){
            return farmRepository.save(farm);
        } else {
            Optional<Farm> farm1 = farmRepository.getFarm(farm.getId());
            if (farm1.isEmpty()){
                return farmRepository.save(farm);
            }else{
                return farm;
            }
        }
    }
}
