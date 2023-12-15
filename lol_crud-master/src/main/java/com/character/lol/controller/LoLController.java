package com.character.lol.controller;

import com.character.lol.dto.CharacterDto;
import com.character.lol.service.LoLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoLController {
    @Autowired
    LoLService service;

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody CharacterDto dto) {
        ResponseEntity result = service.create(dto);
        return result;
    }

    @GetMapping("/readall")
    public ResponseEntity readall() {
        ResponseEntity response = service.readAll();
        return response;
    }
    @GetMapping("/read/{name}")
    public ResponseEntity read(@PathVariable String name){
        ResponseEntity response = service.readOne(name);
        return response;
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity delete(@PathVariable String name){
        ResponseEntity result = service.delete(name);
        return result;
    }

    @PutMapping("/update/{name}")
    public ResponseEntity update(@PathVariable String name, @RequestBody CharacterDto dto){
        ResponseEntity result = service.update(dto, name);
        return result;
    }
}
