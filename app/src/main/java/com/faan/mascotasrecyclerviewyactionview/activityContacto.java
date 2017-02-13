package com.faan.mascotasrecyclerviewyactionview;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class activityContacto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactos);
    }

    public void enviarMensaje(View v){

        TextView tn= (TextView) findViewById(R.id.editNombre);
        TextView tm= (TextView) findViewById(R.id.editMensaje);
        TextView tc= (TextView) findViewById(R.id.editCorreo);
        String[] to = { "faan03@gmail.com" } ; //, "otroEmail@ejemplo.com" };
       String[] cc = { tc.getText().toString() };
        enviar(to, cc, "Hola este es un mensaje",
                 "Mensaje: "+ tm.getText() + "Enviado por" +   tn.getText());
    }

    private void enviar(String[] to, String[] cc,
                        String asunto, String mensaje) {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
        emailIntent.putExtra(Intent.EXTRA_CC, cc);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, asunto);
        emailIntent.putExtra(Intent.EXTRA_TEXT, mensaje);
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent, "Email "));
    }
}
