package br.com.usersapi.resources;

import br.com.usersapi.dtos.UserRequestDTO;
import br.com.usersapi.dtos.UserViewDTO;
import br.com.usersapi.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users", produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserResource {

    private final UserService service;

    @GetMapping
    public ResponseEntity<List<UserViewDTO>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserViewDTO> get(@PathVariable String id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @GetMapping(value = "/findByKey")
    public ResponseEntity<UserViewDTO> getUserByUsername(@RequestParam("key") String username) {
        return ResponseEntity.ok().body(service.findByKey(username));
    }

    @PostMapping
    public ResponseEntity<UserViewDTO> save(@Valid @RequestBody UserRequestDTO requestDTO) {
        UserViewDTO userDTO = service.save(requestDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(requestDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(userDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody UserRequestDTO requestDTO, @PathVariable String id) {
        requestDTO.setId(id);
        service.save(requestDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/page")
    public ResponseEntity<Page<UserViewDTO>> findAllByPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                           @RequestParam(value = "linesPerPage", defaultValue = "10") Integer linesPerPage,
                                                           @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
                                                           @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        Page<UserViewDTO> findPage = service.findPage(page, linesPerPage, orderBy, direction);

        return ResponseEntity.ok().body(findPage);
    }
}
