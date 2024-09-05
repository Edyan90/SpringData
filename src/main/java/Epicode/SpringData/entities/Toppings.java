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
public class Toppings extends Cibo{


    @ManyToMany(mappedBy = "toppings")
    private List<Pizza> pizzas = new ArrayList<>();

    public Toppings(String nome, Double prezzo, int calorie) {
        super(nome, prezzo, calorie);
    }
    @Override
    public void printCiboDetails(){
        System.out.println("Nome: " + getNome());
        System.out.println("Prezzo: " + getPrezzo());
        System.out.println("Calorie: " + getCalorie());
    }
}
