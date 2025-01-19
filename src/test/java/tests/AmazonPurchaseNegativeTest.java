package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class AmazonPurchaseNegativeTest { 
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testNegativePurchase() {
        try {
            // Navegar a Amazon
            driver.get("https://www.amazon.com/-/es/ref=nav_logo/session-id=132-5278641-6728915");

            Thread.sleep(2000);
            driver.manage().window().maximize();
            WebElement logoAmazon = driver.findElement(By.xpath("//*[@id=\"c\"]"));
            // Hacer clic en el elemento
            logoAmazon.click();
            Thread.sleep(1000);

            // Buscar un producto
            WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
            searchBox.sendKeys("libro libro De Mí Para Mí, La Tormenta Pasará");
            searchBox.submit();
            Thread.sleep(2000);

            WebElement primerlibro = driver.findElement(By.xpath("//a-section[@class='a-spacing-none puis-padding-right-small s-title-instructions-style']//a"));            primerlibro.click();
            Thread.sleep(1000);
            // Agregar al carrito el primer producto
            WebElement addToCartButton = driver.findElement(By.id("a-autoid-2-announce"));
            addToCartButton.click();

            // Ir al carrito
            WebElement cartIcon = driver.findElement(By.id("nav-cart"));
            cartIcon.click();

            // Eliminar el producto del carrito
            WebElement deleteButton = driver.findElement(By.cssSelector(".a-button-text a-button-delete"));
            deleteButton.click();

            // Verificar que el producto haya sido eliminado (puedes implementar una lógica más robusta aquí)
            WebElement emptyCartMessage = driver.findElement(By.id("sc-active-cart"));
            String message = emptyCartMessage.getText();
            Assert.assertTrue(message.contains("Tu carrito está vacío"), "El producto no fue eliminado del carrito.");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error durante la ejecución de la prueba: " + e.getMessage());
        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}