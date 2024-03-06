package com.example.cadastro

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.cadastro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        var selectedItem: String? = null

        activityMainBinding.listaUf.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedItem = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Tratamento para nenhum item selecionado, se necessário
            }
        }


        activityMainBinding.btnSalvar.setOnClickListener {
            val sexo: String?
            if(activityMainBinding.rdSexoMasculino.isChecked){
                sexo="Masculino"
            }else{
                sexo="Feminino"
            }
            val f = Formulario(
                activityMainBinding.txtNomeCompleto.text.toString(),
                activityMainBinding.txtEmail.text.toString(),
                activityMainBinding.txtTelefone.text.toString(),
                activityMainBinding.txtCidade.text.toString(),
                selectedItem,
                sexo,
                activityMainBinding.ckIngressarListaEmail.isChecked,
            )
            Toast.makeText(this@MainActivity, f.toString(), Toast.LENGTH_LONG).show()
            Log.d("MIGUEL", f.toString())
        }

        activityMainBinding.btnLimpar.setOnClickListener{
            activityMainBinding.txtNomeCompleto.text.clear()
            activityMainBinding.txtEmail.text.clear()
            activityMainBinding.txtTelefone.text.clear()
            activityMainBinding.txtCidade.text.clear()
            activityMainBinding.ckIngressarListaEmail.isChecked = false
            activityMainBinding.rdSexoMasculino.isChecked = false
            activityMainBinding.rdSexoFeminino.isChecked = false
            activityMainBinding.listaUf.setSelection(0)
        }
    }
}