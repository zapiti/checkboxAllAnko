package com.dev.nathan.myapplication

import android.content.Context
import android.util.SparseBooleanArray
import android.view.View
import android.view.ViewGroup
import android.widget.*
import br.com.sankhya.labs.travelexpense.model.Expense
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find
import java.util.*
import java.util.concurrent.Future


class GridListAdapter(private val ctx: Context, private val arrayList: ArrayList<Expense>,val funcao : () ->Future<Unit>) : ArrayAdapter<Expense>(ctx, 0, arrayList) {

    private val context = AnkoContext.createReusable(ctx, this)
    private var main : MainActivity? = null


    //    Retornar os id da checkbox  selecionada

    var selectedIds: SparseBooleanArray? = null
        private set

    init {
        selectedIds = SparseBooleanArray()
    }

    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getItem(i: Int): Expense? {
        return arrayList[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        main = MainActivity()


       val view = convertView ?: GridListAdapterUi().createView(context)
       val iconImageView = view.find<ImageView>(GridListAdapterUi.ICON)
        val  typeTextView = view.find<TextView>(GridListAdapterUi.TYPE)
        val   dateTextView = view.find<TextView>(GridListAdapterUi.DATE)
        val   costTextView = view.find<TextView>(GridListAdapterUi.COST)
        val    containerLinearLayout = view.find<LinearLayout>(GridListAdapterUi.LAYOUT_VIEW)
        val checkBox  = view.find<CheckBox>(GridListAdapterUi.CHECKED)
        val expense = getItem(position)




        if(expense != null) {
           checkBox!!.text = arrayList.get(position).descExpense
          checkBox!!.isChecked = selectedIds!!.get(position)
            costTextView?.text = arrayList.get(position).typeExpense
            if (expense.cost != null){
               costTextView?.text= ("R$${expense.cost}")
            }


            checkBox!!.setOnClickListener {
                checkCheckBox(position, !selectedIds!!.get(position))


            }

            containerLinearLayout!!.setOnClickListener { checkCheckBox(position, !selectedIds!!.get(position)

            )
                funcao.invoke()
           //     (MainActivity)ctx.sumAllcost()

            }
        }
        return view
    }

    private inner class ViewHolder {
        var checkBox: CheckBox? = null
        var iconImageView : ImageView? =null
        var typeTextView :TextView? =null
        var dateTextView : TextView? =null
        var costTextView : TextView? = null
        var containerLinearLayout : LinearLayout ? =null
    }


// Remover todas as caixas de selecao

    fun removeSelection() {
        selectedIds = SparseBooleanArray()
        notifyDataSetChanged()
    }

    //Marque a checkbox se não estiver marcada
    fun checkCheckBox(position: Int, value: Boolean) {
        if (value)
            selectedIds!!.put(position, true)
        else
            selectedIds!!.delete(position)

        notifyDataSetChanged()
    }



}
