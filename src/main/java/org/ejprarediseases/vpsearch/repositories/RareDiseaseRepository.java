package org.ejprarediseases.vpsearch.repositories;

import org.ejprarediseases.vpsearch.models.RareDisease;import org.springframework.data.domain.Pageable;import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RareDiseaseRepository extends JpaRepository<RareDisease, Long> {

    List<RareDisease> findByOrphaCodeEqualsIgnoreCase(String query, Pageable pageable);
    List<RareDisease> findByNameContainingIgnoreCase(String query, Pageable pageable);
    List<RareDisease> findByOrphaCodeContainingIgnoreCase(String query, Pageable pageable);
    List<RareDisease> findBySynonymsContainingIgnoreCase(String query, Pageable pageable);
    List<RareDisease> findByCodesContainingIgnoreCase(String query, Pageable pageable);
}
