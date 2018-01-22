package com.library_DM.DeathMetal.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Optional;
import java.util.Set;

@Entity
@Table(name = "USERS")
public class UserEntity {
    @Id
    @GeneratedValue
    private long id;
    private String username;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USER_RULE",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "RULE_ID"))
    @JsonManagedReference
    private Set<RuleEntity> rules;

    public UserEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<RuleEntity> getRules() {
        return rules;
    }

    public void setRules(Set<Optional<RuleEntity>> rules) {
        this.rules = rules;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}