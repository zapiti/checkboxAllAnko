package com.dev.nathan.myapplication

import android.content.res.ColorStateList
import android.graphics.Typeface
import android.support.v4.content.ContextCompat
import org.jetbrains.anko.*

class GridListAdapterUi: AnkoComponent<GridListAdapter> {

    companion object {
        const val LAYOUT_VIEW = 1
        const val ICON = 2
        const val TYPE = 3
        const val DATE = 4
        const val COST = 5
        const val CHECKED = 6
    }

    override fun createView(ui: AnkoContext<GridListAdapter>) = with(ui) {
        relativeLayout {

            linearLayout() {
                id = LAYOUT_VIEW
                relativeLayout {
                    padding = dip(10)

                    checkBox(){
                        id = CHECKED
                      //  buttonTintList = ColorStateList.valueOf(ContextCompat.getColor(context, br.com.sankhya.labs.framework.R.color.colorPrimarySankhya))
                    }.lparams(dip(40), dip(40)) {
                        topMargin = dip(10)
                    }



                    imageView {
                        id = ICON
                    }.lparams(dip(40), dip(40)) {
                        topMargin = dip(10)
                        rightOf(CHECKED)
                    }

                    textView {
                        id = TYPE
                        setTypeface(typeface, Typeface.BOLD)
                        textSize =  16f
                    }.lparams {
                        rightOf(ICON)
                        topMargin = dip(10)
                        marginStart = dip(10)
                    }

                    textView {
                        id = DATE
                        textSize =  14f
                    }.lparams {
                        below(TYPE)
                        rightOf(ICON)
                        marginStart = dip(10)
                    }

                    textView {
                        id = COST
                        textSize =  16f
                        typeface = Typeface.DEFAULT_BOLD
                    }.lparams {
                        alignParentEnd()
                        centerVertically()


                    }

                }.lparams {
                    topMargin = dip(5)
                    marginEnd = dip(15)
                    marginStart = dip(10)
                    bottomMargin = dip(10)
                }
            }
        }
    }

}