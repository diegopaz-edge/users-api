package br.com.usersapi.services;

import br.com.usersapi.builders.UserBuilder;
import br.com.usersapi.domain.User;
import br.com.usersapi.dtos.UserRequestDTO;
import br.com.usersapi.dtos.UserViewDTO;
import br.com.usersapi.repositories.UserRepository;
import br.com.usersapi.services.exceptions.DataIntegrityException;
import br.com.usersapi.services.exceptions.UserNotFoundException;
import br.com.usersapi.utilities.ConvertUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static br.com.usersapi.utilities.ConvertUtil.convertStringToUUID;

@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
@Transactional
public class UserService {
    private static final String USER_NOT_FOUND_MSG = "User not found with id: {}";

    private final UserRepository repository;

    public List<UserViewDTO> findAll() {
        return repository.findAll().stream().map(UserBuilder::build).collect(Collectors.toList());
    }

    public Page<UserViewDTO> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        Page<User> pagesUsers = repository.findAll(pageRequest);
        List<UserViewDTO> usersDTOs = repository
                .findAll(pageRequest)
                .stream()
                .map(UserBuilder::build)
                .collect(Collectors.toList());

        return new PageImpl<>(usersDTOs, pageRequest, pagesUsers.getTotalElements());
    }

    public UserViewDTO findById(String id) {
        Optional<User> user = repository.findById(convertStringToUUID(id));
        return user.map(UserBuilder::build).orElse(null);
    }

    public UserViewDTO findByKey(String key) {
        Optional<User> user = repository.findByKey(key);

        return user.map(UserBuilder::build).orElse(null);
    }

    public UserViewDTO save(UserRequestDTO requestDTO) {
        User user = UserBuilder.build(requestDTO);
        User userSaved = repository.save(user);
        log.info("User has been successfully added");
        return UserBuilder.build(userSaved);
    }

    public void update(String id, UserRequestDTO requestDTO) throws UserNotFoundException {
        findByIdOrThrowException(id);
        User user = UserBuilder.build(requestDTO);
        user.setId(ConvertUtil.convertStringToUUID(id));

        repository.save(user);
        log.info("User has been successfully updated");
    }

    public void delete(String id) {
        try {
            repository.deleteById(convertStringToUUID(id));
            log.info("User deleted with id: {}", id);
        } catch (DataIntegrityException e) {
            log.info("Unable to delete this user, there are associated relations.");
            throw new DataIntegrityException("Cannot delete this user, there are related associations.");
        }
    }

    private void findByIdOrThrowException(String id) throws UserNotFoundException {
        log.info("User find by with id {}", id);
        Optional<User> material = repository.findById(ConvertUtil.convertStringToUUID(id));

        material.orElseThrow(() -> {
            log.error(USER_NOT_FOUND_MSG, id);
            return new UserNotFoundException(String.format(USER_NOT_FOUND_MSG, id));
        });
    }
}
