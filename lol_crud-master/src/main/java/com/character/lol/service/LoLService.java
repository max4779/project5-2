package com.character.lol.service;

import com.character.lol.dto.CharacterDto;
import com.character.lol.entity.CharacterEntity;
import com.character.lol.repository.LoLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Service
public class LoLService {
    @Autowired
    private LoLRepository loLRepository;

    public ResponseEntity create(CharacterDto dto) {
        CharacterEntity character = new CharacterEntity(dto);
        loLRepository.save(character);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<List<CharacterEntity>> readAll() {
        List<CharacterEntity> all=loLRepository.findAll();
        return ResponseEntity.ok(all);
    }

    public ResponseEntity<CharacterEntity> readOne(String name) {
        CharacterEntity character =loLRepository.findById(name).get();
        return ResponseEntity.ok(character);
    }

    @Transactional
    public ResponseEntity update(CharacterDto dto, String name) {
        if (loLRepository.existsById(name)) {
            Optional<CharacterEntity> optionalCharacter=loLRepository.findById(name);
            CharacterEntity character = optionalCharacter.get();
            character.setName(dto.getName());
            character.setLine(dto.getLine());
            character.setImage(dto.getImage());
            character.setAdAp(dto.getAdAp());
            character.setHealth(dto.getHealth());
            character.setAttack(dto.getAttack());
            character.setSpeed(dto.getSpeed());
            character.setRune(dto.getRune());
        }
        return ResponseEntity.ok().build();
    }
    public ResponseEntity delete(String name){
        loLRepository.deleteById(name);
        return ResponseEntity.ok().build();
    }



}
