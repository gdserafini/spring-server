package com.gdserafini.springServer.domain.permission;

import java.util.HashSet;
import java.util.Set;

import com.gdserafini.springServer.domain.rolePermission.RolePermissionModel;
import com.gdserafini.springServer.utils.entity.HashableEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "permissions")
public class PermissionModel extends HashableEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "permission", orphanRemoval = true)
    private Set<RolePermissionModel> rolePermissions = new HashSet<>();
}
