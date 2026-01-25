package com.carbono2050.carbono_app.service;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardChartsTest extends BaseSeleniumTest {

    @Test
    void interactuarConGraficosDelDashboard() throws InterruptedException {

        loginComoAdmin();

        WebElement grafico = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("grafico-emisiones"))
        );

        pausa("Gráfico de emisiones visible");

        Actions actions = new Actions(driver);
        actions.moveToElement(grafico).perform();
        pausa("Mouse sobre el gráfico");

        actions.moveByOffset(50, 20).click().perform();
        pausa("Interacción con el gráfico");

        logout();
    }
}
