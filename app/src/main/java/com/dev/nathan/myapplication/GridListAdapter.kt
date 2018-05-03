package com.dev.nathan.myapplication

import android.content.Context
import android.util.SparseBooleanArray
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.TextView
import org.jetbrains.anko.AnkoContext
import java.util.*


class GridListAdapter( context: Context, private val arrayList: ArrayList<String>) : BaseAdapter() {

    private val context = AnkoContext.createReusable(context, this)

    //    Retornar os id da checkbox  selecionada

    var selectedIds: SparseBooleanArray? = null
        private set

    init {
        selectedIds = SparseBooleanArray()
    }

    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getItem(i: Int): Any {
        return arrayList[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getView(i: Int, view: View?, viewGroup: ViewGroup): View {

        var viewHolder = ViewHolder()

        val view = view ?: GridListAdapterUi().createView(context)

        viewHolder.label = view.findViewById<View>(GridListAdapterUi.lable) as TextView
        viewHolder.checkBox = view.findViewById(GridListAdapterUi.CHECKED) as CheckBox

        view.tag = viewHolder

        viewHolder = view.tag as ViewHolder

        viewHolder.label!!.text = arrayList[i]
        viewHolder.checkBox!!.isChecked = selectedIds!!.get(i)

        viewHolder.checkBox!!.setOnClickListener { checkCheckBox(i, !selectedIds!!.get(i)) }

        viewHolder.label!!.setOnClickListener { checkCheckBox(i, !selectedIds!!.get(i)) }

        return view
    }

    private inner class ViewHolder {
        var label: TextView? = null
        var checkBox: CheckBox? = null
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
