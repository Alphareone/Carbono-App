package com.carbono2050.carbono_app.service;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
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
public abstract class BaseSeleniumTest {

    @LocalServerPort
    protected int port;

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeEach
    @SuppressWarnings("unused")
    void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--remote-allow-origins=*");
        //  NO headless → queremos ver todo

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterEach
    @SuppressWarnings("unused")
    void tearDown() throws InterruptedException {
        Thread.sleep(2000); // ver el estado final
        if (driver != null) {
            driver.quit();
        }
    }

    protected void pausa(String msg) throws InterruptedException {
        System.out.println("🟡 " + msg);
        Thread.sleep(2000);
    }

    protected void loginComoAdmin() throws InterruptedException {
        driver.get("http://localhost:" + port + "/login");
        pausa("Página de login cargada");

        WebElement user = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name("username"))
        );
        user.clear(); // evita loginlogin
        user.sendKeys("admin");

        WebElement pass = driver.findElement(By.name("password"));
        pass.clear();
        pass.sendKeys("admin123");

        pausa("Credenciales ingresadas");

        driver.findElement(By.tagName("button")).click();

        wait.until(ExpectedConditions.urlContains("/dashboard"));
        pausa("Login exitoso → Dashboard");
    }

    protected void logout() throws InterruptedException {
        WebElement logout = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("logout"))
        );
        logout.click();
        pausa("Sesión cerrada");
    }
}
