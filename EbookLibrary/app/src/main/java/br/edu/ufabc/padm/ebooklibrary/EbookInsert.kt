package br.edu.ufabc.padm.ebooklibrary

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.edu.ufabc.padm.ebooklibrary.model.Ebook
import br.edu.ufabc.padm.ebooklibrary.model.EbookDAO

class EbookInsert: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ebook_insert)
    }

    private fun handleInsert() {
        val titulo = (findViewById<EditText>(R.id.insert_ebook_titulo)).text.toString()
        val autor = (findViewById<EditText>(R.id.insert_ebook_autor)).text.toString()
        val isbn = (findViewById<EditText>(R.id.insert_ebook_isbn)).text.toString()
        val anopublicacao = (findViewById<EditText>(R.id.insert_ebook_anopublicacao)).text.toString()
        val editora = (findViewById<EditText>(R.id.insert_ebook_editora)).text.toString()
        val avaliacao = (findViewById<EditText>(R.id.insert_ebook_avaliacao)).text.toString()
        val ebook = Ebook()

        ebook.titulo = titulo
        ebook.autor = autor
        ebook.isbn = isbn
        ebook.anoPublicacao= anopublicacao
        ebook.editora= editora
        ebook.avaliacao = avaliacao
        EbookDAO.instance.add(ebook)

        Toast.makeText(this, getString(R.string.insert_status_ok), Toast.LENGTH_SHORT).show()
        finish()
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_ebook_insert, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        return if (id == R.id.action_save) {
            handleInsert()
            true
        } else super.onOptionsItemSelected(item)

    }
}