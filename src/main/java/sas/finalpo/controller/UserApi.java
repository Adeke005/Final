package sas.finalpo.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sas.finalpo.entity.User;


@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class UserApi {

    private final MyUserService myUserService;
    private final ItemService itemService;

    @GetMapping
    public String get123(){
        return "test";
    }

    @PostMapping("/registr")
    public void registr(@RequestBody User model){
        myUserService.registr(model);
    }

    @GetMapping("/items")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(itemService.getAll(), HttpStatus.OK);
    }

}
