package com.dev.nathan.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.setContentView
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private var adapter: GridListAdapter? = null
    private var arrayList: ArrayList<String>? = null

    lateinit var ui:MainActivityUi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

ui = MainActivityUi()
        ui.setContentView(this)

        ui.selectButton.setOnClickListener {

            // Verifique o texto atual do botão Selecionar
            if (ui.selectButton.text.toString() == "checked") {


            // Se o texto for selecionar tudo, faça um loop para todos os itens da lista de arrays e marque todos eles
                for (i in arrayList!!.indices)
                    adapter?.checkCheckBox(i, true)


            // Depois de verificar todos os itens, altere o texto do botão
              ui. selectButton.text = "nao checked"
            } else {

            // Depois disso, desmarque todos os itens, altere o texto do botão
                adapter?.removeSelection()


// Depois de verificar todos os itens, altere o texto do botão
             ui.selectButton.text = "checked"
            }
        }

        arrayList = ArrayList()
        for (i in 1..50)
            arrayList?.add("ListView Items $i")

        adapter = GridListAdapter(this, arrayList!!)
       ui.listView.adapter = adapter
    }

}
