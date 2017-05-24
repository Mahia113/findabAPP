package com.android.findab;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;


public class login extends AppCompatActivity{
    private EditText usuario;
    private TextInputEditText password;
    private TextInputLayout TILUser,TILPass;
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.login);
        usuario = (EditText) findViewById(R.id.ETUsuario);
        password = (TextInputEditText) findViewById(R.id.TIETPass);
        TILUser = (TextInputLayout) findViewById(R.id.TILUsuario);
        TILPass = (TextInputLayout) findViewById(R.id.TILPassword);
    }
    public void login(View v){
        String u = usuario.getText().toString();
        String p = password.getText().toString();
        if (!comprobarUsuario(u,p)) {
            return;
        }
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage("Logueando con el servidor de FindApp... Espere...");
        dialog.setCancelable(false);
        dialog.show();
        if(u.equalsIgnoreCase("findapp") && p.equalsIgnoreCase("findapp")){
            new android.os.Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    dialog.dismiss();
                    Intent intent = new Intent(login.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, 4000);
        }else{
            Snackbar.make(v,"Usuario o Contraseña incorrectos",Snackbar.LENGTH_LONG).show();
            dialog.dismiss();
        }
    }


    public boolean comprobarUsuario(String u,String p){
        boolean flag = true;

        if(u.isEmpty()){

            usuario.requestFocus();
            TILUser.setError("No debe de ir vacio");
            flag = false;
        }else{
            TILUser.setError(null);
        }
        if(p.isEmpty()){
            password.requestFocus();
            TILPass.setError("No debe ir vacio");
            flag = false;
        }
        return flag;
    }
}
