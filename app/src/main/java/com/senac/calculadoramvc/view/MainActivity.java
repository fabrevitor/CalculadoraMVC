package com.senac.calculadoramvc.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.senac.calculadoramvc.R;
import com.senac.calculadoramvc.control.MainControl;

public class MainActivity extends AppCompatActivity {


    private EditText editNum1;
    private EditText editNum2;
    private ListView lvResultado;
    private Button btnSomar;
    private Button btnSubtrair;
    private Button btnMultiplicar;
    private Button btnDividir;

    private MainControl control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        control = new MainControl(this);
    }

    private void initialize(){
        editNum1 = findViewById(R.id.editNum1);
        editNum2 = findViewById(R.id.editNum2);
        lvResultado = findViewById(R.id.lvResultado);

        //onClick
        btnSomar = findViewById(R.id.btnSomar);
        btnSomar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                control.somarAction();
            }
        });

        //onClick
        btnSubtrair = findViewById(R.id.btnSubtrair);
        btnSubtrair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control.subtrairAction();
            }
        });

        //onClick
        btnMultiplicar = findViewById(R.id.btnMultiplicar);
        btnMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control.multiplicarAction();
            }
        });

        //onClick
        btnDividir = findViewById(R.id.btnDividir);
        btnDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control.dividirAction();
            }
        });
    }

    public EditText getEditNum1() {
        return editNum1;
    }

    public EditText getEditNum2() {
        return editNum2;
    }


    public ListView getLvResultado() {
        return lvResultado;
    }

    public Button getBtnSomar() {
        return btnSomar;
    }

    public Button getBtnSubtrair() {
        return btnSubtrair;
    }

    public Button getBtnMultiplicar() {
        return btnSubtrair;
    }

    public Button getBtnDividir() {
        return btnSubtrair;
    }
}
