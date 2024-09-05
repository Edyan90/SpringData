package Epicode.SpringData.services;

import Epicode.SpringData.entities.Cibo;
import Epicode.SpringData.repositories.CiboRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class CiboService {
    @Autowired
    private CiboRepository ciboRepository;

    public void saveCibo(Cibo newCibo){
        try{
            ciboRepository.save(newCibo);
            log.info("Nuovo prodotto: "+ newCibo.getNome() +" salvato con successo!");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public Cibo findById(long ciboID){
        Optional<Cibo> found=ciboRepository.findById(ciboID);
        if (found.isPresent()){
            System.out.println("trovato! è: "+found.get().getClass()+" "+found.get().getNome());
            return found.get();
        }else {
            throw new RuntimeException("Prodotto non trovato nel database");
        }
      //  return ciboRepository.findById(ciboID).orElseThrow(()->new RuntimeException("Prodotto non trovato"));
    }
    public void findByIDandDelete(long ciboID){
        Cibo found=this.findById(ciboID);
        ciboRepository.delete(found);
        log.info("Prodotto con ID: "+ciboID+" cancellato correttamente!");
    }

}
