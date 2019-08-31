package br.com.teste.imc2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;

public class respostaActivity extends AppCompatActivity {

    DecimalFormat formato = new DecimalFormat("#0.00");

    private TextView numImc;
    private TextView txtSituacao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resposta_activity);

        numImc = findViewById(R.id.resultImc);
        txtSituacao = findViewById(R.id.resultSituacao);
        Intent intent=  getIntent() ;

        Double imc = intent.getDoubleExtra("IMC", 0);
        String situacao = intent.getStringExtra("situacao");

        String imcResultado = String.format("%.2f", imc);


        numImc.setText(String.valueOf(imcResultado));
        txtSituacao.setText(situacao);

    }
}
