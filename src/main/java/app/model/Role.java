package app.model;

import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority {
    private String name;

    public Role(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return name;
    }
}
