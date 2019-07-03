package br.edu.ufabc.padm.ebooklibrary.model

/**
 * Here we implement two DAO Singleton strategies (via object and via class)
 */


import java.util.ArrayList

/**
 * An alias that selects which strategy to employ application-wise
 */

typealias EbookDAO = EbookDAOObject

/**
 * Singleton pattern implemented with a Kotlin object declaration (https://bit.ly/31J1Ev2)
 */
object EbookDAOObject {
    private val ebooks: MutableList<Ebook> = ArrayList()
    val instance = this

    init {
        // TODO: remove when "add" operation is implemented
        loadTestData()
    }

    private fun loadTestData() {
        var c: Ebook

        c = Ebook()

        c.titulo = "Dissertacao mestrado"
        c.autor = "Arthur H F"
        c.isbn= "isbn"
        c.anoPublicacao= "2022"
        c.editora= "ufabc"
        c.avaliacao= "4"

        ebooks.add(c)

        c = Ebook()
        c.titulo = "Dissertacao doutorado"
        c.autor = "Arthur H F"
        c.isbn= "isbn"
        c.anoPublicacao= "2025"
        c.editora= "ufabc"
        c.avaliacao= "5"

        ebooks.add(c)

        c = Ebook()
        c.titulo = "Fenômenos mecânicos"
        c.autor = "Serway"
        c.isbn= "isbn"
        c.anoPublicacao= "1950"
        c.editora= "alguma gringa"
        c.avaliacao= "4"

        ebooks.add(c)
    }

    fun add(ebook: Ebook) {
        ebooks.add(ebook)
    }

    fun size(): Int {
        return ebooks.size
    }

    fun getItemAt(pos: Int): Ebook {
        return ebooks[pos]
    }
}

/**
 * Singleton pattern implemented with a class
 */
class EbookDAOClass private constructor() {
    private var ebooks: MutableList<Ebook> = ArrayList()

    init {
        // TODO: remove when "add" operation is implemented
        loadTestData()
    }

    companion object {
        val instance = EbookDAOClass()
    }

    private fun loadTestData() {
        var c: Ebook

        c = Ebook()

        c.titulo = "Dissertacao mestrado"
        c.autor = "Arthur H F"
        c.isbn= "isbn"
        c.anoPublicacao= "2022"
        c.editora= "ufabc"
        c.avaliacao= "4"

        ebooks.add(c)

        c = Ebook()
        c.titulo = "Dissertacao doutorado"
        c.autor = "Arthur H F"
        c.isbn= "isbn"
        c.anoPublicacao= "2025"
        c.editora= "ufabc"
        c.avaliacao= "5"

        ebooks.add(c)

        c = Ebook()
        c.titulo = "Fenômenos mecânicos"
        c.autor = "Serway"
        c.isbn= "isbn"
        c.anoPublicacao= "1950"
        c.editora= "alguma gringa"
        c.avaliacao= "4"

        ebooks.add(c)
    }

    fun add(ebook: Ebook) {
        ebooks.add(ebook)
    }

    fun size(): Int {
        return ebooks.size
    }

    fun getItemAt(pos: Int): Ebook {
        return ebooks[pos]
    }

}