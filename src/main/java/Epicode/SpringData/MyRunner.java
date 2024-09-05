package Epicode.SpringData;

import Epicode.SpringData.entities.*;
import Epicode.SpringData.services.CiboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {
    //qui ci vanno i componenti da richiamare
    @Autowired
    private Menu menu;
    @Autowired
    private Ordine ordine;

    @Autowired
    private CiboService ciboService;
    @Autowired
    private Toppings tomato;
    @Autowired
    private Toppings cheese;
    @Autowired
    private Toppings ham;
    @Autowired
    private Toppings pineapple;
    @Autowired
    private Toppings salame;
    @Autowired
    @Qualifier("margherita")
    private Pizza margherita;
    @Autowired
    @Qualifier("hawaiana")
    private Pizza hawaiana;
    @Autowired
    @Qualifier("salami")
    private Pizza salami;
    @Autowired
    private Drink lemonade;
    @Autowired
    private Drink water;
    @Autowired
    private Drink wine;


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Siamo su RUN");

        ordine.printOrdineDetails();
        System.out.println("---------------");
        ordine.printContoTavolo();

        System.out.println("Siamo su FINE Conto tavolo");
        menu.printMenu();

        // Salva tutti i Toppings una sola volta

        ciboService.saveCibo(cheese);
        ciboService.saveCibo(tomato);
        ciboService.saveCibo(ham);
        ciboService.saveCibo(salame);
        ciboService.saveCibo(pineapple);

        // Salva le bevande
        ciboService.saveCibo(lemonade);
        ciboService.saveCibo(water);
        ciboService.saveCibo(wine);

        // Ora salva le Pizze dopo aver persistito i toppings
       ciboService.saveCibo(hawaiana);
       ciboService.saveCibo(salami);
       ciboService.saveCibo(margherita);
       Cibo mozzarella= ciboService.findById(1);
       Cibo pomodoro=ciboService.findById(2);
        Pizza margherita1=new Pizza("Margherita 2",7.0,1000);
        Pizza margherita2=new Pizza("Margherita 3",7.0,1000);
        margherita1.addTopping((Toppings) mozzarella);
        margherita1.addTopping((Toppings) pomodoro);
        ciboService.saveCibo(margherita1);
        ciboService.saveCibo(margherita2);


       ciboService.findById(9);
       ciboService.findByIDandDelete(8);

        System.out.println("Siamo su FINE RUN");
    }
}