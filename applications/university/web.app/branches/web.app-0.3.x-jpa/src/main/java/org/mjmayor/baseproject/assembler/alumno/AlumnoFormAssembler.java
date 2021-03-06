package org.mjmayor.baseproject.assembler.alumno;

import org.mjmayor.baseproject.assembler.support.AbstractAssembler;
import org.mjmayor.baseproject.dto.AlumnoDTO;
import org.mjmayor.baseproject.form.AlumnoForm;
import org.springframework.beans.BeanUtils;

public class AlumnoFormAssembler extends AbstractAssembler<AlumnoForm, AlumnoDTO> {

	@Override
	public AlumnoDTO assemble(AlumnoForm alumnoForm) {
		AlumnoDTO alumnoDTO = new AlumnoDTO();
		BeanUtils.copyProperties(alumnoForm, alumnoDTO);
		return alumnoDTO;
	}
}
