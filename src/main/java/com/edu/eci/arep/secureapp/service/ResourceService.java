package com.edu.eci.arep.secureapp.service;

import com.edu.eci.arep.secureapp.exception.ResourceNotFoundException;
import com.edu.eci.arep.secureapp.model.Resource;
import com.edu.eci.arep.secureapp.repository.ResourceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceService {
    private final ResourceRepository repo;
    public ResourceService(ResourceRepository repo){ this.repo = repo; }

    public Resource create(Resource p){ return repo.save(p); }
    public List<Resource> findAll(){ return repo.findAll(); }
    public Resource findById(Long id){ return repo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Property not found")); }
    public Resource update(Long id, Resource in){
        Resource p = findById(id);
        p.setAddress(in.getAddress()); p.setPrice(in.getPrice());
        p.setSize(in.getSize()); p.setDescription(in.getDescription());
        return repo.save(p);
    }
    public void delete(Long id){ repo.deleteById(id); }
}

