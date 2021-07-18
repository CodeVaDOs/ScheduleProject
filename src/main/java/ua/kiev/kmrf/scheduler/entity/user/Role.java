package ua.kiev.kmrf.scheduler.entity.user;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
    STUDENT(new HashSet<>(Arrays.asList(Permission.READ))),
    TEACHER(new HashSet<>(Arrays.asList(Permission.READ, Permission.WRITE))),
    ADMIN(new HashSet<>(Arrays.asList(Permission.READ, Permission.WRITE, Permission.GET_TOTAL)));

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities(){
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }
}
