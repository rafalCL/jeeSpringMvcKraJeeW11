package pl.coderslab.zad2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/cart")
public class CartController {
    private Cart cart;

    public CartController(Cart cart) {
        this.cart = cart;
    }

    @GetMapping("/addtocart")
    @ResponseBody
    public String addtocart() {
        Random rand = new Random();
        cart.addToCart(new CartItem(1, new Product("prod" + rand.nextInt(10), rand.nextDouble())));
        return "addtocart";
    }

    @GetMapping(value = "/show", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String show() {
        String resultText = cart.getItems().stream()
                .map(CartItem::toString)
                .collect(Collectors.joining("</li><li>",
                        "<ul><li>",
                        "</li></ul>"));
        return resultText;
    }
}
