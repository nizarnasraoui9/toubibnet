package com.toubibnet.toubibnet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;
    String content;
    @ManyToOne
    @JoinColumn(name="user_id",referencedColumnName = "id")
    User user;
    @OneToMany(mappedBy = "question",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonIgnore
    List<Answer>questions=new ArrayList<>();
    Date date;
    @Enumerated(EnumType.STRING)
    Category category;
}