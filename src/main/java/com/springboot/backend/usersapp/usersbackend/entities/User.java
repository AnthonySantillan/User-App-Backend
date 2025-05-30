package com.springboot.backend.usersapp.usersbackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.springboot.backend.usersapp.usersbackend.models.IUser;
import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.*;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User  implements IUser {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotBlank
    private String name;
    @NotBlank
    private String lastname;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Size(min=4, max = 12)
    private String username;
    @NotBlank
    private String password;
    @Transient
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private boolean admin;
    @JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"),
            uniqueConstraints = { @UniqueConstraint(columnNames = {"user_id","role_id"}) }
    )
    private List<Role> roles;

    public User() {
        this.roles = new ArrayList<>();
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
