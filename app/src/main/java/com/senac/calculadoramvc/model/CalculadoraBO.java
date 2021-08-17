package com.senac.calculadoramvc.model;

public class CalculadoraBO {

    public static boolean validarNum(Double num){
        return num!=null && !num.equals("");
    }

    public static Double somar(Calculadora calc){
        return calc.getNum1() + calc.getNum2();
    }

    public static Double subtrair(Calculadora calc){
        return calc.getNum1() - calc.getNum2();
    }

    public static Double multiplicar(Calculadora calc){
        return calc.getNum1() * calc.getNum2();
    }

    public static Double dividir(Calculadora calc){
        return calc.getNum1() / calc.getNum2();
    }
}
