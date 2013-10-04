package org.mjmayor.baseproject.config;

import org.mjmayor.baseproject.assembler.profesor.ProfesorViewAssembler;
import org.mjmayor.baseproject.facade.ProfesorFacade;
import org.mjmayor.baseproject.facade.impl.ProfesorFacadeImpl;
import org.mjmayor.model.dto.ProfesorDTO;
import org.mjmayor.model.entity.Profesor;
import org.mjmayor.persistence.config.ProfesorPersistenceConfig;
import org.mjmayor.persistence.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ ProfesorPersistenceConfig.class })
public class ProfesorBeansConfig {

	@Autowired
	ProfesorService<Profesor, ProfesorDTO> service;

	@Bean
	public ProfesorFacade profesorFacade() {
		return new ProfesorFacadeImpl(service, assembler());
	}

	@Bean
	public ProfesorViewAssembler assembler() {
		return new ProfesorViewAssembler();
	}
}
