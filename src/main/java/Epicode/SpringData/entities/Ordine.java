package Epicode.SpringData.entities;


import Epicode.SpringData.enums.StatoOrdineType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class Ordine {
    private int numeroOrdine;
    private List<Cibo> elementiOrdinati;
    private StatoOrdineType statoOrdine;
    private int numeroCoperti;
    private LocalDateTime oraOrdine;
    private Double costoCoperto;
    private Tavolo tavolo;

    public Ordine(int numeroOrdine, int numeroCoperti, Double costoCoperto, Tavolo tavolo) {
        this.numeroOrdine = numeroOrdine;
        this.numeroCoperti = numeroCoperti;
        this.elementiOrdinati = new ArrayList<>();
        this.statoOrdine = StatoOrdineType.IN_CORSO;
        this.costoCoperto = costoCoperto;
        this.oraOrdine = LocalDateTime.now();
        this.tavolo = tavolo;
    }

    public Double getContoTavolo() {
        Double totale = costoCoperto * numeroCoperti;
        for (Cibo piatto : elementiOrdinati) {
            totale += piatto.getPrezzo();
        }
        return totale;
    }

    public void addCibo(Cibo cibo) {
        this.elementiOrdinati.add(cibo);
    }

    public void printOrdineDetails() {
        System.out.println("Numero Ordine: " + getNumeroOrdine());
        System.out.println("Stato Ordine: " + getStatoOrdine());
        System.out.println("Numero Coperti: " + getNumeroCoperti());
        System.out.println("Ora: " + getOraOrdine());
        System.out.println("Coperto: " + getCostoCoperto() + "€");
        System.out.println("Tavolo: " + getTavolo().getNumeroTavolo());
        System.out.println("Piatti ordinati: ");
        for (Cibo piatto : elementiOrdinati) {
            System.out.println("-" + piatto.getNome() + "  " + piatto.getPrezzo() + " €");
        }
    }

    public void printContoTavolo() {
        System.out.println("Il totale viene: " + getContoTavolo() + "€");
        System.out.println("Grazie e Arrivederci");
    }
}