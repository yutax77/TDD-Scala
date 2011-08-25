package com.yutax77

class Money(var amount: Int){
  	override def equals(other: Any): Boolean =
		other match {
			case that: Money =>
			  (that.isInstanceOf[Money]) &&
			  that.amount == this.amount
			case _ => false
		}
}

class Dollar(amount: Int) extends Money(amount){
	def times(multiplier: Int): Dollar = {
	  return new Dollar(amount * multiplier)
	}
}

class Franc(amount: Int) extends Money(amount){
	def times(multiplier: Int): Franc = {
	  return new Franc(amount * multiplier)
	}
}