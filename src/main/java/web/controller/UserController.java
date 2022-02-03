package web.controller;


import hiber.config.HiberConfig;
import hiber.model.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import hiber.service.UserService;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    public UserController() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(HiberConfig.class);
        this.userService = context.getBean(UserService.class);
    }

    @GetMapping()
    public String show(Model model) {
        List<User> users = userService.show();
        model.addAttribute("users", users);
        return "user";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping
    public String create(@ModelAttribute("User") User user) {
        userService.save(user);
        return "redirect:user";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("user",userService.get(id));
        return "edit";
    }
    @PatchMapping ("/{id}")
    public String update(@ModelAttribute("user") User user){
      userService.edit(user);
      return "redirect:/user";
}
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        userService.delete(id);
        return "redirect:/user";
    }
}

