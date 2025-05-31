package com.gdserafini.springServer.domain.userRole;

import com.gdserafini.springServer.domain.role.RoleModel;
import com.gdserafini.springServer.domain.user.UserModel;
import com.gdserafini.springServer.utils.entity.HashableEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users_roles")
public class UserRoleModel  extends HashableEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    private RoleModel role;

}
