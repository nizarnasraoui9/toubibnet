package com.toubibnet.toubibnet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.EAGER;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String firstName;
    String lastName;
    String email;
    Integer phoneNumber;
    String password;
    
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonIgnore
    List<Appointment> appointments=new ArrayList<>();
	
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonIgnore
    List<Question>questionList=new ArrayList<>();
    
    @ManyToMany(fetch = EAGER)
    @JoinTable(name="user_role",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="role_id"))
    private List<Role> roles = new ArrayList<>();


}
