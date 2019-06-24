package com.example.agendadecontatos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class AddContact : AppCompatActivity() {

    companion object {
        const val KEY_CONTACT = "contato"
    }

    private lateinit var nomeContato: TextView
    private lateinit var emailContato: TextView
    private lateinit var enderecoContato: TextView
    private lateinit var numberSigned: TextView
    private lateinit var numberContato: TextView
    private lateinit var numberDecimal: TextView
    private lateinit var foneContato: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contact)
    }

    override fun onStart() {
        super.onStart()
        bindComponents()
    }

    override fun onRestart() {
        super.onRestart()
        bindComponents()
    }

    private fun bindComponents() {
        nomeContato = findViewById(R.id.nome_contato)
        emailContato = findViewById(R.id.email_contato)
        enderecoContato = findViewById(R.id.endereco_contato)
        numberSigned = findViewById(R.id.number_signed)
        numberContato = findViewById(R.id.number_contato)
        numberDecimal = findViewById(R.id.number_decimal)
        foneContato = findViewById(R.id.telefone_contato)
    }

    fun addContact(view: View) {
        val contato: String  = "" + nomeContato.text.toString() + " " +  emailContato.text.toString() + " " + enderecoContato.text.toString() + " " + numberSigned.text.toString() + " " + numberContato.text.toString() + " " + numberContato.text.toString()+ " " + numberDecimal.text.toString() + " " + foneContato.text.toString()

        val intent: Intent= Intent(applicationContext, MainActivity::class.java)
        intent.putExtra(KEY_CONTACT,contato)

        startActivity(intent)

    }

    fun clearFields(view: View) {
        nomeContato.text = ""
        emailContato.text = ""
        enderecoContato.text = ""
        numberSigned.text = ""
        numberContato.text = ""
        numberDecimal.text = ""
        foneContato.text = ""
        bindComponents()
    }

}

