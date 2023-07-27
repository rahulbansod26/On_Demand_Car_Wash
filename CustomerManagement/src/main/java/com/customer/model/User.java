//package com.customer.model;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.Collections;
//
//
//public class User implements UserDetails {

//    private Customer customer;
//
//    public User(Customer customer) {
//        this.customer = customer;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return Collections.singletonList(new SimpleGrantedAuthority(this.customer.getRole()));
//    }
//
//    @Override
//    public String getPassword() {
//        return this.customer.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return this.customer.getUsername();
//    }
//
//    public String getName() {
//        return this.customer.getName();
//    }
//
//    public String getEmail() {
//        return this.customer.getEmail();
//    }
//
//    public String getPhone() {
//        return this.customer.getPhone();
//    }
//
//    public String getAddress() {
//        return this.customer.getAddress();
//    }
//
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
