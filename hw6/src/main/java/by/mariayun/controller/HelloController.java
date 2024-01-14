package by.mariayun.controller;

import by.mariayun.dto.UserReadDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
@SessionAttributes("user")
public class HelloController {

    @GetMapping("/hello")
    public ModelAndView sayHello(ModelAndView modelAndView) {
        modelAndView.setViewName("/hello");
        modelAndView.addObject("user", new UserReadDTO(1, "Maria"));
        return modelAndView;
    }
    @GetMapping("/bye")
    public ModelAndView sayBye(ModelAndView modelAndView,
                               @SessionAttribute("user") UserReadDTO user) {
        modelAndView.setViewName("/goodbye");


        return modelAndView;
    }

    @GetMapping("/bye2/{id}")
    public ModelAndView sayBye2(ModelAndView modelAndView, HttpServletRequest request,
                               @RequestParam(value = "age", required = false) Integer age,
                               @RequestHeader("accept") String accept,
                               @CookieValue("JSESSIONID") String jsessionID,
                                @PathVariable(value = "id")Integer id) {

        modelAndView.setViewName("/goodbye");
        return modelAndView;
    }
}
