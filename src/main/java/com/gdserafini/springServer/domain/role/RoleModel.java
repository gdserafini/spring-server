package com.gdserafini.springServer.domain.role;

import java.util.HashSet;
import java.util.Set;

import com.gdserafini.springServer.domain.rolePermission.RolePermissionModel;
import com.gdserafini.springServer.domain.userRole.UserRoleModel;
import com.gdserafini.springServer.utils.entity.HashableEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "roles")
public class RoleModel extends HashableEntity  {

    @Column(nullable = false, unique = true, length = 20)
    private String name;

    @OneToMany(mappedBy = "role", orphanRemoval = true)
    private Set<UserRoleModel> userRoles = new HashSet<>();

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<RolePermissionModel> rolePermissions = new HashSet<>();

}
