package com.example.nota

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class Register : AppCompatActivity() {

    private lateinit var firebaseAuth:FirebaseAuth
    private lateinit var authStateListener: FirebaseAuth.AuthStateListener

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val BotonRegistrarse : Button = findViewById(R.id.Registarse)
        val Correo : TextView = findViewById(R.id.email)
        val Contrasena : TextView = findViewById(R.id.password)
        val Redirigir: Button = findViewById(R.id.ingresar)
        firebaseAuth = Firebase.auth
        BotonRegistrarse.setOnClickListener() {
            if ((Correo.text.toString() != "") && (Contrasena.text.toString() != "")) {
                Register(Correo.text.toString(), Contrasena.text.toString())
                val intentEmail = Intent(this, Home::class.java)
                intentEmail.putExtra("clave", Correo.text.toString())
                startActivity(intentEmail)

            }
            else{
                Toast.makeText(baseContext,"Esta vacio",Toast.LENGTH_SHORT).show()
            }
        }
        Redirigir.setOnClickListener(){
            val intent3 = Intent(this, MainActivity::class.java)
            startActivity(intent3)
        }
    }

    private fun Register(email : String,password : String){
        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this){
                task -> if (task.isSuccessful){
            Toast.makeText(baseContext,"Regitro completado",Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(baseContext,"No fue posible registrar el usuario",Toast.LENGTH_SHORT).show()
        }
        }
    }
}
