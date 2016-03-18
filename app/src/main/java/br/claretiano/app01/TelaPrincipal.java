package br.claretiano.app01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/*
 * AppCompatActivity = defini que a classe é um Activity e será portanto uma tela para o usuário.
 *
 * View.OnClickListener = esta interface irá obrigar a implementar o método onClick para tratar
 * os eventos de click, podendo ser eles em qualquer coisa da tela, no caso utilizaremos no botão.
 */
public class TelaPrincipal extends AppCompatActivity
        implements View.OnClickListener {

    // Declarar os objetos dos elementos da interface que serão programados
    private RadioGroup rdgTipo;
    private RadioButton rdbTipoSimples;
    private RadioButton rdbTipoDuplo;
    private RadioButton rdbTipoTripo;
    private EditText edtQuantidade;
    private CheckBox ckbBatataFrita;
    private CheckBox ckbBacon;
    private CheckBox ckbNuggets;
    private CheckBox ckbDobroQueijo;
    private Button btnSalvar;

    // Método base para a criação da tela, aqui irá fazer a identificação entre o código e o xml.
    // Este método faz parte do ciclo de vida de uma activity, será chamado sempre que for criada.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Aqui irá setar o xml da tela que criamos para que a mesma seja criada na tela do phone.
        // Todos os layouts de xml são acessados pelo código sempre pelo caminho: R.layout.___
        setContentView(R.layout.activity_tela_principal);

        // Aqui irá fazer a ligação entre o elemento da tela e o objeto criado inicialmente.
        // Após a ligação do mesmo, podemos realizar todas as funções do objeto, como alterar
        // seu texto, verificar seu status (para radio e check), inserir funções de click e
        // até mesmo alterar o tamanho de suas letras e layout.
        // Todos os ID's (android:id="@+id/____") criados no xml serão
        // acessados pelo caminho: R.id.____
        rdgTipo = (RadioGroup) findViewById(R.id.rdgTipo);
        rdbTipoSimples = (RadioButton) findViewById(R.id.rdbTipoSimples);
        rdbTipoDuplo = (RadioButton) findViewById(R.id.rdbTipoDuplo);
        rdbTipoTripo = (RadioButton) findViewById(R.id.rdbTipoTriplo);
        edtQuantidade = (EditText) findViewById(R.id.edtQuantidade);
        ckbBatataFrita = (CheckBox) findViewById(R.id.ckbBatataFrita);
        ckbBacon = (CheckBox) findViewById(R.id.ckbBacon);
        ckbNuggets = (CheckBox) findViewById(R.id.ckbNuggets);
        ckbDobroQueijo = (CheckBox) findViewById(R.id.ckbDobroQueijo);
        btnSalvar = (Button) findViewById(R.id.btnSalvar);

        // Aqui irá avisar (setar) o botão para ele reconhecer o evento de clique
        // para isso devemos informar dentro do setOnClickListener quem tratará o evento
        // que no caso é a própria tela pois la no inicio declaramos o OnClickListener para isso.
        btnSalvar.setOnClickListener(this);
    }

    // Método implementado pela interface View.OnClickListener.
    // Este método será chamado sempre que um clique for identificado na tela em algum elemento
    // que esteja esperando pelo clique.
    @Override
    public void onClick(View v) {
        // Aqui irá verificar se o que foi clicado é o botão btnSalvar
        // para isso deve comparar o ID da view clicada com o ID do botão
        if (v.getId() == R.id.btnSalvar) {
            String tipo = "";
            double valor = 0;

            if (rdbTipoSimples.isChecked()) {
                tipo = "Simples";
                valor = 6.0;
            } else if (rdbTipoDuplo.isChecked()) {
                tipo = "Duplo";
                valor = 8.0;
            } else if (rdbTipoTripo.isChecked()) {
                tipo = "Triplo";
                valor = 10.0;
            }

            int quantidade = 0;
            if (!edtQuantidade.getText().toString().trim().isEmpty())
                quantidade = Integer.parseInt(edtQuantidade.getText().toString());

            String a = "";
            if (ckbBatataFrita.isChecked()) {
                a += "Batata Frita;";
                valor += 3.0;
            }
            if (ckbBacon.isChecked()) {
                a += "Bacon;";
                valor += 1.5;
            }
            if (ckbNuggets.isChecked()) {
                a += "Nuggets;";
                valor += 3.0;
            }
            if (ckbDobroQueijo.isChecked()) {
                a += "2x Queijo;";
                valor += 1.0;
            }

            // O Toast serve para enviar ao usuário do smartphone uma mensagem, aquela mensagem
            // pretinha que aparece rapidamente e some.
            // Uma das formas (a mais comum) de se utilizar é a seguinte:
            // Toast.makeText(context, text, duration).show();
            // Context = é o contexto da aplicação, geralmente utilizamos sempre a nossa Activity,
            // por isso passamos o nome da nossa Activity (classe) seguida do this: Activity.this
            // Text = é a mensagem que irá aparecer para o usuário na tela.
            // Duration = é a duração que a mensagem ficará visível na tela, geralmente utilizamos
            // sempre as constantes definidas pelo android: Toast.LENGTH_SHORT ou Toast.LENGTH_LONG
            // O método show chamado no final é para ativar a mensagem e mostrará ao usuário,
            // por isso quando alguma mensagem não estiver aparecendo, provavelmente será
            // a falta do show()
            /*
            Toast.makeText(TelaPrincipal.this,
                    "Tipo   = " + tipo + "\n" +
                            "Qtde   = " + quantidade + "\n" +
                            "Acomp. = " + a + "\n",
                    Toast.LENGTH_LONG).show();
            */

            // AlertDialog.Builder são utilizados para dar uma mensagem ao usuário da tela,
            // sendo ela uma mensagem mais expressiva, "forçando" o usuário a ler a mensagem.
            // Com ela é possível inserir até 3 botões, positivo, negativo e neutro.
            // O botão só irá aparecer se voce setar ele, informando o texto, e seu listener.
            /*
            AlertDialog.Builder dig = new AlertDialog.Builder(this);
            dig.setMessage("Tipo   = " + tipo + "\n" +
                    "Qtde   = " + quantidade + "\n" +
                    "Acomp. = " + a + "\n");
            dig.setCancelable(false);
            dig.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //clique do botão OK
                }
            });
            dig.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //clique do botão NÂO
                }
            });
            dig.setNeutralButton("CANCEL", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //clique do botão CANCEL
                }
            });
            dig.show();
            */

            // Abrir uma nova Activity.
            // Sempre que for criar novas Activitys (telas), Services (Servicçs) e outros recursos
            // que dependem do SO, será preciso fazer isso enviando uma intent, ela nada mais é
            // que um identificador do que deverá ser chamado e o que conterá nesta chamada.
            Intent it = new Intent(this, TelaSecundaria.class);
            it.putExtra("tipo", tipo);
            it.putExtra("quantidade", quantidade);
            it.putExtra("acompanhamento", a);
            it.putExtra("valor", valor * quantidade);
            startActivity(it);


        }
    }
}
