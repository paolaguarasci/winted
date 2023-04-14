package it.pingflood.wintedbe.data.repo;

import it.pingflood.wintedbe.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID>, JpaSpecificationExecutor<Product> {
  
  // TODO Usare l'enum piuttosto che la stringa... ma pare che si rompe... per ora va bene cosi
  @Query(value = "select p from Product p where p.status = 'VISIBLE'")
  List<Product> findAllPublic();
  
  
  List<Product> findAllByOwner_Id(UUID owner_id);
}
