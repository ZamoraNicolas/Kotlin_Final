package com.example.nota

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class  MainActivity : AppCompatActivity() {

    private lateinit var firebaseAuth:FirebaseAuth
    private lateinit var authStateListener: FirebaseAuth.AuthStateListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val BotonRegistrarse : Button = findViewById(R.id.registrarse)
        val Correo : TextView = findViewById(R.id.correo)
        val Contrasena : TextView = findViewById(R.id.contrasena)
        val redirigir : Button = findViewById(R.id.Redirigir)
        firebaseAuth = Firebase.auth
        BotonRegistrarse.setOnClickListener() {
            if ((Correo.text.toString() != "") && (Contrasena.text.toString() != "")) {
                singIn(Correo.text.toString(), Contrasena.text.toString())
                val intentEmail = Intent(this, Home::class.java)
                intentEmail.putExtra("clave", Correo.text.toString())
                startActivity(intentEmail)
            }
            else{
                Toast.makeText(baseContext,"Esta vacio",Toast.LENGTH_SHORT).show()
            }
        }

        redirigir.setOnClickListener(){
            val intent2 = Intent(this, Register::class.java)
            startActivity(intent2)
        }

        }

        private fun singIn(email : String,password : String){
            firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this){
                task -> if (task.isSuccessful){
                Toast.makeText(baseContext,"Acceso correcto",Toast.LENGTH_SHORT).show()
            }
                else{
                    Toast.makeText(baseContext,"Ingrese correoy contraseña",Toast.LENGTH_SHORT).show()
            }
            }
        }
    }
