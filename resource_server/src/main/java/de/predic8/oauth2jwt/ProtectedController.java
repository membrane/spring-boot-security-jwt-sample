package de.predic8.oauth2jwt;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProtectedController {

    @GetMapping("/info")
    public void info() {
        // put a debugger breakpoint here and look at SecurityContextHolder.getContext().getAuthentication();
        System.out.println();
    }

    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @GetMapping("/user")
    public String user() {
        return "This is top secret for user";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin")
    public String admin() {
        return "This is top secret for admin";
    }

    @PreAuthorize("#oauth2.hasScope('read')")
    @GetMapping("/scoped")
    public String scope() {
        return "This is top secret scoped access";
    }

    @PreAuthorize("#oauth2.hasScope('read2')")
    @GetMapping("/scoped2")
    public String scope2() {
        return "This is top secret scoped2 access";
    }
}
