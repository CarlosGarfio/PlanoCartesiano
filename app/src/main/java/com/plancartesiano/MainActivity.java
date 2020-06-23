package com.plancartesiano;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.plancartesiano.model.Punto2D;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random random;

    EditText X1;
    EditText Y1;
    EditText X2;
    EditText Y2;
    TextView resultado;

    Punto2D p1;
    Punto2D p2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        p1 = new Punto2D();
        p2 = new Punto2D();

        random = new Random();

        X1 = findViewById(R.id.etX1);
        Y1 = findViewById(R.id.etY1);
        X2 = findViewById(R.id.etX2);
        Y2 = findViewById(R.id.etY2);

        resultado = findViewById(R.id.txtResultado);

        Button btnCalcular = findViewById(R.id.btnCalcular);

        llenarCampos();

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x1 = Integer.parseInt(X1.getText().toString());
                int y1 = Integer.parseInt(Y1.getText().toString());
                int x2 = Integer.parseInt(X2.getText().toString());
                int y2 = Integer.parseInt(Y2.getText().toString());

                p1.setXY(x1, y1);
                p2.setXY(x2, y2);

                String txt = "Punto 1 se encuentra en (" + p1.getX() + "," + p1.getY() + ")" +
                        "\nPunto 2 se encuentra en (" + p2.getX() + "," + p2.getY() + ")" +
                        "\nSu distancia es: " + calcularDistancia(p1, p2) +
                        "\nSu pendiente es: " + calcularPendiente(p1, p2);

                resultado.setText(txt);
            }
        });
    }

    void llenarCampos() {
        X1.setText(String.valueOf(random.nextInt(200)));
        Y1.setText(String.valueOf(random.nextInt(200)));
        X2.setText(String.valueOf(random.nextInt(200)));
        Y2.setText(String.valueOf(random.nextInt(200)));
    }

    double calcularDistancia(Punto2D p1, Punto2D p2) {
        return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
    }

    double calcularPendiente(Punto2D p1, Punto2D p2) {
        double divisor = (double) (p2.getX() - p1.getX());
        return (divisor != 0) ? (p2.getY() - p1.getY()) / divisor : Double.POSITIVE_INFINITY;
    }
}