package org.mif.br.repository;

import org.mif.br.model.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RaceRepository extends JpaRepository<Race, Long> {

}
