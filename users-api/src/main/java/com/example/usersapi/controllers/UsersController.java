package com.example.usersapi.controllers;

import com.example.usersapi.models.User;
import com.example.usersapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.GET;


@RestController
public class UsersController {

  //Ask spring to get dependency injection
  @Autowired
  private UserRepository userRepository;

//  User findByEmailAddress(String email);
//
//  @RequestMapping(value = "/users/find", method = RequestMethod.GET)
//  @ResponseBody
//  public User findByUsername(@RequestParam("username") String username) {
//    return userRepository.findByUsername(username);
//  }


  @GetMapping("/find/{username}")
  public User findByUsername(@PathVariable String username) {
    return userRepository.findByUsername(username);
  }

  @GetMapping("/")
  public Iterable<User> findAllUsers() {
    return userRepository.findAll();
  }

  //Same name as long as add @PathVariable
  @GetMapping("/{userId}")
  public User findUserById(@PathVariable Long userId) {
    return userRepository.findOne(userId);
  }

  //Delete a user by ID - added the line User userFromDb... to fix
  @DeleteMapping("/{userId}")
  public HttpStatus deleteUserById(@PathVariable Long userId) {
    User userFromDb = userRepository.findOne(userId);
    userRepository.delete(userFromDb);
    return HttpStatus.OK;
  }

  //Posting
  @PostMapping("/")
  public User createNewUser(@RequestBody User newUser) {
    return userRepository.save(newUser);
  }

  //Naive update
  @PatchMapping("/{userId}")
  public User updateUserById(@PathVariable Long userId, @RequestBody User userRequest) {

    User userFromDb = userRepository.findOne(userId);

    userFromDb.setUsername(userRequest.getUsername());
    userFromDb.setPassword(userRequest.getPassword());
    userFromDb.setFilters(userRequest.getFilters());
//    userFromDb.setComments(userRequest.getComments());

    return userRepository.save(userFromDb);
  }

}
