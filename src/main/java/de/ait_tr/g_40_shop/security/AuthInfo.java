package de.ait_tr.g_40_shop.security;

import de.ait_tr.g_40_shop.domain.entity.Role;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Set;

public class AuthInfo implements Authentication {

    private boolean authenticated;
    private String username;
    private Set<Role> roles;

    public AuthInfo(String username, Set<Role> roles) {
        this.username = username;
        this.roles = roles;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    //WILL NOT BE USED
    @Override
    public Object getCredentials() {
        return null;
    }
    //WILL NOT BE USED
    @Override
    public Object getDetails() {
        return null;
    }



    @Override
    public Object getPrincipal() {
        return username;
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        this.authenticated = isAuthenticated;

    }
    //should return real names, but it's not part of the project
    @Override
    public String getName() {
        return username;
    }
}
