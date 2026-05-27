package com.example.aula_mob_exerc_icms

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var mEditTextEstado: EditText
    private lateinit var mEditTextValor: EditText
    private lateinit var mTextViewPorcentagem: TextView
    private lateinit var mTextViewTotal: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mEditTextEstado = findViewById(R.id.textEstado)
        mEditTextValor = findViewById(R.id.textValorMercadoria)
        mTextViewPorcentagem = findViewById(R.id.textIcmsPorcentagem)
        mTextViewTotal = findViewById(R.id.textValorTotal)


    }

    fun calcular(view: View) {

        val estado: String = mEditTextEstado.text.toString().trim().uppercase()
        val valorString: String = mEditTextValor.text.toString()
        val valor: Float = valorString.toFloat()
        val porcentagem: Float
        val valorTotal: Float

        when (estado) {

            "SC" -> porcentagem = 0.17f
            "ES" -> porcentagem = 0.17f
            "MS" -> porcentagem = 0.17f
            "RS" -> porcentagem = 0.17f
            "GO" -> porcentagem = 0.175f
            "SP" -> porcentagem = 0.18f
            "PR" -> porcentagem = 0.18f
            else -> porcentagem = 0.0f

        }

        valorTotal = valor + (valor * porcentagem)

        mTextViewPorcentagem.text = "${porcentagem * 100}%"
        mTextViewTotal.text = String.format("R$ %.2f", valorTotal)
    }
}