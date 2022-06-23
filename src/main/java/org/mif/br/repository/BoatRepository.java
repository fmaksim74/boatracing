package org.mif.br.repository;

import java.util.List;

import org.mif.br.model.Boat;
import org.mif.br.model.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BoatRepository extends JpaRepository<Boat, Long> {
    
    List<Boat> findByDivision(Division division);
}
