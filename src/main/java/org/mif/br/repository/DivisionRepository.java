package org.mif.br.repository;

import org.mif.br.model.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DivisionRepository extends JpaRepository<Division, Long> {

}
