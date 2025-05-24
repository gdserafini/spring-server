package com.gdserafini.spring_server.domain.permission;

import java.util.HashSet;
import java.util.Set;
import com.gdserafini.spring_server.domain.role_permission.RolePermissionModel;
import com.gdserafini.spring_server.utils.entity.HashableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "permissions")
public class PermissionModel extends HashableEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "permission", orphanRemoval = true)
    private Set<RolePermissionModel> rolePermissions = new HashSet<>();
}
