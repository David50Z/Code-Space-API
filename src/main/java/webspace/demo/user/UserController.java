package webspace.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public void addUser(@RequestBody User user) {
        userService.addNewUser(user);
    }

    @PutMapping(path = "{id}/{index}")
    public void changeResource(
            @RequestParam(required = false) String priority,
            @RequestParam(required = false) String priorityLevel,
            @PathVariable("id") Long id,
            @PathVariable("index") int index
            ) {
        userService.changeResource(
                priority,
                priorityLevel,
                id,
                index
        );
    }
}
