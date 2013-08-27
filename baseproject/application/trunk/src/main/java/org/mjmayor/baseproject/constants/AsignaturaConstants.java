package org.mjmayor.baseproject.constants;

import org.mjmayor.baseproject.constants.application.ApplicationConstants;

/**
 * Constantes de Asignatura
 * 
 * @author Manuel Jose Mayor Perez
 * @date 22/06/2013
 */
public class AsignaturaConstants {

	public class Fields {
		public static final String CODIGO = "codigo";
		public static final String NOMBRE = "nombre";
		public static final String CURSO = "curso";
		public static final String CREDITOS = "creditos";
	}

	public static final String PATH = "/asignatura";
	public static final String FORM = PATH + ApplicationConstants.FORM;
	public static final String INSERT = PATH + ApplicationConstants.INSERT;
	public static final String DELETE = PATH + ApplicationConstants.DELETE;
	public static final String GETALL = PATH + ApplicationConstants.GETALL;
	public static final String INSERTOK = PATH + ApplicationConstants.INSERT_OK;
	public static final String DELETEOK = PATH + ApplicationConstants.DELETE_OK;
	public static final String DATA = PATH + ApplicationConstants.DATA;
	public static final String LIST = PATH + ApplicationConstants.LIST;
	public static final String ASIGNATURA_DATA = "asignaturaForm";
	public static final String ASIGNATURAS_LIST_DATA = "asignaturas";
}