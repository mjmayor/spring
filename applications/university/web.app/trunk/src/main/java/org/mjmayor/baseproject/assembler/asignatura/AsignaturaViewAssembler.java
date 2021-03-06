package org.mjmayor.baseproject.assembler.asignatura;

import org.mjmayor.baseproject.view.AsignaturaView;
import org.mjmayor.jpa.assembler.AbstractAssembler;
import org.mjmayor.model.dto.AsignaturaDTO;
import org.springframework.beans.BeanUtils;

public class AsignaturaViewAssembler extends AbstractAssembler<AsignaturaDTO, AsignaturaView> {

	@Override
	public AsignaturaView assemble(AsignaturaDTO source) {
		AsignaturaView target = new AsignaturaView();
		BeanUtils.copyProperties(source, target);
		return target;
	}
}
