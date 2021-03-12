package rez.bsa.rodney.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rez.bsa.rodney.domain.Leader;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public
interface LeaderRepository extends CrudRepository<Leader, UUID> {
    List<Leader> findAll();

    Optional<Leader> findById(UUID id);
}
