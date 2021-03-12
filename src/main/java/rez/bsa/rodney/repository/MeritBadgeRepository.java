package rez.bsa.rodney.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rez.bsa.rodney.domain.MeritBadge;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public
interface MeritBadgeRepository extends CrudRepository<MeritBadge, UUID> {
    List<MeritBadge> findAll();

    Optional<MeritBadge> findById(UUID id);
}
