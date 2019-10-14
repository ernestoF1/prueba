package pe.edu.upn.WebPagina.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upn.WebPagina.model.entity.Producto;
import pe.edu.upn.WebPagina.model.repository.ProductoRepository;
import pe.edu.upn.WebPagina.service.ProductoService;



@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository productoRepository;
	@Transactional(readOnly=true)
	@Override
	public List<Producto> findAll() throws Exception {
		
		return productoRepository.findAll();
	}

	@Transactional(readOnly= true)
	@Override
	public Optional<Producto> findById(Integer id) throws Exception {
		
		return productoRepository.findById(id);
	}

	@Transactional
	@Override
	public Producto save(Producto entity) throws Exception {
		
		return productoRepository.save(entity);
	}

	@Transactional
	@Override
	public Producto update(Producto entity) throws Exception {
		
		return  productoRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		productoRepository.deleteById(id);
		
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		productoRepository.deleteAll();
		
	}

}
