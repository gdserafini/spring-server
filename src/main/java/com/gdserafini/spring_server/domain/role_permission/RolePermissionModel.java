package com.gdserafini.spring_server.domain.role_permission;

import com.gdserafini.spring_server.domain.permission.PermissionModel;
import com.gdserafini.spring_server.domain.role.RoleModel;
import com.gdserafini.spring_server.utils.entity.HashableEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles_permissions")
public class RolePermissionModel extends HashableEntity{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "permission_id", nullable = false)
    private PermissionModel permission;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    private RoleModel role;
}
