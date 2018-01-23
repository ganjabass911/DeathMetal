package com.library_DM.DeathMetal.Servises;

import com.library_DM.DeathMetal.Entities.RuleEntity;
import com.library_DM.DeathMetal.Entities.UserEntity;
import com.library_DM.DeathMetal.Repositories.RuleRepository;
import com.library_DM.DeathMetal.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RuleRepository ruleRepository;

    public String regAccess(String username, String password){
        UserEntity user = userRepository.findByUsername(username);
        if (user == null){
            UserEntity newUser = new UserEntity();
            newUser.setUsername(username);
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(11);
            newUser.setPassword(encoder.encode(password));
            Set<RuleEntity> rules = new HashSet<>();
            rules.add(ruleRepository.findById((long) 2).get());
            newUser.setUser_rule(rules);

            userRepository.save(newUser);

            return "Успешно";
        }
        return "Что-то не так";
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails loadedUser;

        try {
            UserEntity client = userRepository.findByUsername(username);
            loadedUser = new org.springframework.security.core.userdetails.User(
                    client.getUsername(),
                    client.getPassword(),
                    client.getUser_rule());
        } catch (Exception repositoryProblem){
            throw new InternalAuthenticationServiceException(repositoryProblem.getMessage(), repositoryProblem);
        }
        return  loadedUser;
    }

//    @Bean
//    public UserService userDetailsService() throws Exception {
//        UserEntity manager = new UserEntity();
//        manager.setUsername((User.withUsername("username").password("password")
//                .roles("USER").build()));
////        manager.setPassword(password("password"));
//        return manager;
//    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UserDetails loadedUser;
//
//        try {
//            UserEntity client = userRepository.findByUsername(username);
//            loadedUser = new org.springframework.security.core.GrantedAuthority(client.getUsername(),client.getPassword(),client.getRules());
//        } catch (Exception repositoryProblem){
//            throw  new InternalAuthenticationServiceException(repositoryProblem.getMessage(),repositoryProblem);
//
//        }
//        return loadedUser;
//    }
}
