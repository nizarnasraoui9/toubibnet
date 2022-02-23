package com.toubibnet.toubibnet.Mapper;

import com.toubibnet.toubibnet.Dto.UserDto;
import com.toubibnet.toubibnet.Model.Appointment;
import com.toubibnet.toubibnet.Model.Question;
import com.toubibnet.toubibnet.Model.User;
import org.mapstruct.Mapper;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMaper extends GenericMapper<User, UserDto>{

}
