package com.maciejku.conferenceservicewebbackend;

import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
class UserConfController {

    private final UserConfRepository repository;

    UserConfController( UserConfRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/users")
    List<UserConf> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/users")
    UserConf newUserConf(@RequestBody  UserConf newUserConf) {
        return repository.save(newUserConf);
    }

    // Single item

    @GetMapping("/users/{id}")
    EntityModel<UserConf> one(@PathVariable Long id) {

        UserConf userConf = repository.findById(id)
                .orElseThrow(() -> new UserConfNotFoundException(id));

        return EntityModel.of(userConf,
                linkTo(methodOn(UserConfController.class).one(id)).withSelfRel(),
                linkTo(methodOn(UserConfController.class).all()).withRel("users"));
    }

    @PutMapping("/users/{id}")
    UserConf replaceUserConf(@RequestBody UserConf newUserConf, @PathVariable Long id) {

        return repository.findById(id)
                .map(userConf -> {
                    userConf.setUsername(newUserConf.getUsername());
                    userConf.setLogin(newUserConf.getLogin());
                    userConf.setPassword(newUserConf.getPassword());
                    userConf.setEmail(newUserConf.getEmail());
                    userConf.setRole(newUserConf.getRole());
                    return repository.save(userConf);
                })
                .orElseGet(() -> {
                    newUserConf.setId(id);
                    return repository.save(newUserConf);
                });
    }

    @DeleteMapping("/users/{id}")
    void deleteUserConf(@PathVariable Long id) {
        repository.deleteById(id);
    }
}