package com.dev.nathan.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import br.com.sankhya.labs.travelexpense.model.Expense
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.toast
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private var adapter: GridListAdapter? = null
    private var expenses: ArrayList<Expense>? = null

    lateinit var ui:MainActivityUi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ui = MainActivityUi()
        ui.setContentView(this)
        ui.listView.setOnItemClickListener { x, y, pos, z ->

            toast(ui.listView.adapter.getItem(pos).toString())
        }
        ui.selectButton.onClick {

            // Verifique o texto atual do botão Selecionar
            if (ui.selectButton.text.toString() == "checked") {


                // Se o texto for selecionar tudo, faça um loop para todos os itens da lista de arrays e marque todos eles
                for (i in expenses!!.indices)
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



        val expense = Expense()
        val random = Random()
        expenses = ArrayList<Expense>()
        fun rand(from: Int, to: Int) : Int {
            return random.nextInt(to - from) + from
        }
        for (i in 1..50) {
            fun generateRandomDesc(): String {
                val chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                var passWord = ""
                for (j in 0..170) {
                    passWord += chars[Math.floor(Math.random() * chars.length).toInt()]
                }
                return passWord
            }

            val array : ArrayList<Pair<Long, String>> = ArrayList()
            array.add(Pair(1,"Labs"))
            expense.statusExpense = if(rand(1,2) == 1)("aprovado")else("recusado")
            expense.codExpense = (random.nextInt(10000 - 7000) + 7000).toLong()
            expense.cost =  ( random.nextInt(3600 - 800) + 800).toDouble()
            expense.descExpense = generateRandomDesc()
            expense.descExpense
            expense.reasonNotation = "Atendimento a cliente"
            expense.descrCr = "labs"
            expense.crResponsible = array
            expense.advanceValue = ( random.nextInt(3600 - 800) + 800).toDouble()
            expense.advance = "N"

            expenses?.add(expense)
        }
        adapter = GridListAdapter(this@MainActivity, expenses!!,sumAllcost)
        ui.listView.adapter = adapter


        ui.rowsChecked.onClick {

            sumAllcost()

        }

        ui.deleteRows.setOnClickListener {
            val selectedRows =  (ui.listView.adapter as GridListAdapter).selectedIds
        // Verifique se o item está selecionado ou não via tamanho

        // Verifique se o item está selecionado ou não via tamanho
            if (selectedRows!!.size() > 0) {
                // Faz loop para  o array de linhas selecionadas
                for (i in selectedRows.size() - 1 downTo 0) {

                    //Check if selected rows have value i.e. checked item
                    if (selectedRows!!.valueAt(i)) {


        // todo remove o item marcado
                       // expenses!!.remove(selectedRows.indexOfKey(i))
                    }
                }


        // notifica o adaptador e remove toda a seleção marcada
                adapter!!.removeSelection()
            }
        }



    }

    val  sumAllcost= {
        val selectedRows =  adapter?.selectedIds
        val stringBuilder = ArrayList<Double>()
        // Obtém os IDs selecionados do adaptador
        var x: Double = 0.0
        // Verifique se o item está selecionado ou não via tamanho
        doAsync {
        if (selectedRows!!.size() > 0) {

            // Faz loop para o array de linhas selecionadas
            for (i in 0 until selectedRows.size()) {
                // Verifique se as linhas selecionadas têm valor, ou seja, item marcado
                if (selectedRows.valueAt(i)) {
                    // Obtém o texto do item marcado na lista de arrays, obtendo o método keyAt de selectedRowsarray
                    val selectedRowLabel = expenses!!.get(selectedRows.keyAt(i)).cost
                    stringBuilder.add(selectedRowLabel!!)
                }


            }
        }
            runOnUiThread {
                stringBuilder.map { c -> x += c }
                toast("Selected Rows\n" + x)
            }
        }
    }


}
