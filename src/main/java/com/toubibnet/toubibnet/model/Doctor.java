package com.toubibnet.toubibnet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@Data
public class Doctor extends User{
    @Enumerated(EnumType.STRING)
    Speciality speciality;
    
    @Enumerated(EnumType.STRING)
    Governorate governotate;
   
	@OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL)
    @JsonIgnore
    List<Appointment> appointmentList=new ArrayList<>();
    
    @OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL)
    @JsonIgnore
    List<Article>articles=new ArrayList<>();
    
    @OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL)
    @JsonIgnore
    List<Answer>answers=new ArrayList<>();
    
    @Override
	public String toString() {
		return "Doctor [speciality=" + speciality + ", governotate=" + governotate + ", id=" + id + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", password=" + password + ", appointments=" + appointments + ", questionList=" + questionList + "]";
	}
    
	public Doctor() {
		super();
	}
	
	public Doctor(Speciality speciality, Governorate governotate) {
		super();
		this.speciality = speciality;
		this.governotate = governotate;
	}

	public Speciality getSpeciality() {
		return speciality;
	}

	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}

	public Governorate getGovernotate() {
		return governotate;
	}

	public void setGovernotate(Governorate governotate) {
		this.governotate = governotate;
	}
}
