package com.carbono2050.carbono_app.controller;

import com.carbono2050.carbono_app.model.Emision;
import com.carbono2050.carbono_app.repository.EmisionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
public class DashboardController {

    private final EmisionRepository emisionRepository;

    public DashboardController(EmisionRepository emisionRepository) {
        this.emisionRepository = emisionRepository;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, Principal principal) {
        // 1. Mostrar usuario
        if (principal != null) {
            model.addAttribute("usuario", principal.getName());
        }

        // 2. Obtener lista y calcular Total
        List<Emision> lista = emisionRepository.findAll();
        
        // Sumar todas las emisiones para el banner
        double total = lista.stream()
                            .mapToDouble(Emision::getCantidadCO2)
                            .sum();

        model.addAttribute("emisiones", lista);
        model.addAttribute("totalGlobal", total); // Variable necesaria para el HTML
        
        return "dashboard";
    }

    @PostMapping("/guardar")
    public String guardar(@RequestParam String fuente, @RequestParam Double cantidad) {
        // Lógica simple que ya sabemos que funciona
        Emision nueva = new Emision(fuente, cantidad);
        emisionRepository.save(nueva);
        return "redirect:/dashboard";
    }
    
    // Agregamos borrar para que funcione el botón rojo de tu diseño
    @PostMapping("/borrar")
    public String borrar() {
        emisionRepository.deleteAll();
        return "redirect:/dashboard";
    }
}