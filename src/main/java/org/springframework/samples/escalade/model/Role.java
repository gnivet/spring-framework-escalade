package org.springframework.samples.escalade.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles" )
public class Role {
    private Integer role_id;
    private String name;
    private Set<User> users;

    @Id    
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getId() {
        return role_id;
    }

    public void setId(Integer role_id) {
        this.role_id = role_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "roles")
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
