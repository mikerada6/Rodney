package rez.bsa.rodney.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rez.bsa.rodney.domain.Scout;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public
interface ScoutRepository extends CrudRepository<Scout, UUID> {
    List<Scout> findAll();

    Optional<Scout> findById(UUID id);
}
