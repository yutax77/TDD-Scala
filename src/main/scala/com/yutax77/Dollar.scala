package com.yutax77

class Money(var amount: Int, val currency: String) extends Expression{
  def times(multiplier: Int): Money	= {
    new Money(amount * multiplier, currency)
  }
  
  def plus(addend: Money): Expression = {
	new Sum(this, addend)
  }
  
  override def reduce(to: String): Money = {
	this
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

trait Expression {
  def reduce(to: String): Money
}

class Bank {
  def reduce(source: Expression, to: String): Money = {
    source.reduce(to)
  }
}

class Sum(val augend: Money, val addend: Money) extends Expression {
  override def reduce(to: String): Money = {
    val amount = augend.amount + addend.amount
    new Money(amount, to)
  }
}