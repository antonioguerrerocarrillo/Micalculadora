package com.example.micalculadora.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.micalculadora.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    Button boton0, boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8, boton9, botonPunto, botonSuma, botonbResta, botonMultiplicacion, botonDivision, bIgual, bBorrar;

    TextView view_2,view_1 ;

    double subtotal;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);


            view_2 = (TextView) root.findViewById(R.id.textView2);
            view_1 = (TextView) root.findViewById(R.id.textView3);



            boton0 = (Button) root.findViewById(R.id.button2);
            boton0.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    view_2.setText(view_2.getText() + "0");
                }

            });

            boton1 = (Button) root.findViewById(R.id.button5);
            boton1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    view_2.setText(view_2.getText() + "1");
                }

            });

            boton2 = (Button) root.findViewById(R.id.button5);
            boton2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    view_2.setText(view_2.getText() + "2");
                }

            });

            boton3 = (Button) root.findViewById(R.id.button7);
            boton3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    view_2.setText(view_2.getText() + "3");
                }

            });

            boton4 = (Button) root.findViewById(R.id.button9);
            boton4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    view_2.setText(view_2.getText() + "4");
                }

            });

            boton5 = (Button) root.findViewById(R.id.button10);
            boton5.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    view_2.setText(view_2.getText() + "5");
                }

            });

            boton6 = (Button) root.findViewById(R.id.button11);
            boton6.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    view_2.setText(view_2.getText() + "6");
                }

            });

            boton7 = (Button) root.findViewById(R.id.button13);
            boton7.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    view_2.setText(view_2.getText() + "7");
                }

            });

            boton8 = (Button) root.findViewById(R.id.button14);
            boton8.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    view_2.setText(view_2.getText() + "8");
                }

            });

            boton9 = (Button) root.findViewById(R.id.button15);
            boton9.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    view_2.setText(view_2.getText() + "9");
                }
            });

            botonPunto = (Button) root.findViewById(R.id.button3);
            botonPunto.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    view_2.setText(view_2.getText() + ".");
                }

            });

            //Suma
            botonSuma = (Button) root.findViewById(R.id.button16);
            botonSuma.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    subtotal = Double.valueOf((String) view_2.getText()).doubleValue();
                    view_2.setText("");
                    view_1.setText("+");
                }

            });

            //Resta
            botonbResta = (Button) root.findViewById(R.id.button17);
            botonbResta.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    subtotal = Double.valueOf((String) view_2.getText()).doubleValue();
                    view_2.setText("");
                    view_1.setText("-");
                }

            });

            //Multiplicacion
            botonMultiplicacion = (Button) root.findViewById(R.id.button18);
            botonMultiplicacion.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    subtotal = Double.valueOf((String) view_2.getText()).doubleValue();
                    view_2.setText("");
                    view_1.setText("X");
                }

            });

            //División
            botonDivision = (Button) root.findViewById(R.id.button19);
            botonDivision.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    subtotal = Double.valueOf((String) view_2.getText()).doubleValue();
                    view_2.setText("");
                    view_1.setText("/");
                }

            });

            //Si pulsa =
            bIgual = (Button) root.findViewById(R.id.button12);
            bIgual.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    double numero = Double.valueOf((String) view_2.getText()).doubleValue();
                    String operacion = view_1.getText().toString();
                    if (operacion != "") {
                        if (operacion == "+")
                            subtotal = numero + subtotal;
                        else if (operacion == "-")
                            subtotal = subtotal - numero;
                        else if (operacion == "X")
                            subtotal = subtotal * numero;
                        else if (operacion == "/")
                            subtotal = subtotal / numero;
                        String resultado = String.valueOf(subtotal);
                        int longitud = resultado.length();

                        //Si acaba en .0 muestro como entero
                        if ((resultado.charAt(longitud - 2) == '.') && (resultado.charAt(longitud - 1) == '0'))
                            resultado = resultado.substring(0, resultado.length() - 2);
                        view_2.setText(resultado);
                        view_1.setText("");
                    }
                }

            });

            // Cuando pulsas  C para que se borre el contenido de la operacion
            bBorrar = (Button) root.findViewById(R.id.button4);
            bBorrar.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    subtotal = 0;
                    view_2.setText("");
                    view_1.setText("");
                }

            });
        return root;

    }
}