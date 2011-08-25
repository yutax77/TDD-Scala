package com.yutax77

abstract class Money(var amount: Int){
  def times(multiplier: Int): Money	
  def currency: String
  
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
	  return new Dollar(amount)
	def franc(amount: Int): Money =
	  return new Franc(amount)
}

class Dollar(amount: Int) extends Money(amount){
	override def times(multiplier: Int): Money = 
	  return new Dollar(amount * multiplier)
	override val currency = "USD"
	
}

class Franc(amount: Int) extends Money(amount){
	override def times(multiplier: Int): Money = 
	  return new Franc(amount * multiplier)
	override val currency = "CHF"
	
}