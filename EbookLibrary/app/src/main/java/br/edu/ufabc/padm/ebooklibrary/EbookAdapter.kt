package br.edu.ufabc.padm.ebooklibrary
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

import br.edu.ufabc.padm.ebooklibrary.model.EbookDAO


class EbookAdapter : BaseAdapter() {

    override fun getCount(): Int {
        return EbookDAO.instance.size()
    }

    override fun getItem(position: Int): Any {
        return EbookDAO.instance.getItemAt(position)
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = App.context.getSystemService(
            Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val localView = convertView ?: inflater.inflate(R.layout.ebook_list_item, null)
        val ebook = EbookDAO.instance.getItemAt(position)
        val titulo = localView.findViewById<TextView>(R.id.ebook_titulo)
        val autor = localView.findViewById<TextView>(R.id.ebook_autor)
        val avaliacao = localView.findViewById<TextView>(R.id.ebook_avaliacao)

        titulo.text = ebook.titulo
        autor.text = ebook.autor
        avaliacao.text = ebook.avaliacao.toString()

        return localView
    }
}