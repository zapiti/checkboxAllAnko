package com.dev.nathan.myapplication


import android.content.res.ColorStateList
import android.graphics.Color
import android.support.design.widget.NavigationView
import android.support.design.widget.TabLayout
import android.support.v4.content.ContextCompat

import android.support.v4.view.ViewPager
import android.support.v4.widget.DrawerLayout
import android.support.v7.widget.CardView
import android.view.Gravity
import android.view.View

import android.widget.*


import org.jetbrains.anko.*
import org.jetbrains.anko.design.navigationView
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.support.v4.drawerLayout

class MainActivityUi:AnkoComponent<MainActivity>{



    lateinit var navigationFilter: NavigationView



    lateinit var applyFilterContainer : RelativeLayout
    lateinit var applyFilterButton : Button


    private lateinit var moreImageView: ImageView

    private lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager

    lateinit var filterImageView: ImageView

    lateinit var drawerLayout: DrawerLayout
    lateinit var listView: ListView
    lateinit var  selectButton :Button
    lateinit var deleteRows : Button
    lateinit var rowsChecked : Button


    override fun createView(ui: AnkoContext<MainActivity>)= with(ui) {

        relativeLayout(){

            selectButton=   button("checked"){
                id= View.generateViewId()

            }.lparams(matchParent){
                alignParentTop()
            }
            deleteRows=   button("delete"){
                id= View.generateViewId()

            }.lparams(matchParent){

                below(selectButton)
            }
           rowsChecked=   button("Pegas as checadas"){
                id= View.generateViewId()

            }.lparams(matchParent){

               below(deleteRows)
            }
            listView = listView{
                val footer = Space(context)
                footer.layoutParams = AbsListView.LayoutParams(matchParent, dip(80))
                addFooterView(footer)
                dividerHeight = dip(0)
                setFooterDividersEnabled(false)
            }.lparams(matchParent){
                below( rowsChecked)
            }




        }


            }
            //endregion
        }


