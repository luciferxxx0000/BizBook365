package com.example.demo.adn.bbk.client.presentationlayer;

import com.example.demo.adn.bbk.client.datalayer.modal.User;
import com.example.demo.adn.bbk.client.datalayer.services.UserService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserAccountController {

    private final UserService userService;

    public UserAccountController(UserService userService) {  // <-- fixed constructor name
        this.userService = userService;
    }

    @PostMapping("/save")
    public User save(@RequestBody User user) {
        return userService.saveUser(user);
    }

    // @PutMapping("/update")
    // public User update(@RequestBody User user) {
    //     return userService.updateUser(user);
    // }

    // @GetMapping("/{id}")
    // public User getUser(@PathVariable Integer id) {
    //     return userService.getUser(id);
    // }

    // @GetMapping("/all")
    // public List<User> getAll() {
    //     return userService.getAllUsers();
    // }

    // @DeleteMapping("/{id}")
    // public String delete(@PathVariable Integer id) {
    //     userService.deleteUser(id);
    //     return "User Deleted Successfully";
    // }
}
