package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

// Utwórz kontroler o nazwie FreeTimeController.
//Pobierz aktualną datę.
//Sprawdź aktualny dzień tygodnia oraz aktualną godzinę.
//Jeśli dzień przypada na sobotę lub niedzielę, zwróć tekst Wolne.
//Jeśli dzień przypada na dzień roboczy, a godzina od 9 do 17, zwróć tekst Pracuje, nie dzwoń..
//Jeśli dzień przypada na dzień roboczy, a godzina poza zakresem 9-17 zwróć tekst Po Pracy.
//Aby przetestować działanie aplikacji, możesz zamiast aktualnej daty, pobrać wybraną przez siebie datę i godzinę.


@Controller
public class FreeTimeController {
    @GetMapping("/isfajrant")
    @ResponseBody
    public String isFajrant() {
        LocalDateTime now = LocalDateTime.now();
        DayOfWeek nowWeekDay = now.getDayOfWeek();
        int nowHour = now.getHour();

        if (nowWeekDay == DayOfWeek.SATURDAY || nowWeekDay == DayOfWeek.SUNDAY) {
            return "Fajrant!";
        }
        if (nowHour > 8 && nowHour < 18) {
            return "Byle do fajrantu!";
        }
        return "Po pracy!";
    }
}
