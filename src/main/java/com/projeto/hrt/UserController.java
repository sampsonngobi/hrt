package com.projeto.hrt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping(path = "/user") 
public class UserController {
    @Autowired 
    private UserRepository userRepository;

    @PostMapping(path = "/") // Map ONLY POST Requests
    public @ResponseBody String addNewUser(@RequestParam String name,
                                           @RequestParam String status,
                                           @RequestParam String location,
                                           @RequestParam String proposedTime,
                                           @RequestParam String actualStartTime,
                                           @RequestParam String endTime,
                                           @RequestParam String exitTime) {
        User n = new User();
        n.setName(name);
        n.setStatus(status);
        n.setLocation(location);
        n.setProposedTime(proposedTime);
        n.setActualStartTime(actualStartTime);
        n.setEndTime(endTime);
        n.setExitTime(exitTime);

        userRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/")
    public @ResponseBody Iterable<User> getAllUsers() {
      return userRepository.findAll();
    }

    @PutMapping(path="/{id}")
    public @ResponseBody String updateUser(@PathVariable int id,
                                           @RequestParam String name,
                                           @RequestParam String status,
                                           @RequestParam String location,
                                           @RequestParam String proposedTime,
                                           @RequestParam String actualStartTime,
                                           @RequestParam String endTime,
                                           @RequestParam String exitTime){
        User n = userRepository.findById(id);
        n.setName(name);
        n.setStatus(status);
        n.setLocation(location);
        n.setProposedTime(proposedTime);
        n.setActualStartTime(actualStartTime);
        n.setEndTime(endTime);
        n.setExitTime(exitTime);

        userRepository.save(n);
        return "Updated";
    }

    @DeleteMapping(path="/{id}")
    public @ResponseBody String deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
        return "Deleted";
    }
}
