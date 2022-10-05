package pe.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.idat.model.Malla;
import pe.idat.repository.MallaRepository;
@Service
public class MallaServiceImpl implements MallaService {
	
	@Autowired
	private MallaRepository repositorio;
	
	@Override
	public void guardar(Malla malla) {
		repositorio.save(malla);

	}

	@Override
	public void actualizar(Malla malla) {
		repositorio.saveAndFlush(malla);

	}

	@Override
	public void eliminar(Integer id) {
		repositorio.deleteById(id);

	}

	@Override
	public List<Malla> listar() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	@Override
	public Malla obtener(Integer id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id).orElse(null);
	}

}
