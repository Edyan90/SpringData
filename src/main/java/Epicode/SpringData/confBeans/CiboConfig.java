package Epicode.SpringData.confBeans;



import Epicode.SpringData.entities.*;
import Epicode.SpringData.enums.StatoTavoloType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource("application.properties")
public class CiboConfig {
    //Toppings
    @Bean
    public Toppings cheese() {
        return new Toppings("Cheese", 0.69, 92);
    }

    @Bean
    public Toppings ham() {
        return new Toppings("Ham", 0.99, 35);
    }

    @Bean
    public Toppings onions() {
        return new Toppings("Onions", 0.69, 22);
    }

    @Bean
    public Toppings pineapple() {
        return new Toppings("Pineapple", 0.79, 24);
    }

    @Bean
    public Toppings salame() {
        return new Toppings("Salami", 0.99, 86);
    }

    @Bean
    public Toppings tomato() {
        return new Toppings("Tomato", 1.0, 100);
    }

    //Pizze
    @Bean
    public Pizza margherita() {
        Pizza pizza = new Pizza("Margherita", 7.0, 1104);
        pizza.addTopping(cheese());
        pizza.addTopping(tomato());
        return pizza;
    }

    @Bean
    @Primary
    public Pizza hawaiana() {
        Pizza pizza2 = new Pizza("Hawaiana", 200.0, 1105);
        pizza2.addTopping(ham());
        pizza2.addTopping(pineapple());
        return pizza2;
    }

    @Bean
    public Pizza salami() {
        Pizza pizza3 = new Pizza("Salami", 7.0, 1106);
        pizza3.addTopping(salame());
        return pizza3;
    }

    //Drinks
    @Bean
    public Drink lemonade() {
        return new Drink("Lemonade", 1.29, 128);
    }

    @Bean
    public Drink water() {
        return new Drink("Water", 1.29, 0);
    }

    @Bean
    public Drink wine() {
        return new Drink("Wine", 7.49, 607);
    }

    //MENU FINALE
    @Bean
    public Menu menu() {
        Menu menu = new Menu();
        menu.addCibo(margherita());
        menu.addCibo(hawaiana());
        menu.addCibo(salami());
        menu.addCibo(cheese());
        menu.addCibo(ham());
        menu.addCibo(onions());
        menu.addCibo(pineapple());
        menu.addCibo(salame());
        menu.addCibo(lemonade());
        menu.addCibo(water());
        menu.addCibo(wine());
        return menu;
    }

    @Bean
    public String costoCopertoDaAPP(@Value("${costo.coperto}") String costoCoperto) {
        return costoCoperto;
    }

    @Bean
    public Tavolo tavolo() {
        return new Tavolo(1, 6, StatoTavoloType.LIBERO);
    }

//    @Bean
//    public Ordine ordine(@Value("${costo.coperto}") Double costoCoperto) {
//        return new Ordine(1000, 5, costoCoperto, tavolo());
//    }

    @Bean
    public Ordine ordine2(@Value("${costo.coperto}") Double costoCoperto) {
        Ordine ordine = new Ordine(1000, 5, costoCoperto, tavolo());
        Pizza margheritaConCipolle = margherita();
        margheritaConCipolle.addTopping(onions());
        ordine.addCibo(margheritaConCipolle);
        ordine.addCibo(salami());
        ordine.addCibo(hawaiana());
        ordine.addCibo(lemonade());
        ordine.addCibo(water());
        ordine.getContoTavolo();
        return ordine;
    }

}
