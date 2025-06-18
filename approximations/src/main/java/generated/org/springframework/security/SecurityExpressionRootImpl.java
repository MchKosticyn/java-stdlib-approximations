package generated.org.springframework.security;

import generated.org.springframework.boot.SpringEngine;
import org.jacodb.approximation.annotation.Approximate;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.core.GrantedAuthority;
import org.usvm.api.Engine;

import java.util.Collection;

@Approximate(SecurityExpressionRoot.class)
public class SecurityExpressionRootImpl {

    @SuppressWarnings("unchecked")
    private Collection<GrantedAuthority> getAuthoritySet() {
        return (Collection<GrantedAuthority>) new SecurityContextImplImpl().getAuthentication().getAuthorities();
    }

    private boolean hasAnyAuthorityName(String prefix, String... roles) {
        SpringEngine._println("Attempting to check authorities:");
        for (String neededRole : roles) {
            SpringEngine._println(neededRole);
        }

        Collection<GrantedAuthority> roleSet = getAuthoritySet();
        for (String neededRole : roles) {
            for (GrantedAuthority authority : roleSet) {
                Engine.assume(authority != null);
                Engine.assume(authority.getAuthority() != null);

                if (Engine.forceStringEquals(authority.getAuthority(), roleWithPrefix(prefix, neededRole)))
                    return true;
            }
        }

        Engine.assume(false);
        return false;
    }

    private String roleWithPrefix(String prefix, String role) {
        if (prefix == null) return role;
        return prefix + role;
    }
}
