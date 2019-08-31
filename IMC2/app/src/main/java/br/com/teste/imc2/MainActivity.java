package br.com.teste.imc2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnCalcular;
    private EditText txtNome;
    private EditText txtAltura;
    private EditText txtPeso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalcular = findViewById(R.id.btnCalcular);
        txtNome = findViewById(R.id.txtNome);
        txtAltura = findViewById(R.id.txtAltura);
        txtPeso = findViewById(R.id.txtPeso);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double peso = Double.parseDouble(txtPeso.getText().toString());
                double altura = Double.parseDouble(txtAltura.getText().toString());


                double IMC = peso / (altura * altura);

                String situacao = "";

                if(IMC<17){
                    situacao = "Muito Abaixo do peso";

                }else if(IMC >= 17 && IMC <18.5 ){
                    situacao = "Abaixo do peso";
                }else if(IMC >= 18.5 && IMC < 25){
                    situacao = "Peso normal";
                }else if( IMC >= 25 && IMC < 30 ){
                    situacao = "Acima do peso";
                }else if (IMC >= 30 && IMC < 35){
                    situacao = "Perigo Obesidade grau 1";
                }else if (IMC >=35 && IMC <40){
                    situacao = "Perigo Obesidade grau II";
                }else{
                    situacao = "Perigo Obesidade grau III";
                }




                Intent abrirActivityResposta = new Intent(MainActivity.this, respostaActivity.class);
                abrirActivityResposta.putExtra("IMC", IMC);
                abrirActivityResposta.putExtra("situacao", situacao);
                startActivity(abrirActivityResposta);
            }
        });


    }
}
