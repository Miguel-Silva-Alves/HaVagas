package com.example.cadastro

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.cadastro.databinding.ActivityMainBinding
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    private lateinit var act: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        act = ActivityMainBinding.inflate(layoutInflater)
        setContentView(act.root)

        act.formacaoSp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                act.anoFormacaoEt.visibility = View.VISIBLE
                if (position == 0 || position == 1) {
                    act.instituicaoEt.visibility = View.GONE
                    act.tituloMonografiaEt.visibility = View.GONE
                    act.orientadorEt.visibility = View.GONE
                } else if (position == 2 || position == 3) {
                    act.instituicaoEt.visibility = View.VISIBLE
                    act.tituloMonografiaEt.visibility = View.GONE
                    act.orientadorEt.visibility = View.GONE
                } else if (position == 3 || position == 4) {
                    act.instituicaoEt.visibility = View.VISIBLE
                    act.tituloMonografiaEt.visibility = View.VISIBLE
                    act.orientadorEt.visibility = View.VISIBLE
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                //NAO SE APLICA
            }
        }

        // Telefone Celular
        act.telefoneCelularBt.setOnClickListener {
            act.telefoneCelularEt.visibility = View.VISIBLE
        }

        act.btnSalvar.setOnClickListener {
            val sexo: String?
            if(act.masculinoRb.isChecked){
                sexo="Masculino"
            }else{
                sexo="Feminino"
            }
            val data = "${act.dataNascimentoDp.dayOfMonth}/${act.dataNascimentoDp.month}/${act.dataNascimentoDp.year}"

            val telefoneTipo: String?
            if(act.comercialRb.isChecked){
                telefoneTipo="Comercial"
            }else{
                telefoneTipo="Residencial"
            }

            if (act.nomeCompletoEt.text.isEmpty() || act.telefoneEt.text.isEmpty() || act.emailEt.text.isEmpty() || act.vagasInteresseEt.text.isEmpty() ){
                Toast.makeText(this@MainActivity, "Campos com * não preenchidos!", Toast.LENGTH_LONG).show()
            }else {


                val f = Formulario(
                    act.nomeCompletoEt.text.toString(),
                    act.emailEt.text.toString(),
                    act.telefoneEt.text.toString(),
                    sexo,
                    act.vagasInteresseEt.text.toString(),
                    act.simRb.isChecked,
                    act.telefoneCelularEt.text.toString(),
                    act.formacaoSp.selectedItem.toString(),
                    telefoneTipo,
                    data,
                    act.anoFormacaoEt.text.toString(),
                    act.instituicaoEt.text.toString(),
                    act.tituloMonografiaEt.text.toString(),
                    act.orientadorEt.text.toString()
                )
                Toast.makeText(this@MainActivity, f.toString(), Toast.LENGTH_LONG).show()
                Log.d("MIGUEL", f.toString())
            }
        }

        act.btnLimpar.setOnClickListener{
            act.nomeCompletoEt.text.clear()
            act.emailEt.text.clear()
            act.telefoneEt.text.clear()
            act.telefoneCelularEt.text.clear()
            act.telefoneCelularEt.visibility= View.GONE
            act.vagasInteresseEt.text.clear()
            act.receberEmailsRg.clearCheck()
            act.telefoneTipoRg.clearCheck()
            act.sexoRg.clearCheck()
            act.dataNascimentoDp.updateDate(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH)
            act.formacaoSp.setSelection(0)
            act.anoFormacaoEt.text.clear()
            act.instituicaoEt.text.clear()
            act.tituloMonografiaEt.text.clear()
            act.orientadorEt.text.clear()
            act.anoFormacaoEt.visibility = View.GONE
            act.instituicaoEt.visibility = View.GONE
            act.tituloMonografiaEt.visibility = View.GONE
            act.orientadorEt.visibility = View.GONE
        }
    }
}