package com.character.lol.entity;

import com.character.lol.dto.CharacterDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.ui.Model;


@Entity(name = "lol")
@Table(name = "lol")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacterEntity {
    @Id
    private String name;
    private String line;
    private Boolean adAp;
    private String image;
    private Integer health;
    private Integer attack;
    private Integer speed;
    private String rune;

    public CharacterEntity(CharacterDto dto) {
        this.name = dto.getName();
        this.line = dto.getLine();
        this.adAp = dto.getAdAp();
        this.image = dto.getImage();
        this.health = dto.getHealth();
        this.attack = dto.getAttack();
        this.speed = dto.getSpeed();
        this.rune = dto.getRune();

    }

    //챔피언 이름, 가는 라인, ad or ap, 사진, 체력, 공격력, 이동속도, 룬
}
