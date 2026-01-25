package com.carbono2050.carbono_app.service;

import com.carbono2050.carbono_app.model.Usuario;
import com.carbono2050.carbono_app.repository.UsuarioRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Collections;

@Service
public class UsuarioService implements UserDetailsService {

    private final UsuarioRepository repo;

    public UsuarioService(UsuarioRepository repo) { this.repo = repo; }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = repo.findByUsername(username);
        if (user == null) throw new UsernameNotFoundException("User no encontrado");
        
        return new User(user.getUsername(), user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRol())));
    }
}