package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

// Zadanie 1 - rozwiązywane z wykładowcą
//Utwórz kontroler SessionController.
//Sprawdź czy w sesji jest zapisana wartość pod kluczem loginStart.
//Jeżeli jest zapisana wyświetl ją - skorzystaj z adnotacji @ResponseBody.
//Jeżeli nie ma wartości - wstaw bieżącą datę i godzinę.

@Controller
@RequestMapping("/session")
public class SessionController {
    @GetMapping("/start")
    @ResponseBody
    public String loginStart(HttpSession session) {
        LocalDateTime loginStart = (LocalDateTime)session.getAttribute("loginStart");
        if (loginStart == null) {
            loginStart = LocalDateTime.now();
            session.setAttribute("loginStart", loginStart);
        }
        return loginStart.toString();
    }
}
