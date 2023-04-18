package com.duvarax.tpanexobmoviles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.duvarax.tpanexobmoviles.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MainActivityViewModel mv;

    @Override
    protected void onPause() {
        super.onPause();
        binding.etContraseA.setText("");
        binding.etUsuario.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mv = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        mv.getLogeado().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean logeado) {

                Toast.makeText(MainActivity.this, "No fue posible logearse", Toast.LENGTH_LONG).show();


            }
        });

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mv.logear(binding.etUsuario.getText()+"", binding.etContraseA.getText()+"");
            }
        });

    }
}