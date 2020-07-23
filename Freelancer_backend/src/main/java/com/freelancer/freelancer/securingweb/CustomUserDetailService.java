package com.freelancer.freelancer.securingweb;

import com.freelancer.freelancer.entity.User;
import com.freelancer.freelancer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.findByName(s);
        System.out.println(user);
        System.out.println(user.getPassword());
        if(user == null){
            throw new UsernameNotFoundException(s);
        }
        return new UserPrincipal(user);
    }
}
