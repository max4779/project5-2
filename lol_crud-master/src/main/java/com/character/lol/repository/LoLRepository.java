package com.character.lol.repository;

import com.character.lol.entity.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoLRepository extends JpaRepository<CharacterEntity, String> {

}
