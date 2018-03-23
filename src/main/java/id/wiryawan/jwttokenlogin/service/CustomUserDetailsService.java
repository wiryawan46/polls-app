package id.wiryawan.jwttokenlogin.service;

import id.wiryawan.jwttokenlogin.model.User;
import id.wiryawan.jwttokenlogin.security.UserPrincipal;
import id.wiryawan.jwttokenlogin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEmail)
            throws UsernameNotFoundException {
        // User dapat login dengan username dan email
        User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() ->
                    new UsernameNotFoundException("User not found with username and email : " + usernameOrEmail));
        return UserPrincipal.create(user);
    }

    // Method ini digunakan oleh JWTAuthenticationFilter
    @Transactional
    public UserDetails loadUserById(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() ->
                    new UsernameNotFoundException("User not found with id : " + id));
        return UserPrincipal.create(user);
    }
}
