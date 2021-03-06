package org.mjmayor.baseproject.facade.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import org.mjmayor.baseproject.assembler.profesor.ProfesorViewAssembler;
import org.mjmayor.baseproject.constants.ProfesorConstants;
import org.mjmayor.baseproject.facade.ProfesorFacade;
import org.mjmayor.baseproject.view.ProfesorView;
import org.mjmayor.jpa.facade.Facade;
import org.mjmayor.jpa.service.Service;
import org.mjmayor.jpa.support.Criteria;
import org.mjmayor.jpa.support.Field;
import org.mjmayor.jpa.support.PageResult;
import org.mjmayor.model.dto.ProfesorDTO;
import org.mjmayor.model.entity.Profesor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProfesorFacadeImpl extends Facade implements ProfesorFacade {

	private static final Logger logger = LoggerFactory.getLogger(ProfesorFacadeImpl.class);

	private Service<Profesor, ProfesorDTO> service;

	private ProfesorViewAssembler assembler;

	public ProfesorFacadeImpl(Service<Profesor, ProfesorDTO> service, ProfesorViewAssembler assembler) {
		super(service);
		this.service = service;
		this.assembler = assembler;
	}

	@Override
	public void add(ProfesorDTO profesorDTO) {
		service.add(profesorDTO);
	}

	@Override
	public void update(ProfesorDTO profesorDTO) {
		service.update(profesorDTO);

	}

	@Override
	public void delete(Long id) {
		service.delete(id);
	}

	@Override
	public void delete(Field field) {
		service.delete(field);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProfesorView get(Long id) {
		ProfesorDTO dto = service.get(id);
		return assembler.assemble(dto);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long countAll() {
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		return service.count(criteriaQuery, null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PageResult<ProfesorView> get(Criteria criteria) {
		CriteriaQuery<Profesor> criteriaQuery = criteriaBuilder.createQuery(Profesor.class);
		criteriaQuery.from(Profesor.class);
		PageResult<ProfesorDTO> list = service.get(criteriaQuery, criteria);
		return assembler.assemble(list);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PageResult<ProfesorView> getByDNI(String dni) {
		PageResult<ProfesorDTO> list = service.get(new Field(ProfesorConstants.Fields.DNI, dni), null);
		return assembler.assemble(list);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PageResult<ProfesorView> getLikeName(String name, Criteria criteria) {
		PageResult<ProfesorDTO> list = service.getLike(new Field(ProfesorConstants.Fields.NAME, name), criteria);
		return assembler.assemble(list);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PageResult<ProfesorView> getLikeSurname(String surname, Criteria criteria) {
		PageResult<ProfesorDTO> list = service.getLike(new Field(ProfesorConstants.Fields.SURNAME, surname), criteria);
		return assembler.assemble(list);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PageResult<ProfesorView> getAlphabeticalList(Criteria criteria) {
		CriteriaQuery<Profesor> criteriaQuery = criteriaBuilder.createQuery(Profesor.class);
		Root<Profesor> root = criteriaQuery.from(Profesor.class);
		List<Order> orders = new ArrayList<Order>();
		orders.add(criteriaBuilder.asc(root.get("apellidos")));
		orders.add(criteriaBuilder.asc(root.get("nombre")));
		criteriaQuery.orderBy(orders);
		PageResult<ProfesorDTO> list = service.get(criteriaQuery, criteria);
		return assembler.assemble(list);
	}
}
