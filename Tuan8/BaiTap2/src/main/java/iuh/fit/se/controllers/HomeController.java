package iuh.fit.se.controllers;

import iuh.fit.se.services.DienThoaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {
    @Autowired
    DienThoaiService dienThoaiService;
}


