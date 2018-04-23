package com.a2msproject.berbagi_layout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.a2msproject.berbagi_layout.Donatur.MainActivityDonatur;
import com.a2msproject.berbagi_layout.Panti.MainActivityPantiAsuhan;

public class Login extends AppCompatActivity {

    TextView btnregister;
    Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        btnlogin=(Button)findViewById(R.id.btnLogin);
        btnregister=(TextView) findViewById(R.id.btnRegister);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final CharSequence[] items = { "Donatur", "Panti Asuhan", "Batal" };

                AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                builder.setTitle("Mendaftar sebagai:");
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        if (items[item].equals("Donatur")) {
                            startActivity(new Intent(Login.this,Register_Donatur_Activity.class));
                        } else if (items[item].equals("Panti Asuhan")) {
                            startActivity(new Intent(Login.this,Register_Panti_Asuhan_Activity.class));
                        } else if (items[item].equals("Batal")) {
                            dialog.dismiss();
                        }
                    }
                });
                builder.show();
            }
        });
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final CharSequence[] items = { "Donatur", "Panti Asuhan", "Batal" };

                AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                builder.setTitle("Masuk sebagai:");
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        if (items[item].equals("Donatur")) {
                            startActivity(new Intent(Login.this,MainActivityDonatur.class));
                        } else if (items[item].equals("Panti Asuhan")) {
                            startActivity(new Intent(Login.this,MainActivityPantiAsuhan.class));
                        } else if (items[item].equals("Batal")) {
                            dialog.dismiss();
                        }
                    }
                });
                builder.show();
            }
        });

    }

}
