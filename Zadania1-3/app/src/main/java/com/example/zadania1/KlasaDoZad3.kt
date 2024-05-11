package com.example.zadania1
class KlasaDoZad3(var accountHolder: String, var balance:Double) {
    private val transactionHistory = mutableListOf<String>();
    fun deposit(amount:Double){

    }
    fun withdraw(amount: Double){
        if(amount <= balance) {

        }else{

        }
    }
    fun acctBalance(){
        println("$accountHolder's balance is $balance")
    }
    fun displayTransactionHistory(){
        println("Transaction history for $accountHolder")

    }

}