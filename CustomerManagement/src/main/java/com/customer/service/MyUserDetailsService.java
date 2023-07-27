package com.customer.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.customer.model.Customer;
import com.customer.repository.CustomerRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        Customer customer = customerRepository.findByUsername(username);
//        if(customer != null) {
//            GrantedAuthority authority = new SimpleGrantedAuthority(customer.getRole());
//            return new User(customer.getUsername(), customer.getPassword(),Arrays.asList(authority));
//        }
//        else return new User(null,null,null);
//    }
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	Customer customer = customerRepository.findByUsername(username);
		if (customer == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		String name = customer.getUsername();
		String pwd = customer.getPassword();

		return new User(name, pwd, new ArrayList<>());

	}

}


