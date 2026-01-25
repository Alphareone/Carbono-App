package com.carbono2050.carbono_app.controller;

import com.carbono2050.carbono_app.model.Emision;
import com.carbono2050.carbono_app.repository.EmisionRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/registroco2")
public class EmisionController {

    private EmisionRepository registroRepo = null;

    public void RegistroCO2Controller(EmisionRepository registroRepo) {
        this.registroRepo = registroRepo;
    }

    @PostMapping("/guardar")
    public String guardarRegistro(
            @RequestParam String fuente,
            @RequestParam double consumo,
            HttpSession session) {

        if (session.getAttribute("usuario") == null) {
            return "redirect:/login";
        }

        ((EmisionRepository) registroRepo).save(new Emision(fuente, consumo));
        return "redirect:/dashboard";
    }

    @PostMapping("/borrar")
    public String borrarRegistros(HttpSession session) {

        if (session.getAttribute("usuario") == null) {
            return "redirect:/login";
        }

        ((EmisionRepository) registroRepo).deleteAll();
        return "redirect:/dashboard";
    }
}
