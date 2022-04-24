package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalTime;

@Controller
public class HelloController {
    // zad1
    @GetMapping("/helloView")
    public String hello() {
        return "home";
    }

    // zad2
    // W widoku home.jsp dodaj tag style.
    // Tag powinien zawierać selector body,
    // który ustawia dwie właściwości color i backgroundColor.
    //Wartościami tych parametrów powinny być wartości color i backgroundColor, przekazane z kontrolera.
    //W akcji sprawdzaj aktualną godzinę i jeśli jest między 8:00 a 20:00 podmieniał tekst color i backgroundColor odpowiednio na black i white.
    //Gdy godzina wypada między 20:00 a 8:00, podmień wartości właściwości odwrotnie.
    //Uruchom stronę i zobacz efekt. Tekst powinien być czarny, a strona biała.
    //Zmodyfikuj program tak, aby nie brał pod uwagę aktualnej godziny, tylko na sztywno wpisz godzinę 1:00 w nocy.
    //Wyświetl stronę i zobacz efekt. Tekst powinien być biały, a strona czarna.
    @GetMapping("/daynight")
    public String daynight(Model model) {
        String bgColor = "white";
        String fontColor = "black";
        int hour = LocalTime.now().getHour();
        if(hour < 8 || hour > 19) {
            bgColor = "black";
            fontColor = "white";
        }

        model.addAttribute("backgroundColor", bgColor);
        model.addAttribute("fontColor", fontColor);

        return "dn/daynight";
    }
}
