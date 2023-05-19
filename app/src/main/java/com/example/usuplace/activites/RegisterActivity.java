package com.example.usuplace.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.usuplace.R;
import com.example.usuplace.DBmanager;
import com.example.usuplace.User;

public class RegisterActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextPhone;
    private EditText editTextMunicipality;
    private EditText editTextDepartment;
    private EditText editTextPassword;
    private Button buttonRegister;

    private DBmanager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dbManager = new DBmanager(this);

        // Obtener referencias de los elementos de la interfaz
        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextMunicipality = findViewById(R.id.editTextMunicipality);
        editTextDepartment = findViewById(R.id.editTextDepartment);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonRegister = findViewById(R.id.buttonRegister);

        // Configurar el evento de clic del botón de registro
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    private void registerUser() {
        // Obtener los valores ingresados por el usuario
        String name = editTextName.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String phone = editTextPhone.getText().toString().trim();
        String municipality = editTextMunicipality.getText().toString().trim();
        String department = editTextDepartment.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        // Validar los campos (puedes agregar tus propias validaciones aquí)

        // Verificar si el usuario ya existe
        if (dbManager.checkUserExists(email)) {
            Toast.makeText(this, "El correo electrónico ya está registrado", Toast.LENGTH_SHORT).show();
            return;
        }

        // Crear un objeto User con los datos ingresados
        User user = new User(name, email, phone, municipality, department, password);

        // Agregar el usuario a la base de datos
        dbManager.addUser(user);

        // Mostrar un mensaje de éxito
        Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();

        // Puedes agregar aquí el código para redirigir al usuario a otra actividad después del registro
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
