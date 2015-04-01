package br.edu.fatecriopreto.salario;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class SalarioActivity extends ActionBarActivity {

    EditText edtSalario;
    Button btnCalcular;
    RadioGroup rdgGrupo;
    RadioButton rdbJunior;
    RadioButton rdbPleno;
    RadioButton rdbSenior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salario);

        edtSalario = (EditText) findViewById(R.id.edtSalario);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        rdgGrupo = (RadioGroup) findViewById(R.id.rdgGrupo);

        final AlertDialog alertDialog =
                new AlertDialog.Builder(this).create();

        alertDialog.setTitle("NOVO SALÁRIO");
        alertDialog.setIcon(R.drawable.ic_launcher);

        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE,
                "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        alertDialog.dismiss();
                    }
                });

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Double salarioAtual = 0d;
                Double salarioNovo = 0d;

                salarioAtual =
                        Double.parseDouble(edtSalario.getText().toString());

                int radio = rdgGrupo.getCheckedRadioButtonId();

                switch (radio){
                    case R.id.rdbJunior:
                        salarioNovo = salarioAtual + (salarioAtual * 0.09);
                        alertDialog.setMessage("Novo: " + salarioNovo);
                        break;

                    case R.id.rdbPleno:
                        salarioNovo = salarioAtual + (salarioAtual * 0.2);
                        alertDialog.setMessage("Novo: " + salarioNovo);
                        break;

                    case R.id.rdbSenior:
                        salarioNovo = salarioAtual + (salarioAtual * 0.31);
                        alertDialog.setMessage("Novo: " + salarioNovo);
                        break;
                }

                alertDialog.show();



            }
        });


    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_salario, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
