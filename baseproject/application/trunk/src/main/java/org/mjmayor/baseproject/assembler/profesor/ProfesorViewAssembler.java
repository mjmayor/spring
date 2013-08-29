package org.mjmayor.baseproject.assembler.profesor;

import org.mjmayor.baseproject.view.ProfesorView;
import org.mjmayor.jpa.assembler.AbstractAssembler;
import org.mjmayor.persistence.dto.ProfesorDTO;

public class ProfesorViewAssembler extends AbstractAssembler<ProfesorDTO, ProfesorView> {

	@Override
	public ProfesorView assemble(ProfesorDTO profesorDTO) {
		ProfesorView profesorView = new ProfesorView();
		profesorView.setDni(profesorDTO.getDni());
		profesorView.setNombreCompleto(profesorDTO.getNombre() + " " + profesorDTO.getApellidos());
		return profesorView;
	}
}
