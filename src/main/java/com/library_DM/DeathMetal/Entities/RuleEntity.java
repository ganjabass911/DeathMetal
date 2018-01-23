package com.library_DM.DeathMetal.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "RULES")
public class RuleEntity implements GrantedAuthority{

    @Id
    @GeneratedValue
    private long id;

    private String rule;

    @ManyToMany(mappedBy = "user_rule")
    @JsonBackReference
    private Set<UserEntity> users;

    public RuleEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public Set<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(Set<UserEntity> users) {
        this.users = users;
    }

    @Override
    public String getAuthority() {
        return getRule();
    }

}
