package web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.dao.UserService;
import web.dao.UserServiceImpl;
import web.model.User;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ModelAndView home() {
        System.out.println("test controller");
        List<User> listUser = userService.listAll();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        mav.addObject("listUser", listUser);
        return mav;
    }

    @PostMapping("/new")
    public ModelAndView newCustomerForm(@ModelAttribute("user") User user) {
        ModelAndView mav = new ModelAndView("redirect:/");
        userService.save(user);
        return mav;
    }

    @GetMapping("/new")
    public ModelAndView newCustomerForm() {
        ModelAndView mav = new ModelAndView("new_user");
        mav.addObject("user", new User());
        return mav;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editUserForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("edit_user");
        User user = userService.get((int) id);
        mav.addObject("user", user);

        return mav;
    }

    @PostMapping("/edit")
    public ModelAndView editUserForm(@ModelAttribute("user") User user) {
        ModelAndView mav = new ModelAndView("redirect:/");
        userService.save(user);
        return mav;
    }

    @GetMapping("/delete/{id}")
    public String deleteUserForm(@RequestParam long id) {
        userService.delete((int) id);
        return "redirect:/";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/";
    }

//    @RequestMapping("/search")
//    public ModelAndView search(@RequestParam String keyword) {
//        List<User> result = userService.search(keyword);
//        ModelAndView mav = new ModelAndView("search");
//        mav.addObject("result", result);
//
//        return mav;
//    }
}
