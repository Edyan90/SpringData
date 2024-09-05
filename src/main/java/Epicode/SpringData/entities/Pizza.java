package Epicode.SpringData.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Pizza extends Cibo {

    @ManyToMany
    @JoinTable(name = "pizza_toppings",
            joinColumns = @JoinColumn(name="pizza_id"),
            inverseJoinColumns = @JoinColumn(name="topping_id"))
    private List<Toppings> toppings;

    public Pizza(String nome, Double prezzo, int calorie) {
        super(nome, prezzo, calorie);
        this.toppings = new ArrayList<>();
    }

    public void addTopping(Toppings toppings) {
        this.toppings.add(toppings);
    }

    @Override
    public Double getPrezzo() {
        Double totalPrezzo = this.prezzo;
        for (Toppings topping : toppings) {
            totalPrezzo += topping.getPrezzo();
        }
        return totalPrezzo;
    }


    @Override
    public void printCiboDetails() {
        System.out.println("Pizza: " + getNome());
        System.out.println("Prezzo: " + getPrezzo());
        System.out.println("Calorie: " + getCalorie());
        System.out.println("Toppings: ");
        for (Toppings topping : toppings) {
            System.out.println(" - " + topping.getNome());
        }
    }
}
