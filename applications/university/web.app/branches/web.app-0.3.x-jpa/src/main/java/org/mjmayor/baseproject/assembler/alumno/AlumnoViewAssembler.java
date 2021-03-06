package org.mjmayor.baseproject.assembler.alumno;

import org.mjmayor.baseproject.assembler.support.AbstractAssembler;
import org.mjmayor.baseproject.dto.AlumnoDTO;
import org.mjmayor.baseproject.view.AlumnoView;

public class AlumnoViewAssembler extends AbstractAssembler<AlumnoDTO, AlumnoView> {

	@Override
	public AlumnoView assemble(AlumnoDTO alumnoDTO) {
		AlumnoView alumnoView = new AlumnoView();
		alumnoView.setDni(alumnoDTO.getDni());
		alumnoView.setNombreCompleto(alumnoDTO.getNombre() + " " + alumnoDTO.getApellidos());
		alumnoView.setEmail(alumnoDTO.getEmail());
		return alumnoView;
	}
}
