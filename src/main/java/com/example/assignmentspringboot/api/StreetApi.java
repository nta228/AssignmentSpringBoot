package com.example.assignmentspringboot.api;

import com.example.assignmentspringboot.entity.Street;
import com.example.assignmentspringboot.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/streets")
public class StreetApi {
    @Autowired
    StreetService streetService;
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Street> save(@RequestBody Street street){
        return ResponseEntity.ok(streetService.save(street));
    }
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Street>> findAll() {
        return ResponseEntity.ok(streetService.findAll());
    }

    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        Optional<Street> street = streetService.findById(id);
        if (!street.isPresent()){
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(street.get());
    }

    @RequestMapping(method = RequestMethod.PUT, path = "{id}")
    public ResponseEntity<Street> update(@PathVariable int id, @RequestBody Street street) {
        Optional<Street> streetId = streetService.findById(id);
        if (!streetId.isPresent()){
            ResponseEntity.badRequest().build();
        }
        Street exitsStreet = streetId.get();
        exitsStreet.setName(street.getName());
        exitsStreet.setDistrict(street.getDistrict());
        exitsStreet.setFoundingDate(street.getFoundingDate());
        exitsStreet.setDescription(street.getDescription());
        exitsStreet.setStatus(street.getStatus());
        return ResponseEntity.ok(streetService.save(exitsStreet));
    }
    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        Optional<Street> street = streetService.findById(id);
        if (!street.isPresent()){
            ResponseEntity.badRequest().build();
        }
        streetService.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
