package top.wolearning.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    @GetMapping("/helloworld")
    public String helloworld() {
        return "dsakfajs";
    }
}
