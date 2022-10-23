package com.game.entity;

import com.game.entity.enums.Profession;
import com.game.entity.enums.Race;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "title")
    String title;

    @Column(name = "race")
    @Enumerated(EnumType.STRING)
    Race race;

    @Column(name = "profession")
    @Enumerated(EnumType.STRING)
    Profession profession;

    @Column(name = "birthday")
    Date birthday;

    @Column(name = "experience")
    Integer experience;

    @Column(name = "level")
    Integer level;

    @Column(name = "untilNextLevel")
    Integer untilNextLevel;

    @Column(name = "banned")
    Boolean banned;
}
