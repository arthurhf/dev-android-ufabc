package com.example.agendadecontatos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private val arrayList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun callAddContact(view: View){
        
        val intent: Intent= Intent(applicationContext, AddContact::class.java)
        startActivity(intent)
    }

    override fun onRestart() {
        super.onRestart()

        val contato = intent.getStringExtra(AddContact.KEY_CONTACT)
        arrayList.add(contato)

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList)
        adapter.notifyDataSetChanged()

        val listaContatos = findViewById<ListView>(R.id.lista_contatos)
        listaContatos.adapter= adapter

    }
}
