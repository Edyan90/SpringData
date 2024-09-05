package Epicode.SpringData.entities;

import Epicode.SpringData.enums.StatoTavoloType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Tavolo {
    private int numeroTavolo;
    private int numeroCopertiMax;
    private StatoTavoloType statoTavolo;

    public void tavoloDetails() {
        System.out.println("ID tavolo: " + numeroTavolo);
        System.out.println("numero coperti Max: " + numeroCopertiMax);
        System.out.println("stato del tavolo: " + statoTavolo);
    }

}
