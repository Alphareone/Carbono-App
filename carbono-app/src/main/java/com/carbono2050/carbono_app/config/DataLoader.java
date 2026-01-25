package com.carbono2050.carbono_app.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.carbono2050.carbono_app.model.Emision;
import com.carbono2050.carbono_app.model.Usuario;
import com.carbono2050.carbono_app.repository.EmisionRepository;
import com.carbono2050.carbono_app.repository.UsuarioRepository;

@Configuration
public class DataLoader {

    public DataLoader() {
    }

    @Bean
    CommandLineRunner initData(UsuarioRepository usuarioRepository, 
                               EmisionRepository emisionRepository, 
                               PasswordEncoder encoder) {
        return args -> {
            
            // 1. CREAR USUARIOS (Si no existen)
            if (usuarioRepository.count() == 0) {
                Usuario admin = new Usuario();
                admin.setUsername("admin");
                admin.setPassword(encoder.encode("admin123"));
                admin.setRol("ADMIN");

                Usuario user = new Usuario();
                user.setUsername("user");
                user.setPassword(encoder.encode("user123"));
                user.setRol("USER");

                usuarioRepository.save(admin);
                usuarioRepository.save(user);
                System.out.println("--- USUARIOS CREADOS ---");
            }

            // 2. CREAR DATOS DE EMISIONES DE PRUEBA (Si no existen)
            if (emisionRepository.count() == 0) {
                emisionRepository.save(new Emision("Vuelo Santiago-Lima", 1500.00));
                emisionRepository.save(new Emision("Consumo Eléctrico Oficina", 450.50));
                emisionRepository.save(new Emision("Transporte Terrestre", 120.00));
                emisionRepository.save(new Emision("Logística Carga", 800.25));
                
                System.out.println("--- DATOS DE EMISIONES CARGADOS ---");
            }
        };
    }
}