package br.claretiano.app01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TelaSecundaria extends AppCompatActivity
        implements View.OnClickListener {

    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_secundaria);

        btnVoltar = (Button) findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(this);

        // Recuperar a intent da Activity
        Intent it = getIntent();
        if (it != null) {

            // Aqui irá recuperar os valores contidos dentro da intent de acordo com o nome.
            // Caso não seja encontrado nada pelo nome, retornará null, ou no caso de int, boolean
            // e alguns outros, retornará o valor definido no segundo parâmetro da chamada,
            // conhecido como valor default.
            String tipo = it.getStringExtra("tipo");
            int qtde = it.getIntExtra("quantidade", 0);
            String acomp = it.getStringExtra("acompanhamento");
            double valor = it.getDoubleExtra("valor", 0);

            EditText edtTipo = (EditText)findViewById(R.id.edtTipo);
            edtTipo.setText(tipo);

            EditText edtQtde = (EditText)findViewById(R.id.edtQuantidade);
            edtQtde.setText(Integer.toString(qtde));
            // Também poderá ser utilizado o seguinte comando para converter um int em String:
            // String.valueOf(VARIAVEL)
            // Este comando acima consegue converter "qualquer" objeto para String.

            TextView txtAcompanhamento = (TextView)findViewById(R.id.txtAcompanhamento);
            txtAcompanhamento.setText(acomp);

            TextView txtValor = (TextView)findViewById(R.id.txtValor);
            txtValor.setText(Double.toString(valor));
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnVoltar) {
            // O método onBackPressed irá ter o mesmo efeito de clicar no "botão" voltar do celular.
            this.onBackPressed();
        }
    }
}
