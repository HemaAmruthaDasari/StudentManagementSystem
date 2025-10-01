package com.example.springboot.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

import com.example.springboot.Entity.Student;
import com.example.springboot.Repository.StudentRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private StudentRepository studentRepository;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Student student = studentRepository.findByEmail(email).orElseThrow(()->new UsernameNotFoundException(String.format("User with email: %s is not fount",email)));
		Set<String> roles = new HashSet<String>();
		roles.add("ROLE_ADMIN");
		return new User(student.getEmail(), student.getPassword(),userAuthorities(roles));
	}
	
	private Collection<? extends GrantedAuthority> userAuthorities(Set<String> roles){
		return roles.stream().map(
				role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList());
	}

}
