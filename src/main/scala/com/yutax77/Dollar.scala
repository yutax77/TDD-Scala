package com.yutax77

class Dollar(var amount: Int) {
	def times(multiplier: Int): Dollar = {
	  return new Dollar(amount * multiplier)
	}
	
	override def equals(other: Any): Boolean =
		other match {
			case that: Dollar =>
			  (that.isInstanceOf[Dollar]) &&
			  that.amount == this.amount
			case _ => false
		}
}