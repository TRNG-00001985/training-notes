package com.example.demo.model;

import com.example.demo.model.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class User {
	private long id; 
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Role role ;

}
