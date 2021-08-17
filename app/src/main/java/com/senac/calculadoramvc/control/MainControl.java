package com.senac.calculadoramvc.control;

import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.senac.calculadoramvc.R;
import com.senac.calculadoramvc.model.Calculadora;
import com.senac.calculadoramvc.model.CalculadoraBO;
import com.senac.calculadoramvc.view.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class MainControl {
    private MainActivity activity;

    //Para o ListView
    private ArrayAdapter<String> adapterResultados;
    private List<String> listResultados;

    public MainControl(MainActivity activity){
        this.activity = activity;
        configListViewResultados();
    }



    public void somarAction(){
        Calculadora calculadora = new Calculadora();
        calculadora.setNum1(activity.getEditNum1().getText().toString());
        calculadora.setNum2(activity.getEditNum2().getText().toString());

        if(validarDadosForm(calculadora)){
            String txtResultadoFinal = "";

            Double resultado = CalculadoraBO.somar(calculadora);
            txtResultadoFinal +=  calculadora.getNum1()  + " + " + calculadora.getNum2() + " = " + resultado + "\n";

            inserirResultado(txtResultadoFinal);
        } else{
            Toast.makeText(activity, "Form incompleto", Toast.LENGTH_SHORT).show();
        }
    }

    public void subtrairAction(){
        Calculadora calculadora = new Calculadora();
        calculadora.setNum1(activity.getEditNum1().getText().toString());
        calculadora.setNum2(activity.getEditNum2().getText().toString());

        if(validarDadosForm(calculadora)){
            String txtResultadoFinal = "";

            Double resultado = CalculadoraBO.subtrair(calculadora);
            txtResultadoFinal +=  calculadora.getNum1()  + " - " + calculadora.getNum2() + " = " + resultado + "\n";

            inserirResultado(txtResultadoFinal);
        } else{
            Toast.makeText(activity, "Form incompleto", Toast.LENGTH_SHORT).show();
        }
    }

    public void multiplicarAction(){
        Calculadora calculadora = new Calculadora();
        calculadora.setNum1(activity.getEditNum1().getText().toString());
        calculadora.setNum2(activity.getEditNum2().getText().toString());

        if(validarDadosForm(calculadora)){
            String txtResultadoFinal = "";

            Double resultado = CalculadoraBO.multiplicar(calculadora);
            txtResultadoFinal +=  calculadora.getNum1()  + " * " + calculadora.getNum2() + " = " + resultado + "\n";

            inserirResultado(txtResultadoFinal);
        } else{
            Toast.makeText(activity, "Form incompleto", Toast.LENGTH_SHORT).show();
        }
    }

    public void dividirAction(){
        Calculadora calculadora = new Calculadora();
        calculadora.setNum1(activity.getEditNum1().getText().toString());
        calculadora.setNum2(activity.getEditNum2().getText().toString());

        if(validarDadosForm(calculadora)){

            if(calculadora.getNum2() !=0){
                String txtResultadoFinal = "";

                Double resultado = CalculadoraBO.dividir(calculadora);
                txtResultadoFinal +=  calculadora.getNum1()  + " / " + calculadora.getNum2() + " = " + resultado + "\n";

                inserirResultado(txtResultadoFinal);

            } else {
                activity.getEditNum2().setError(activity.getString(R.string.erro_divisao));
                activity.getEditNum2().requestFocus();
            }

        } else{
            Toast.makeText(activity, "Form incompleto", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean validarDadosForm(Calculadora a){
        if(!CalculadoraBO.validarNum(a.getNum1())){
            activity.getEditNum1().setError(activity.getString(R.string.erro_num));
            activity.getEditNum1().requestFocus();
            return false;
        }
        if(!CalculadoraBO.validarNum(a.getNum2())){
            activity.getEditNum2().setError(activity.getString(R.string.erro_num));
            activity.getEditNum2().requestFocus();
            return false;
        }
        return true;
    }

    private void limparForm(){
        activity.getEditNum1().setText("");
        activity.getEditNum2().setText("");
        activity.getEditNum1().requestFocus();
    }

    private void inserirResultado(String txtResultadoFinal){
        adapterResultados.add(txtResultadoFinal);
        limparForm();
    }

    private void configListViewResultados(){
        //Elementos da lista
        listResultados = new ArrayList<>();

        adapterResultados = new ArrayAdapter<>(
                activity,
                android.R.layout.simple_list_item_1,
                listResultados
        );
        activity.getLvResultado().setAdapter(adapterResultados);

        //Adicionando dados ao listView
       // adapterResultados.add(new String("Teste 1" ));
    }
}
