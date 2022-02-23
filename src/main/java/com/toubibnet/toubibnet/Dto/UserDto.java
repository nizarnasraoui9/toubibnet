package com.toubibnet.toubibnet.Dto;

import com.toubibnet.toubibnet.Model.Appointment;
import com.toubibnet.toubibnet.Model.Question;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    Long id;
    String firstName;
    String lastName;
    String email;
    Integer phoneNumber;
    List<Appointment> appointments=new ArrayList<>();
    List<Question>questionList=new ArrayList<>();
}
