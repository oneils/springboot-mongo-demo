package info.idgst.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Rest controller which is respinsible for retrieving all {@link User}s from Database.
 *
 * @author Aliaksei Bahdanau
 */
@RestController
public class UserResource {

    private final UserRepository userRepository;

    @Autowired
    public UserResource(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/api/users", produces = "application/JSON")
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }
}
