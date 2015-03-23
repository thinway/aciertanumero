package acierto.thinway.org.aciertanumero;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    EditText    mNumero;
    Button      mComprobarNumero;
    Button      mNuevaPartida;
    TextView    mMensaje;
    int         mNumeroAcertar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mNumeroAcertar = (int)(Math.random() * 50 + 1);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNumero = (EditText)findViewById(R.id.numberEditText);
        mComprobarNumero = (Button)findViewById(R.id.testNumberButton);
        mNuevaPartida = (Button)findViewById(R.id.newNumberButton);
        mMensaje = (TextView)findViewById(R.id.messageTextView);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void comprobarNumero(View view) {
        int numeroPropuesto = Integer.parseInt(mNumero.getText().toString());

        if( mNumeroAcertar > numeroPropuesto ){
            mMensaje.setText("El número es mayor.");
        } else if (mNumeroAcertar < numeroPropuesto ){
            mMensaje.setText("El número es menor.");
        } else {
            Toast toast = Toast.makeText(
                    getApplicationContext(),
                    "Bravo!!! Acertaste!!!",
                    Toast.LENGTH_LONG
            );

            toast.show();

            mNumeroAcertar = (int)(Math.random() * 50 + 1);
            mMensaje.setText("Nuevo número. A jugar!!!");
        }
    }

    public void nuevaPartida(View view) {
        mNumeroAcertar = (int)(Math.random() * 50 + 1);
        Toast toast = Toast.makeText(
                getApplicationContext(),
                "Generando nuevo número ...",
                Toast.LENGTH_LONG
        );

        toast.show();

        mMensaje.setText("Nuevo número. A jugar!!!");
    }
}
