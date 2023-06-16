package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilTest {

    @Test
    void validarRango() {
        int numero1 = 0;
        //de este test se espera que sea verdadero el resultado del metodo ya que esta diseñado para tener ambos rangos inclusive
        boolean validacion1 = Util.validarRango(numero1,0,0);
        Assertions.assertTrue(validacion1);

        int numero2 = 1;
        boolean validacion2 = Util.validarRango(numero2,2,5);
        Assertions.assertFalse(validacion2);

        int numero3 = 2;
        boolean validacion3 = Util.validarRango(numero3,-5,1);
        Assertions.assertFalse(validacion3);
    }
}