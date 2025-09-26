package com.edu.eci.arep.property.controller;

import com.edu.eci.arep.property.model.Property;
import com.edu.eci.arep.property.service.PropertyService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/properties")

public class PropertyController {

    private final PropertyService propertyService;
    public PropertyController(PropertyService svc){ this.propertyService = svc; }

    @PostMapping
    public ResponseEntity<Property> create(@Valid @RequestBody Property p){
        return ResponseEntity.status(HttpStatus.CREATED).body(propertyService.create(p));
    }

    @GetMapping
    public List<Property> all(){ return propertyService.findAll(); }

    @GetMapping("/{id}")
    public Property one(@PathVariable Long id){ return propertyService.findById(id); }

    @PutMapping("/{id}")
    public Property update(@PathVariable Long id, @Valid @RequestBody Property p){
        return propertyService.update(id, p);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        propertyService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

