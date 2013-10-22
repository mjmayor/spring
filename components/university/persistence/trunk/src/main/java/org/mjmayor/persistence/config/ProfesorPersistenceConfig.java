package org.mjmayor.persistence.config;

import javax.persistence.EntityManager;

import org.mjmayor.jpa.config.database.PersistenceConfig;
import org.mjmayor.jpa.service.Service;
import org.mjmayor.jpa.service.impl.ServiceImpl;
import org.mjmayor.model.dto.ProfesorDTO;
import org.mjmayor.model.entity.Profesor;
import org.mjmayor.persistence.assembler.profesor.ProfesorDTOAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ PersistenceConfig.class })
public class ProfesorPersistenceConfig {

	@Autowired
	@Qualifier("entityManager")
	private EntityManager entityManager;

	@Bean
	public ProfesorDTOAssembler profesorDTOAssembler() {
		return new ProfesorDTOAssembler();
	}

	@Bean
	public Service<Profesor, ProfesorDTO> service() {
		return new ServiceImpl<Profesor, ProfesorDTO>(entityManager, profesorDTOAssembler(), Profesor.class);
	}
}
