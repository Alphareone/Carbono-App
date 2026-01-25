package com.carbono2050.carbono_app.service;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class LoginLinksTests extends BaseSeleniumTest {

    @Test
    void visualizarEnlacesDelLogin() throws InterruptedException {

        driver.get("http://localhost:" + port + "/login");
        pausa("Página de login visible");

        driver.findElement(By.linkText("Registrarse")).click();
        pausa("Navegando a registro");
        driver.navigate().back();

        driver.findElement(By.linkText("¿Olvidaste tu contraseña?")).click();
        pausa("Navegando a recuperación");
        driver.navigate().back();

        pausa("Probando login");
        loginComoAdmin();
        logout();
    }
}
