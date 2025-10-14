package com.edu.eci.arep.secureapp.controller;

import com.edu.eci.arep.secureapp.model.Resource;
import com.edu.eci.arep.secureapp.model.User;
import com.edu.eci.arep.secureapp.service.ResourceService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/properties")

public class ResourceController {

    private final ResourceService propertyService;
    public ResourceController(ResourceService svc){ this.propertyService = svc; }

    @PostMapping
    public ResponseEntity<Resource> create(@Valid @RequestBody Resource p){
        return ResponseEntity.status(HttpStatus.CREATED).body(propertyService.create(p));
    }

    @GetMapping
    public List<Resource> all(){ return propertyService.findAll(); }

    @GetMapping("/{id}")
    public Resource one(@PathVariable Long id){ return propertyService.findById(id); }

    @PutMapping("/{id}")
    public Resource update(@PathVariable Long id, @Valid @RequestBody Resource p){
        return propertyService.update(id, p);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        propertyService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        if ("admin".equals(user.getUsername()) && "1234".equals(user.getPassword())) {
            return "Login successful!";
        } else {
            return "Invalid credentials";
        }
    }
}

