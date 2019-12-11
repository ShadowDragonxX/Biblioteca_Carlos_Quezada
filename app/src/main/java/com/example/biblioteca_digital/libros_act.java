package com.example.biblioteca_digital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class libros_act extends AppCompatActivity {

    private Spinner sp;
    private EditText cantidad;
    private EditText costo;
    private Button btn;
    private TextView txt;
    private String[] valoresLibros= {"5000","12000","25000","5000","3000","1000","10000"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libros_act);
        sp= (Spinner)findViewById(R.id.spinner);
        cantidad=(EditText)findViewById(R.id.editText4);
        costo=(EditText)findViewById(R.id.editText3);
        btn=(Button)findViewById(R.id.button2);
        txt=(TextView)findViewById(R.id.textView7);

        String  arrayLibros= getIntent().getStringExtra("libros");

        Bundle list=  getIntent().getExtras();
        String[] arrayList= list.getStringArray("libros");


        ArrayAdapter adpt = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,arrayList);
        sp.setAdapter(adpt);
    }
    public void  Calculo(View view)
    {
        if(sp.getSelectedItem().equals("Fahrenheit"))
        {
            String precioFahrenheit= valoresLibros[0];
            int cantidad2= Integer.parseInt(cantidad.getText().toString());
            int costo2= Integer.parseInt(costo.getText().toString());
            int precioLibro = Integer.parseInt(precioFahrenheit);
            int resultado= precioLibro*cantidad2+costo2;
            txt.setText("Stock disponible: "+cantidad2+"\n"+
                        "El precio final es: "+ resultado);
        }
        else if(sp.getSelectedItem().equals("Revival"))
        {
            String precioFahrenheit= valoresLibros[1];
            int cantidad2= Integer.parseInt(cantidad.getText().toString());
            int costo2= Integer.parseInt(costo.getText().toString());
            int precioLibro = Integer.parseInt(precioFahrenheit);
            int resultado= precioLibro*cantidad2+costo2;
            txt.setText("Stock disponible: "+cantidad2+"\n"+
                    "El precio final es: "+ resultado);
        }
        else if(sp.getSelectedItem().equals("Tesla"))
        {
            String precioFahrenheit= valoresLibros[2];
            int cantidad2= Integer.parseInt(cantidad.getText().toString());
            int costo2= Integer.parseInt(costo.getText().toString());
            int precioLibro = Integer.parseInt(precioFahrenheit);
            int resultado= precioLibro*cantidad2+costo2;
            txt.setText("Stock disponible: "+cantidad2+"\n"+
                    "El precio final es: "+ resultado);
        }
    }
    public void mqtt(View view)
    {
        Intent i = new Intent(this,Mqtt_act.class);
        startActivity(i);
    }
}
