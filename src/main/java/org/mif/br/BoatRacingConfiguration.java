package org.mif.br;

import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.hibernate.type.EntityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@Configuration
public class BoatRacingConfiguration implements RepositoryRestConfigurer {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
	
	entityManager.getMetamodel().getEntities().forEach(entityType -> config.exposeIdsFor(EntityType.class));

	RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config);
    }

}
