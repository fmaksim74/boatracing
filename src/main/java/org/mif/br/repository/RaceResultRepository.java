package org.mif.br.repository;

import org.mif.br.model.RaceResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RaceResultRepository extends JpaRepository<RaceResult, Long> {

}
