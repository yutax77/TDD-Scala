package com.yutax77

class Money(var amount: Int, val currency: String) extends Expression{
  def times(multiplier: Int): Money	= {
    new Money(amount * multiplier, currency)
  }
  
  def plus(addend: Money): Expression = {
	new Sum(this, addend)
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
	  return new Money(amount, "USD")
	def franc(amount: Int): Money =
	  return new Money(amount, "CHF")
}

trait Expression

class Bank {
  def reduce(source: Expression, to: String): Money = {
    val sum = source.asInstanceOf[Sum]
    val amount = sum.augend.amount + sum.addend.amount
    new Money(amount, to)
  }
}

class Sum(val augend: Money, val addend: Money) extends Expression