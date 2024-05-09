package com.example.nota

import org.junit.Test
import junit.framework.TestCase.assertEquals

class PromedioUnitTest {

    @Test
    fun calcularPromedio() {
        // Datos de ejemplo
        val nota1 = 7.5
        val nota2 = 8.0
        val nota3 = 6.5
        val nota4 = 9.0

        // Cálculo del promedio
        val totalNotas = nota1 + nota2 + nota3 + nota4
        val cantidadNotas = if (nota1 != 0.0) 1 else 0 +
                if (nota2 != 0.0) 1 else 0 +
                        if (nota3 != 0.0) 1 else 0 +
                                if (nota4 != 0.0) 1 else 0
        val promedio = if (cantidadNotas != 0) totalNotas / 4 else 0.0

        // Verificación del resultado esperado
        assertEquals(7.75, promedio) // Asegúrate de ajustar el valor esperado según tus datos de prueba
    }

    @Test
    fun calcularPromedio2() {
        // Datos de ejemplo
        val nota1 = 5.0
        val nota2 = 4.0
        val nota3 = 3.0
        val nota4 = 2.0

        // Cálculo del promedio
        val totalNotas = nota1 + nota2 + nota3 + nota4
        val cantidadNotas = if (nota1 != 0.0) 1 else 0 +
                if (nota2 != 0.0) 1 else 0 +
                        if (nota3 != 0.0) 1 else 0 +
                                if (nota4 != 0.0) 1 else 0
        val promedio = if (cantidadNotas != 0) totalNotas / 4 else 0.0

        // Verificación del resultado esperado
        assertEquals(3.5, promedio) // Asegúrate de ajustar el valor esperado según tus datos de prueba
    }

    @Test
    fun calcularPromedio3() {
        // Datos de ejemplo
        val nota1 = 2.0
        val nota2 = 2.0
        val nota3 = 4.0
        val nota4 = 4.0

        // Cálculo del promedio
        val totalNotas = nota1 + nota2 + nota3 + nota4
        val cantidadNotas = if (nota1 != 0.0) 1 else 0 +
                if (nota2 != 0.0) 1 else 0 +
                        if (nota3 != 0.0) 1 else 0 +
                                if (nota4 != 0.0) 1 else 0
        val promedio = if (cantidadNotas != 0) totalNotas / 4 else 0.0

        // Verificación del resultado esperado
        assertEquals(3.0, promedio) // Asegúrate de ajustar el valor esperado según tus datos de prueba
    }



}
