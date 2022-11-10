package com.example.demo.controller;

import com.example.demo.production.Production;
import com.example.demo.service.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductionController {
    private final ProductionService productionService;

    @Autowired
    public ProductionController(ProductionService productionService){
        this.productionService = productionService;
    }

    @PostMapping(value = "/productions")
    public ResponseEntity<?> create(@RequestBody Production prod) {
        productionService.create(prod);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/productions")
    public ResponseEntity<List<Production>> read() {
        final List<Production> productions = productionService.readAll();

        return productions != null &&  !productions.isEmpty()
                ? new ResponseEntity<>(productions, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/productions/{id}")
    public ResponseEntity<Production> read(@PathVariable(name = "id") int id) {
        final Production prod = productionService.read(id);

        return prod != null
                ? new ResponseEntity<>(prod, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/productions/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Production prod) {
        final boolean updated = productionService.update(prod, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/productions/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = productionService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
