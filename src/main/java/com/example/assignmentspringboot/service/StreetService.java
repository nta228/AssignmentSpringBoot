package com.example.assignmentspringboot.service;

import com.example.assignmentspringboot.entity.Street;
import com.example.assignmentspringboot.repository.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StreetService {
    @Autowired
    private StreetRepository streetRepository;
    public List<Street> findAll(){return streetRepository.findAll();}
    public Optional<Street> findById(int id){return streetRepository.findById(id);}
    public Street save(Street streets) {return streetRepository.save(streets);}
    public void deleteById(int id){ streetRepository.deleteById(id);}
}
