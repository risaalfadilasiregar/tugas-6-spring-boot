package com.example.demo.controller;

import com.example.demo.entity.dto.SupplierDTO;
import com.example.demo.service.impl.SupplierServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    private SupplierServiceImpl service;

    @GetMapping("/find-all")
    public ResponseEntity<?> findAllData(){
        return new ResponseEntity<>(service.findAllData() , HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateData(@PathVariable Long id,
                                        @RequestBody SupplierDTO param){
       return new ResponseEntity<>(service.update(param, id), HttpStatus.OK);

    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<?>findById(@PathVariable Long id){
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @GetMapping("/find-by-id")
    public ResponseEntity<?>findById2(@RequestParam(name = "id") Long id){
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>deleteData(@PathVariable Long id){
        if (service.delete(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }

}
