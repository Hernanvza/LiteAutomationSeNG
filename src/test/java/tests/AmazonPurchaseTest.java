package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonPurchaseTest { 
    public static void main(String[] args) {
        // Configurar el ChromeDriver
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
        // Crear una instancia del navegador
        WebDriver driver = new ChromeDriver();
        try {
            // Abrir Amazon
            driver.get("https://www.amazon.com/-/es/ref=nav_logo/session-id=132-5278641-6728915");
            // Maximizar la ventana
            // Encontrar el elemento por su XPath
            driver.manage().window().maximize();
            WebElement logoAmazon = driver.findElement(By.xpath("//*[@id=\"c\"]"));

            // Hacer clic en el elemento
            logoAmazon.click();
            // Buscar un producto
            WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
            searchBox.sendKeys("Mouse inalámbrico");
            searchBox.submit();
            // Seleccionar el primer producto
            WebElement firstProduct = driver.findElement(By.cssSelector(".s-main-slot .sresult-item h2 a"));
            firstProduct.click();
            Thread.sleep(3000);
            // Añadir al carrito
            WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
            addToCartButton.click();
            // Validar que el producto está en el carrito
            WebElement cart = driver.findElement(By.id("nav-cart"));
            cart.click();
            Thread.sleep(3000);
            WebElement cartItem = driver.findElement(By.cssSelector(".sc-list-itemcontent"));
            if (cartItem.isDisplayed()) {
                System.out.println("El producto fue añadido al carrito correctamente.");
            } else {
                System.out.println("Error: el producto no está en el carrito.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar el navegador
            driver.quit();
        }
    }
}