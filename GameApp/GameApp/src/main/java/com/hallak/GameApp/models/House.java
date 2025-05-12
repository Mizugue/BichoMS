package com.hallak.GameApp.models;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigDecimal;
import java.util.*;

@Entity
@Table(name = "tb_house")
public class House implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    @ElementCollection
    @CollectionTable(name = "house_odds", joinColumns = @JoinColumn(name = "house_id"))
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "bet_type")
    @Column(name = "value")
    private Map<BetType, BigDecimal> odds = new HashMap<>();

    @OneToMany(mappedBy = "house")
    private Set<Game> games;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "tb_house_role",
            joinColumns = @JoinColumn(name = "house_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set <Role> roles = new HashSet<Role>();

    public House(Long id, String username, String password, Map<BetType, BigDecimal> odds, Set<Game> games, Set<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.odds = odds;
        this.games = games;
        this.roles = roles;
    }

    public House() {
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRoles(Role role) {
        this.roles.add(role);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(role -> (GrantedAuthority) role)
                .toList();
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Map<BetType, BigDecimal> getOdds() {
        return odds;
    }

    public void setOdds(Map<BetType, BigDecimal> odds) {
        this.odds = odds;
    }

}
