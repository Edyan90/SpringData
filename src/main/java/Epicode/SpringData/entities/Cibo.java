package Epicode.SpringData.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity

public abstract class Cibo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;
    protected String nome;
    protected Double prezzo;
    protected int calorie;

    public Cibo(String nome, Double prezzo, int calorie) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.calorie = calorie;
    }

    public abstract void printCiboDetails();
}
