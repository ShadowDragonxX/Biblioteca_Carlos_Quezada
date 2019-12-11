package com.example.biblioteca_digital;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Sec_act extends AppCompatActivity {
    private TextView txt1;
    private WebView wb;
    private String mensaje;
    private String usuario;
    private String contraseña;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec_act);
        txt1=findViewById(R.id.textView);
        wb=findViewById(R.id.wb);
        usuario ="carlos";
        contraseña="1234";
    }

    public void incidencia(View view)
    {
        wb.loadUrl("http://www.example.com");
        txt1.setText("Vulnerabilidad por protocolos\n no seguros");

    }
    public void incidenciaDos(View view) {
        String[] lista = {"345", "985", "ABC", "abc", "666"};
        txt1.setText("Si la contraseña ingresada es: " + lista[0] + " " + lista[1] + " " + lista[2] + "\n" +
                lista[3]+ " "+lista[4]+"\n"+
                "la vulneravilidad que nos afecta es Hard-coded-password");
    }
}
