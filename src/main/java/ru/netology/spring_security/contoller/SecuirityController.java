package ru.netology.spring_security.contoller;


import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecuirityController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @Secured({"ROLE_READ"})
    @GetMapping("/read")
    public String read() {
        return "read";
    }

    @RolesAllowed({"WRITE"})
    @GetMapping("/write")
    public String write() {
        return "write";
    }

    @PostAuthorize("hasAnyAuthority('DELETE')")
    @GetMapping("/delete")
    public String delete() {
        return "delete";
    }


    @GetMapping("/user")
    @PreAuthorize("#username == authentication.principal.username")
    public String getMyRoles(@RequestParam(name = "username") String username) {
        return username;
    }
}

