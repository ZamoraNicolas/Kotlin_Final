package com.example.nota

import android.content.Intent
import android.os.Bundle
import android.service.controls.actions.FloatAction
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.firestore.FirebaseFirestore

class Home : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    private lateinit var recyclerView: RecyclerView
    private lateinit var fab: FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        val caja : TextView = findViewById( R.id.recibir)
        val Buttoncerrar : Button = findViewById(R.id.Cerrar)
        val saveButton :Button = findViewById(R.id.saveButton)
        val extras = intent.extras
        if (extras != null) {
            val email = extras.getString("clave")
            caja.text=email
            Buttoncerrar.setOnClickListener() {
                FirebaseAuth.getInstance().signOut()
                val Salir = Intent(this, MainActivity::class.java)
                startActivity(Salir)
            }
            saveButton.setOnClickListener {
                val nota1EditText: EditText = findViewById(R.id.nota1)
                val nota2EditText: EditText = findViewById(R.id.nota2)
                val nota3EditText: EditText = findViewById(R.id.nota3)
                val nota4EditText: EditText = findViewById(R.id.nota4)

                val nota1 = nota1EditText.text.toString()
                val nota2 = nota2EditText.text.toString()
                val nota3 = nota3EditText.text.toString()
                val nota4 = nota4EditText.text.toString()

                val notas = hashMapOf(
                    "nota1" to nota1,
                    "nota2" to nota2,
                    "nota3" to nota3,
                    "nota4" to nota4
                )

                db.collection("users").document(email.toString()).set(notas)
            }
            val promedio : TextView = findViewById( R.id.promedio)
            val calcularPromedioButton: Button = findViewById(R.id.calcularPromedioButton)
            calcularPromedioButton.setOnClickListener {
                val nota1EditText: EditText = findViewById(R.id.nota1)
                val nota2EditText: EditText = findViewById(R.id.nota2)
                val nota3EditText: EditText = findViewById(R.id.nota3)
                val nota4EditText: EditText = findViewById(R.id.nota4)
                val promedioTextView: TextView = findViewById(R.id.promedio)

                val nota1 = nota1EditText.text.toString().toDoubleOrNull() ?: 0.0
                val nota2 = nota2EditText.text.toString().toDoubleOrNull() ?: 0.0
                val nota3 = nota3EditText.text.toString().toDoubleOrNull() ?: 0.0
                val nota4 = nota4EditText.text.toString().toDoubleOrNull() ?: 0.0

                val totalNotas = nota1 + nota2 + nota3 + nota4
                val cantidadNotas = if (nota1 != 0.0) 1 else 0 +
                        if (nota2 != 0.0) 1 else 0 +
                                if (nota3 != 0.0) 1 else 0 +
                                        if (nota4 != 0.0) 1 else 0

                val promedio = if (cantidadNotas != 0) totalNotas / 4 else 0.0

                promedioTextView.text = "Promedio: $promedio"
            }
        }


    }


    }


