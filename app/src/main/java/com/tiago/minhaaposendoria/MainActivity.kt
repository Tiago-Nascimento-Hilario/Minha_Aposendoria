package com.tiago.minhaaposendoria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Definindo o arui de  layout
        setContentView(R.layout.activity_main)

        // Acessando o spinner
        val sexo = findViewById<Spinner>(R.id.spn_sexo)

        // Acessando o campo idade
        val idade = findViewById<EditText>(R.id.txt_idade)

        // Acessando o botao
        val botao = findViewById<Button>(R.id.btn_calcular)

        // Acessando o o campo resultado
        val resultado = findViewById<TextView>(R.id.txt_reultado)

        sexo.adapter = ArrayAdapter<String>(
            this, android.R.layout.simple_spinner_dropdown_item, listOf("masculino", "femenino")
        )

        botao.setOnClickListener {
            val informacaoSexo = sexo.selectedItem as String
            val informacaoIdade = idade.text.toString().toInt()

            var informacaoResultado = 0

            if (informacaoSexo == "masculino") {
                // Efetua calculo para homem
                informacaoResultado = 65 - informacaoIdade
            } else {
                // Efetua calculo para mulheres
                informacaoResultado = 60 - informacaoIdade
            }

            resultado.text = "Faltam $informacaoResultado anos para você se aposentar!"
        }
    }

}