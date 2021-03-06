package org.mjmayor.baseproject.config;

import org.hibernate.SessionFactory;
import org.mjmayor.baseproject.assembler.profesor.ProfesorFormAssembler;
import org.mjmayor.baseproject.assembler.profesor.ProfesorViewAssembler;
import org.mjmayor.baseproject.dao.ProfesorDAO;
import org.mjmayor.baseproject.dao.impl.ProfesorDAOImpl;
import org.mjmayor.baseproject.facade.ProfesorFacade;
import org.mjmayor.baseproject.facade.impl.ProfesorFacadeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProfesorBeansConfig {

	@Autowired
	private SessionFactory sessionFactory;

	@Bean
	public ProfesorFacade profesorFacade() {
		return new ProfesorFacadeImpl(profesorDAO(), profesorViewAssembler());
	}

	@Bean
	public ProfesorDAO profesorDAO() {
		return new ProfesorDAOImpl(sessionFactory, profesorFormAssembler());
	}

	@Bean
	public ProfesorViewAssembler profesorViewAssembler() {
		return new ProfesorViewAssembler();
	}

	@Bean
	public ProfesorFormAssembler profesorFormAssembler() {
		return new ProfesorFormAssembler();
	}
}
