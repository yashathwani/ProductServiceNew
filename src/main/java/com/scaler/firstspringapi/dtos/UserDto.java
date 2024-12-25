
package com.scaler.firstspringapi.dtos;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import com.scaler.firstspringapi.models.Role;

@Getter
@Setter
public class UserDto {

    private String name;
    private String email;
    private List<Role> roles;

}

