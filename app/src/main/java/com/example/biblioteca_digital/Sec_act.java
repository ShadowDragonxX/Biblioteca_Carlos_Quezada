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
    private SecretKeySpec generateKey(String password) throws Exception {

        MessageDigest sha = MessageDigest.getInstance("SHA-256");  //firma hmac se utiliza para verificar al integridad de los datos
        byte[] key = password.getBytes("UTF-8"); // el estandar del pass es UTF-8
        key = sha.digest(key);  // pasamos la firma a nuestra key
        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
        return secretKey;
    }
    public String Encriptar(String datos, String password) throws Exception {

            SecretKeySpec secretKey = generateKey(password);   // se declara la funcion SecretKeySpec para generar la llave.
            Cipher cipher = Cipher.getInstance("AES");         // Utilizamos Cipher clase que me permite trabajar con algoritmos.
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);       // iniciamos nuestra Encriptación en nuestra llave.

            byte[] datosEncriptadosBytes = cipher.doFinal(datos.getBytes()); // cadena de bytes para su encriptación.
            String datosEncriptadosString = Base64.encodeToString(datosEncriptadosBytes, Base64.DEFAULT); // encode a string
            return datosEncriptadosString;  // retornamos a la clave.

    }

    public void incidencia(View view)
    {
        wb.loadUrl("http://www.example.com");
        txt1.setText("Vulnerabilidad por protocolos\n no seguros");

    }
    public void incidenciaDos(View view)
    {
        try {
            mensaje = Encriptar(usuario,contraseña);
            txt1.setText("Vulnerabilidad de nivel \n alto \n" +mensaje);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    class Echo {

        // Control de Proceso

        // Posible reemplazo de librería por una maliciosa
        // Donde además se nos muestra el nombre explícito de esta.

        public native void runEcho();

        {
            System.loadLibrary("echo"); // Se carga librería sospechosa

        }

        // ejecutamos la libería.
        public void main(String[] args) {
            new Echo().runEcho();
        }
    }
}
