package com.dev.nathan.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.toast
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private var adapter: GridListAdapter? = null
    private var arrayList: ArrayList<String>? = null

    lateinit var ui:MainActivityUi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ui = MainActivityUi()
        ui.setContentView(this)

        ui.selectButton.onClick {

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


        ui.rowsChecked. onClick {
            val selectedRows = adapter!!.selectedIds
            // Obtém os IDs selecionados do adaptador

            // Verifique se o item está selecionado ou não via tamanho
            if (selectedRows!!.size() > 0) {
                val stringBuilder = StringBuilder()

            // Faz loop para o array de linhas selecionadas
                for (i in 0 until selectedRows.size()) {


            // Verifique se as linhas selecionadas têm valor, ou seja, item marcado
                    if (selectedRows.valueAt(i)) {


            // Obtém o texto do item marcado na lista de arrays, obtendo o método keyAt de selectedRowsarray
                        val selectedRowLabel = arrayList!!.get(selectedRows.keyAt(i))


            // anexe o texto da etiqueta de linha
                        stringBuilder.append(selectedRowLabel + "\n")
                    }
                }
                toast("Selected Rows\n"+stringBuilder.toString())
            }

        }

        ui.deleteRows.setOnClickListener {
            val selectedRows = adapter!!.selectedIds
        // Verifique se o item está selecionado ou não via tamanho

        // Verifique se o item está selecionado ou não via tamanho
            if (selectedRows!!.size() > 0) {
                // Faz loop para  o array de linhas selecionadas
                for (i in selectedRows.size() - 1 downTo 0) {

                    //Check if selected rows have value i.e. checked item
                    if (selectedRows!!.valueAt(i)) {


        // todo remove o item marcado
                       // arrayList!!.remove(selectedRows.indexOfKey(i))
                    }
                }


        // notifica o adaptador e remove toda a seleção marcada
                adapter!!.removeSelection()
            }
        }



    }

}
