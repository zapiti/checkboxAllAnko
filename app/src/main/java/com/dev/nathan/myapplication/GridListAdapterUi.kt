package com.dev.nathan.myapplication

import org.jetbrains.anko.*

class GridListAdapterUi: AnkoComponent<GridListAdapter> {

    companion object {

        const val CHECKED = 6
        const val lable = 7
    }
    override fun createView(ui: AnkoContext<GridListAdapter>) = with(ui) {

        relativeLayout(){
            checkBox(){

                id= CHECKED
                text = "nunca vai da certo "
            }
            textView(  "seila"){
                id= lable

            }.lparams(matchParent){
                below(CHECKED)
            }
        }

    }

}