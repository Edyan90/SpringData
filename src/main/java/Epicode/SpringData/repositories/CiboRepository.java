package Epicode.SpringData.repositories;

import Epicode.SpringData.entities.Cibo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiboRepository extends JpaRepository<Cibo,Long> {

    
}
