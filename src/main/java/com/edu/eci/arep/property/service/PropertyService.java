package com.edu.eci.arep.property.service;

import com.edu.eci.arep.property.exception.PropertyNotFoundException;
import com.edu.eci.arep.property.model.Property;
import com.edu.eci.arep.property.repository.PropertyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {
    private final PropertyRepository repo;
    public PropertyService(PropertyRepository repo){ this.repo = repo; }

    public Property create(Property p){ return repo.save(p); }
    public List<Property> findAll(){ return repo.findAll(); }
    public Property findById(Long id){ return repo.findById(id)
            .orElseThrow(() -> new PropertyNotFoundException("Property not found")); }
    public Property update(Long id, Property in){
        Property p = findById(id);
        p.setAddress(in.getAddress()); p.setPrice(in.getPrice());
        p.setSize(in.getSize()); p.setDescription(in.getDescription());
        return repo.save(p);
    }
    public void delete(Long id){ repo.deleteById(id); }
}

