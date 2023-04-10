package it.pingflood.wintedbe.data.repo;

import it.pingflood.wintedbe.data.entity.Color;
import it.pingflood.wintedbe.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID>, JpaSpecificationExecutor<Color> {
}