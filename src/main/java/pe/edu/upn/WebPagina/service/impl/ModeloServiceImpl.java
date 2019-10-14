package pe.edu.upn.WebPagina.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upn.WebPagina.model.entity.Modelo;
import pe.edu.upn.WebPagina.model.repository.ModeloRepository;
import pe.edu.upn.WebPagina.service.ModeloService;



@Service
public class ModeloServiceImpl implements ModeloService{

	@Autowired
	private ModeloRepository modeloRepository;
	@Transactional(readOnly= true)
	
	@Override
	public List<Modelo> findAll() throws Exception {
		
		return modeloRepository.findAll();
	}

	@Transactional(readOnly=true)
	@Override
	public Optional<Modelo> findById(Integer id) throws Exception {
		
		return modeloRepository.findById(id);
	}

	@Transactional
	@Override
	public Modelo save(Modelo entity) throws Exception {
		
		return modeloRepository.save(entity);
	}

	@Transactional
	@Override
	public Modelo update(Modelo entity) throws Exception {
		
		return modeloRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		modeloRepository.deleteById(id);
		
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		modeloRepository.deleteAll();
		
	}

}
