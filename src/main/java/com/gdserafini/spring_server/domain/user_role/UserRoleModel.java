package com.gdserafini.spring_server.domain.user_role;

import com.gdserafini.spring_server.domain.role.RoleModel;
import com.gdserafini.spring_server.domain.user.UserModel;
import com.gdserafini.spring_server.utils.entity.HashableEntity;
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
