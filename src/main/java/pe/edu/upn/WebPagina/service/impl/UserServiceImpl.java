package pe.edu.upn.WebPagina.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upn.WebPagina.model.entity.User;
import pe.edu.upn.WebPagina.model.repository.UserRepository;
import pe.edu.upn.WebPagina.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	
	
	@Transactional(readOnly=true)
	@Override
	public List<User> findAll() throws Exception {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Transactional(readOnly=true)
	@Override
	public Optional<User> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Transactional
	@Override
	public User save(User entity) throws Exception {
		// TODO Auto-generated method stub
		return userRepository.save(entity);
	}

	@Transactional
	@Override
	public User update(User entity) throws Exception {
		// TODO Auto-generated method stub
		return userRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		userRepository.deleteById(id);
		
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		userRepository.deleteAll();
		
	}
	
	

}
