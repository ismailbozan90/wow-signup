package com.raidtool.signup.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "event_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDetail {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "event_id")
    private Long eventId;

    @Column(name = "character_id")
    private Long characterId;

    @Column(name = "status")
    private int status;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "spec")
    private int spec;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", referencedColumnName = "character_id")
    private List<Character> character;

}
