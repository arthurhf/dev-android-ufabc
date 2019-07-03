package br.edu.ufabc.padm.ebooklibrary

import br.edu.ufabc.padm.ebooklibrary.model.EbookDAO
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EbookShow : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ebook_show)
        showContato()
    }

    private fun showContato() {
        val pos = intent.extras?.getInt("contactPosition") ?: 0
        val ebook = EbookDAO.instance.getItemAt(pos)

        (findViewById<TextView>(R.id.ebook_item_titulo)).text = ebook.titulo
        (findViewById<TextView>(R.id.ebook_item_autor)).text = ebook.autor
        (findViewById<TextView>(R.id.ebook_item_isbn)).text = ebook.isbn
        (findViewById<TextView>(R.id.ebook_item_anopublicacao)).text = ebook.anoPublicacao
        (findViewById<TextView>(R.id.ebook_item_editora)).text = ebook.editora
        (findViewById<TextView>(R.id.ebook_item_avaliacao)).text = ebook.avaliacao.toString()
    }
}