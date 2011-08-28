package com.yutax77

class Money(var amount: Int, val currency: String){
  def times(multiplier: Int): Money	= {
    return null
  }
  
  override def equals(other: Any): Boolean =
		other match {
			case that: Money =>
			  (that.isInstanceOf[Money]) &&
			  that.amount == this.amount &&
			  that.currency == this.currency
			case _ => false
		}
  
  override def toString = amount + " " + currency
}

object Money {
	def dollar(amount: Int): Money = 
	  return new Dollar(amount, "USD")
	def franc(amount: Int): Money =
	  return new Franc(amount, "CHF")
}

class Dollar(amount: Int, currency: String) extends Money(amount, currency){
	override def times(multiplier: Int): Money = 
	  return new Dollar(amount * multiplier, currency)
}

class Franc(amount: Int, currency: String) extends Money(amount, currency){
	override def times(multiplier: Int): Money = 
	  return new Franc(amount * multiplier, currency)
}