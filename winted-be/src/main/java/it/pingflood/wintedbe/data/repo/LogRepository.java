package it.pingflood.wintedbe.data.repo;

import it.pingflood.wintedbe.data.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LogRepository extends JpaRepository<Log, UUID>, JpaSpecificationExecutor<Log> {
}
