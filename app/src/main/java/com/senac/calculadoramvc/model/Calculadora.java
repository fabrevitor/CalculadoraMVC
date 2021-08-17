package com.senac.calculadoramvc.model;

public class Calculadora {
    private Double num1;
    private Double num2;

    public Double getNum1() {
        return num1;
    }

    public void setNum1(Double num1) {
        this.num1 = num1;
    }

    public void setNum1(String num1) {
        try {
            this.num1 = Double.parseDouble(num1);
        } catch (Exception e){
            this.num1 = null;
        }
    }

    public Double getNum2() {
        return num2;
    }

    public void setNum2(Double num2) {
        this.num2 = num2;
    }

    public void setNum2(String num2) {
        try {
            this.num2 = Double.parseDouble(num2);
        } catch (Exception e){
            this.num2 = null;
        }
    }

    public Calculadora() {
    }

    public Calculadora(Double num1, Double num2) {
        this.num1 = num1;
        this.num2 = num2;

    }
}
