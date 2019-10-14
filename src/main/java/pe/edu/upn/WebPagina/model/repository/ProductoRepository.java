package pe.edu.upn.WebPagina.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upn.WebPagina.model.entity.Producto;


@Repository
public interface ProductoRepository
	extends JpaRepository<Producto, Integer>{

}
