package com.crudusuarios.persistence.mapper;

import com.crudusuarios.domain.User;
import com.crudusuarios.persistence.entity.Usuario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
	@Mappings({
			@Mapping(source = "idUsuario", target = "userId"),
			@Mapping(source = "nombre", target = "name"),
			@Mapping(source = "apellidos", target = "lastName"),
			@Mapping(source = "telefonoCelular", target = "cellphone"),
			@Mapping(source = "direccion", target = "address"),
			@Mapping(source = "correoElectronico", target = "email"),
	})
	User toUser(Usuario usuario);
	List<User> toUsers(List<Usuario> usuarios);
	@InheritInverseConfiguration
	Usuario toUsuario(User user);

}
