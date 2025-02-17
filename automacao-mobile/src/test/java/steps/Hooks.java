package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import settings.DriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class Hooks {

    private WebDriver driver;

    @Before
    public void setUp(Scenario scenario) throws Exception {
        driver = DriverManager.getDriver();
        driver.get("https://automationexercise.com/");
        System.out.println("Cenário em execução: " + scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        // Salva o status do teste
        String status = scenario.isFailed() ? "- FALHOU!" : "- PASSOU!";
        System.out.println("O cenário '" + scenario.getName() + "' " + status);

        // Anexa screenshot
        saveScreenshot(scenario);
        savePageSource(); // Anexa o HTML da página

        // Finaliza o driver após o teste
        DriverManager.quitDriver();
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] saveScreenshot(Scenario scenario) {
        if (driver == null) {
            System.out.println("Driver não inicializado corretamente.");
            return new byte[0];
        }

        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Screenshot", "image/png", new ByteArrayInputStream(screenshot), ".png");
        return screenshot;
    }

    @Attachment(value = "HTML da Página", type = "text/html")
    public String savePageSource() {
        return driver.getPageSource();
    }
}
