package com.carbono2050.carbono_app;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import io.github.bonigarcia.wdm.WebDriverManager;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SeleniumVisualTest {

    @LocalServerPort
    private int port;

    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        baseUrl = "http://localhost:" + port;
    }

    @AfterEach
    void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void flujoCompletoEnVivo() throws InterruptedException {

        System.out.println(">>> ABRIENDO LOGIN");
        driver.get(baseUrl + "/login");
        verPausa("Página de Login cargada");

        // --- LOGIN ---
        limpiarYEscribir(By.name("username"), "admin");
        limpiarYEscribir(By.name("password"), "admin123");
        verPausa("Credenciales escritas");

        driver.findElement(By.tagName("button")).click();

        // --- DASHBOARD ---
        wait.until(ExpectedConditions.urlContains("/dashboard"));
        assertTrue(driver.getCurrentUrl().contains("/dashboard"));
        verPausa("Login exitoso. Dashboard visible");

        // --- BORRAR DATOS ---
        WebElement btnBorrar = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[contains(text(),'Borrar Todo')]")));
        btnBorrar.click();
        verPausa(">>> SE HAN BORRADO TODOS LOS DATOS <<<");

        // --- AGREGAR REGISTROS ---
        agregarRegistro("Viaje a la Planta Norte", "120.50");
        agregarRegistro("Consumo Maquinaria A", "850.00");
        agregarRegistro("Flota de Camiones", "3400.20");

        // --- VERIFICACIÓN FINAL ---
        WebElement tabla = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("tabla-emisiones")));
        String contenido = tabla.getText();

        assertTrue(contenido.contains("3400.2"));
        verPausa("PRUEBA FINALIZADA CORRECTAMENTE");
    }

    // --------------------------------------------------
    // MÉTODOS AUXILIARES
    // --------------------------------------------------

    private void limpiarYEscribir(By locator, String texto) {
        WebElement input = wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator));

        input.click();
        input.sendKeys(Keys.CONTROL + "a");
        input.sendKeys(Keys.DELETE);
        input.sendKeys(texto);
    }

    private void agregarRegistro(String fuente, String cantidad) throws InterruptedException {
        System.out.println(">>> Agregando: " + fuente);

        limpiarYEscribir(By.name("fuente"), fuente);
        limpiarYEscribir(By.name("cantidad"), cantidad);

        WebElement btnGuardar = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[contains(text(),'Guardar Registro')]")));
        btnGuardar.click();

        Thread.sleep(1000); // pequeña pausa visual
    }

    private void verPausa(String mensaje) throws InterruptedException {
        System.out.println(mensaje);
        Thread.sleep(1500);
    }
}
