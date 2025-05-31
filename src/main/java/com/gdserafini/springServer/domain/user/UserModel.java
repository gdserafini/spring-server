package com.gdserafini.springServer.domain.user;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import com.gdserafini.springServer.domain.userRole.UserRoleModel;
import com.gdserafini.springServer.utils.entity.HashableEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class UserModel extends HashableEntity {

    @Column(unique = true, nullable = false, length = 100)
    private String username;

    @Column(unique = true, nullable = false, length = 100)
    private String email;

    @Column(name = "full_name", nullable = false, length = 100)
    private String fullName;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserRoleModel> userRoles = new HashSet<>();

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Timestamp(System.currentTimeMillis());
        this.isActive = true;
    }

    public UserModel(
        String username, String email, 
        String fullName, String passwordHash
    ){
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
        this.email = email;
    }

}
