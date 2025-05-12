package com.hallak.GameApp.models;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "tb_role")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoleType authority;

    public Role(Long id, RoleType authority) {
        this.id = id;
        this.authority = authority;
    }

    public Role(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority.name();
    }

    public void setAuthority(RoleType authority) {
        this.authority = authority;
    }
}