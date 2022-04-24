package pl.coderslab.controller;

// Utwórz akcję dostępną pod pod adresem /random/{max} gdzie max będzie górną granicą zbioru
// z którego zostanie wylosowana liczba.
//Wylosuj wartość od 1 do max.
//Wyświetl w przeglądarce dane w następujący sposób: Użytkownik podał wartość max.
// Wylosowano liczbę: wylosowana liczba.

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
@RequestMapping(value = "/random", produces = "text/html; charset=UTF-8")
public class Random2Controller {
    @GetMapping(value = "/{max}")
    @ResponseBody
    public String randomMax(@PathVariable int max) {
        final int random = new Random(System.currentTimeMillis()).nextInt(max + 1) + 1;
        String responseText = String.format("Użytkownik podał wartość %s.\nWylosowano liczbę: %s.",
                max, random);

        return responseText;
    }

    // Zadanie 2 - rozwiązywane z wykładowcą
    //Zmodyfikuj poprzednią akcję tak, aby przyjmowała dodatkowo wartość minimalną min.
    //Wylosuj wartość od min do max.
    //Wyświetl w przeglądarce dane w następujący sposób: Użytkownik podał wartości min i max. Wylosowano liczbę: wylosowana liczba.
    @GetMapping(value = "/{min}/{max}")
    @ResponseBody
    public String randomMinMax(@PathVariable int min, @PathVariable int max) {
        final int random = new Random(System.currentTimeMillis()).nextInt(max - min + 1) + min;
        String responseText = String.format("Użytkownik podał wartości %s i %s.\nWylosowano liczbę: %s.",
                min, max, random);

        return responseText;
    }
}
