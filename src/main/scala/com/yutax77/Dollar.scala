package com.yutax77

abstract class Money(var amount: Int, val currency: String){
  def times(multiplier: Int): Money	
  
  override def equals(other: Any): Boolean =
		other match {
			case that: Money =>
			  (that.isInstanceOf[Money]) &&
			  that.amount == this.amount &&
			  that.getClass() == this.getClass()
			case _ => false
		}
}

object Money {
	def dollar(amount: Int): Money = 
	  return new Dollar(amount, "USD")
	def franc(amount: Int): Money =
	  return new Franc(amount, "CHF")
}

class Dollar(amount: Int, currency: String) extends Money(amount, currency){
	override def times(multiplier: Int): Money = 
	  return Money.dollar(amount * multiplier)
}

class Franc(amount: Int, currency: String) extends Money(amount, currency){
	override def times(multiplier: Int): Money = 
	  return Money.franc(amount * multiplier)
}