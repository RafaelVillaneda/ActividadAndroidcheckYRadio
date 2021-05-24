package com.example.actividadradiobuton;

public class Converciones {
    public long decimalABinario(int decimal) {
        long binario = 0;
        int digito;
        final int DIVISOR = 2;
        for (int i = decimal, j = 0; i > 0; i /= DIVISOR, j++) {
            digito = i % DIVISOR;
            binario += digito * Math.pow(10, j);
        }
        return binario;
    }
    public  String decimalAOctal(int decimal) {
        String octal = "";// Almacenamos el número octal que será el resultado
        String caracteresOctales = "01234567";
        while (decimal > 0) {
            int residuo = decimal % 8;

            octal = (caracteresOctales.charAt(residuo) + octal);

            decimal /= 8;
        }
        return octal;
    }
    public  String decimalAHexadecimal(int decimal) {
        String hexadecimal = "";
        String caracteresHexadecimales = "0123456789abcdef";
        while (decimal > 0) {
            int residuo = decimal % 16;
            hexadecimal = caracteresHexadecimales.charAt(residuo) + hexadecimal; // Agregar a la izquierda
            decimal /= 16;
        }
        return hexadecimal;
    }
}
