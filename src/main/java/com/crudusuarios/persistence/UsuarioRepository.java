package com.crudusuarios.persistence;

import com.crudusuarios.domain.User;
import com.crudusuarios.domain.repository.UserRepository;
import com.crudusuarios.persistence.crud.UsuarioCrudRepository;
import com.crudusuarios.persistence.entity.Usuario;
import com.crudusuarios.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepository implements UserRepository {
	@Autowired
	private UsuarioCrudRepository usuarioCrudRepository;

	@Autowired
	private UserMapper mapper;


	@Override
	public List<User> getAll() {
		List<Usuario> usuarios = (List<Usuario>) usuarioCrudRepository.findAll();
		return mapper.toUsers(usuarios);
	}

	@Override
	public Optional<User> getUserById(long userId) {
		return usuarioCrudRepository.findById(userId).map(usuario -> mapper.toUser(usuario));
	}

	@Override
	public Optional<List<User>> getByName(String name) {
		Optional<List<Usuario>> usuarios = usuarioCrudRepository.findByNombre(name);
		return usuarios.map(users -> mapper.toUsers(users));
	}

	@Override
	public Optional<List<User>> getByLastName(String apellidos) {
		Optional<List<Usuario>> usuarios = usuarioCrudRepository.findByApellidos(apellidos);
		return usuarios.map(users -> mapper.toUsers(users));
	}

	@Override
	public User save(User user) {
		Usuario usuario = mapper.toUsuario(user);
		return mapper.toUser(usuarioCrudRepository.save(usuario));
	}

	@Override
	public void delete(Long userId) {
		usuarioCrudRepository.deleteById(userId);
	}


	@Override
	public User update(User user) {
		Usuario usuario = mapper.toUsuario(user);
		return mapper.toUser(usuarioCrudRepository.save(usuario));
	}
}

