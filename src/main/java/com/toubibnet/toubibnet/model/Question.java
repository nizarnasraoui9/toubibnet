package com.toubibnet.toubibnet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
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
    @CreatedDate
    Date dateCreated;
    @LastModifiedDate
    Date dateModified;
    @Enumerated(EnumType.STRING)
    Category category;
}