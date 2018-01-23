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
    private Set<RuleEntity> user_rule;

    public UserEntity() {
    }

    public UserEntity(String username, String password, Set<RuleEntity> user_rule) {
        this.username = username;
        this.password = password;
        this.user_rule = user_rule;
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

    public Set<RuleEntity> getUser_rule() {
        return user_rule;
    }

    public void setUser_rule(Set<RuleEntity> user_rule) {
        this.user_rule = user_rule;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}