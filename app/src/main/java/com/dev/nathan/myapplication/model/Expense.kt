package br.com.sankhya.labs.travelexpense.model

import java.io.Serializable
import java.util.*


class Expense :Serializable{

    var typeExpense : String? = null         //tipo enviado (historico)
    var cost : Double? = null        //custo enviado (historico)
    var dtInit : Date? = null            //data inicio da viagem (historico)
    var dtEnd : Date? = null          //data final da viagem (historico)
    var dtForecast :Date? = null    //previsao de reembolso (historico)

    var codExpense : Long? = null            //codigo do apontamento (notation)
    var descExpense : String? = null        //descriçao do apontamento ou observaçao (notation)
    var statusExpense : String? = null     //status do apontamento (notation)
    var reasonNotation : String? = null   //motivo do apontamento (notation)
    var crResponsible : ArrayList<Pair<Long, String>>? = null //cr responsavel(notation)
    var advanceValue : Double? = null      //Adiantamento (notation)
    var advance :String?  = null      //possui ou nao possui (add new notation)
    var descrCr:String? = null  //cr descricao(notation)
    var codCr:Long? = null    //cr codigo(notation)






}
