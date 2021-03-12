package rez.bsa.rodney.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rez.bsa.rodney.domain.Unit;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public
interface UnitRepository extends CrudRepository<Unit, UUID> {
    List<Unit> findAll();

    Optional<Unit> findById(UUID id);
}
