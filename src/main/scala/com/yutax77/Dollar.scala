package com.yutax77

class Money(var amount: Int, val currency: String) extends Expression{
  override def times(multiplier: Int): Expression	= {
    new Money(amount * multiplier, currency)
  }
  
  override def plus(addend: Expression): Expression = {
	new Sum(this, addend)
  }
  
  override def reduce(bank: Bank, to: String): Money = {
	val rate = bank.rate(currency, to)
	new Money(amount / rate, to)
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
  def reduce(bank: Bank, to: String): Money
  def plus(addend: Expression): Expression
  def times(multiplier: Int): Expression
}

class Bank {
  import scala.collection.mutable.Map
  val rates = Map[Tuple2[String, String], Int]()
  def reduce(source: Expression, to: String): Money = {
    source.reduce(this, to)
  }
  def rate(from: String, to: String):Int = {
    if(from == to) return 1
    val rate = rates.get((from, to))
    rate.get
  }
  def addRate(from: String, to: String, rate: Int) {
    rates.put((from, to), rate)
  }
}

class Sum(val augend: Expression, val addend: Expression) extends Expression {
  override def reduce(bank: Bank, to: String): Money = {
    val amount = augend.reduce(bank, to).amount + addend.reduce(bank, to).amount
    new Money(amount, to)
  }
  
  override def plus(addend: Expression): Expression = {
    return new Sum(this, addend)
  }
  
  override def times(multiplier: Int): Expression = {
    new Sum(augend.times(multiplier), addend.times(multiplier))
  }
}