package Epicode.SpringData.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Drink extends Cibo{
    public Drink(String nome, Double prezzo, int calorie) {
        super(nome, prezzo, calorie);
    }
    @Override
    public void printCiboDetails(){
        System.out.println("Nome: " + getNome());
        System.out.println("Prezzo: " + getPrezzo());
        System.out.println("Calorie: " + getCalorie());
    }
}
