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
@Table(name = "player", schema = "rpg")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @SequenceGenerator(name = "sequence", sequenceName = "sequence", allocationSize = 100)
    private long id;

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
    int experience;

    @Column(name = "level")
    int level;

    @Column(name = "untilNextLevel")
    int untilNextLevel;

    @Column(name = "banned")
    boolean banned;
}
