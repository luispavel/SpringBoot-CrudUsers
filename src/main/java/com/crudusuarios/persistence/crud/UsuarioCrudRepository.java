package com.crudusuarios.persistence.crud;

import com.crudusuarios.persistence.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioCrudRepository extends CrudRepository<Usuario, Long> {

	Optional<List<Usuario>> findByNombre(String nombre);

	Optional<List<Usuario>> findByApellidos(String apellidos);
}
