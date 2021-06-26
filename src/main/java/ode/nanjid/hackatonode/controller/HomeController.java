package ode.nanjid.hackatonode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = {"/", "/srm4gdm", "/srm4gdm/home"})
    public String displayHomepage() { return "home/index"; }

}
