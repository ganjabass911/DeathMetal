package com.library_DM.DeathMetal.Servises;

import com.library_DM.DeathMetal.Entities.RuleEntity;
import com.library_DM.DeathMetal.Entities.UserEntity;
import com.library_DM.DeathMetal.Repositories.RuleRepository;
import com.library_DM.DeathMetal.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
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
            Set<Optional<RuleEntity>> rules = new HashSet<>();
            rules.add(ruleRepository.findById((long) 2));
            newUser.setRules(rules);

            userRepository.save(newUser);

            return "Successfull";
        }
        return "Fail";
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails loadedUser;

        try {
            UserEntity client = userRepository.findByUsername(username);
            loadedUser = new org.springframework.security.core.GrantedAuthority(
                    client.getUsername(),
                    client.getPassword(),
                    client.getRules());
        } catch (Exception repositoryProblem){
            throw  new InternalAuthenticationServiceException(repositoryProblem.getMessage(),repositoryProblem);

        }
        return loadedUser;
    }
}
