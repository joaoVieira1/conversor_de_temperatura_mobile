package br.edu.ifsp.dmo1.conversordetemperatura

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), OnClickListener{

    //lateinit: diz que vc assume a responsabilidade de inicializar tardiamente a variável
    private lateinit var editText: EditText
    private lateinit var button: Button
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //por conta do ciclo de vida, as variáveis com propriedades view só pode ser inicializadas após o oncreate

        //configurando o mapeamento dos atributos da classe com atributos View
        editText = findViewById(R.id.edittext_celsius)
        button = findViewById(R.id.button_clique)
        textView = findViewById(R.id.textview_result)

        //configurando o comportamento do botão
        button.setOnClickListener(this)

    }

    override fun onClick(view: View) { //Tudo que aparece na tela é da classe View
        if(view == button){
            execute()
        }
    }

    private fun execute(){
        val celsius = editText.text.toString().toDouble()
        val fahrenheit = conversor(celsius)
        textView.text = "$fahrenheit ºF"
    }

    private fun conversor(celsius: Double): Double{
        return (celsius * 9.0 / 5.0) + 32
    }

}