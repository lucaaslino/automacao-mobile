package settings;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {

    private static AndroidDriver driver;

    @SuppressWarnings("deprecation")
    public static AndroidDriver getDriver() {
        if (driver == null) {
            try {
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("platformName", "Android");
                caps.setCapability("deviceName", "emulator-5554");
                caps.setCapability("platformVersion", "14"); // Versão do Android
                caps.setCapability("browserName", "Chrome");
                caps.setCapability("automationName", "UiAutomator2");

                // Desativa o teclado do Android
                caps.setCapability("unicodeKeyboard", true);
                caps.setCapability("resetKeyboard", true);
                caps.setCapability("autoGrantPermissions", true);

                // Configuração para rodar o Appium em modo headless
                caps.setCapability("noSign", true);
                caps.setCapability("headless", true);

                driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), caps);

            } catch (MalformedURLException e) {
                throw new RuntimeException("URL do Appium inválida", e);
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
