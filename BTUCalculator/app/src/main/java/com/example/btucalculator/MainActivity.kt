package com.example.btucalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var areaText: TextView
    private lateinit var pessoasText: TextView
    private lateinit var btuText: TextView
    private lateinit var areaSeek: SeekBar
    private lateinit var pessoasSeek: SeekBar
    private lateinit var rgluz: RadioGroup
    private lateinit var rb600: RadioButton
    private lateinit var rb800: RadioButton
    private  var btuFactor =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onRestart() {
        super.onRestart()
        bindComponents()
        bindSeekbarHandlers()
        init()
    }

    override fun onStart() {
        super.onStart()
        bindComponents()
        bindSeekbarHandlers()
        init()
    }

    private fun bindComponents() {
        areaText = findViewById(R.id.area_text)
        pessoasText = findViewById(R.id.pessoas_text)
        btuText = findViewById(R.id.btu_text)
        areaSeek = findViewById(R.id.seekBarArea)
        pessoasSeek = findViewById(R.id.seekBarPessoas)
        rgluz = findViewById(R.id.radioGroup)
        rb600 = findViewById(R.id.radioButton600)
        rb800 = findViewById(R.id.radioButton800)


    }

    private fun init() {
        areaSeek.progress = 10
        pessoasSeek.progress = 2
    }

    fun updateBtu() {
        val area = areaSeek.progress.toDouble()
        val pessoas = pessoasSeek.progress.toDouble()

        var btu = 0.0

        btu = btuFactor * (area + (pessoas -1)) //btu_factor é setado pela checkbox

        btuText.text = "Total de BTU's = %.0f".format(btu)

    }

    fun onRadioButtonClicked(view: View) {

        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.radioButton600 ->
                    if (checked) {
                        btuFactor = 600
                    }
                R.id.radioButton800 ->
                    if (checked) {
                        btuFactor = 800
                    }
            }
        }
    }

    fun updateArea(progress: Int) {
        areaText.text = "$progress m²"
        updateBtu()
    }

    fun updatePessoas(progress: Int) {
        pessoasText.text = "$progress"
        updateBtu()
    }

    private fun bindSeekbarHandlers() {
        areaSeek.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                updateArea(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}

            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })
        pessoasSeek.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                updatePessoas(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}

            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })
    }
}
