package com.character.lol.dto;

import lombok.Data;

@Data
public class CharacterDto {
    private String name;
    private String line;
    private Boolean adAp;
    private String image;
    private Integer health;
    private Integer attack;
    private Integer speed;
    private String rune;
}
