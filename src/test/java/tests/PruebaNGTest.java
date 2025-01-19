package tests;

import org.testng.Assert;
import org.testng.annotations.Test; 

public class PruebaNGTest { 
    // POSITIVO
    @Test
    public void testSuma() {
        int resultado = 2 + 2;
        Assert.assertEquals(resultado, 4, "La suma es incorrecta");
    }

    @Test
    public void testResta() {
        int resultado = 5 - 3;
        Assert.assertEquals(resultado, 2, "La resta es incorrecta");
    }

    // NEGATIVO
    @Test
    public void testSumaInvalida() {
        int resultado = 2 + 2;
        Assert.assertNotEquals(resultado, 5, "El resultado de la suma debería ser diferente de 5");
    }

    @Test
    public void testRestaInvalida() {
        int resultado = 5 - 3;
        Assert.assertNotEquals(resultado, 1, "El resultado de la resta debería ser diferente de 1");
    }
} 
