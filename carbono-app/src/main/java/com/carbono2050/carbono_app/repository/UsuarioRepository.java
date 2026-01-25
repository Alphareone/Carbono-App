package com.carbono2050.carbono_app.repository;

import com.carbono2050.carbono_app.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);
}