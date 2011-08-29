package com.yutax77

class Money(var amount: Int, val currency: String) extends Expression{
  def times(multiplier: Int): Money	= {
    new Money(amount * multiplier, currency)
  }
  
  def plus(added: Money): Expression = {
	new Money(amount + added.amount, currency)
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
    return Money.dollar(10)
  }
}

class Sum(val augend: Money, val addend: Money)