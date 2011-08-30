package com.yutax77
import org.scalatest.testng.TestNGSuite
import org.testng.annotations.Test

class MoneyTest extends TestNGSuite {
	@Test
	def testMultiplication() {
	  val five = Money.dollar(5)
	  expect(Money.dollar(10)) {five.times(2)}
	  expect(Money.dollar(15)) {five.times(3)}
	}
	
	@Test
	def testEquality() {
	  expect(true) {(Money.dollar(5) == Money.dollar(5))}
	  expect(false) {Money.dollar(5) == Money.dollar(6)}
	  expect(false) {Money.franc(5) == Money.dollar(5)}
	}
	
	@Test
	def testCurrency() {
	  expect("USD") {Money.dollar(1).currency}
	  expect("CHF") {Money.franc(1).currency}
	}
	
	@Test
	def testSimpleAddition() {
	  val five = Money.dollar(5)
	  val sum = five.plus(five)
	  val bank = new Bank()
	  val reduced = bank.reduce(sum, "USD")
	  expect(Money.dollar(10)) {reduced}
	}
	
	@Test
	def testPlusReturnsSum() {
	  val five = Money.dollar(5)
	  val result = five.plus(five)
	  val sum = result.asInstanceOf[Sum]
	  expect(true) {five == sum.augend}
	  expect(true) {five == sum.addend}
	}
	
	@Test
	def testReduceSum() {
	  val sum = new Sum(Money.dollar(3), Money.dollar(4))
	  val bank = new Bank()
	  val result = bank.reduce(sum, "USD")
	  assert(Money.dollar(7) === result)
	}
	
	@Test
	def testReduceMoney() {
	  val bank = new Bank()
	  val result = bank.reduce(Money.dollar(1), "USD")
	  assert(Money.dollar(1) === result)
	}
	
	@Test
	def testReduceMoneyDifferentCurrency() {
	  val bank = new Bank()
	  bank.addRate("CHF", "USD", 2)
	  val result = bank.reduce(Money.franc(2), "USD")
	  assert(Money.dollar(1) === result)
	}
	
	@Test
	def testArrayEquals() {
	  assert(Array("abc") === Array("abc"))
	}
	
	@Test
	def testIdentityRate() {
	  expect(1) {new Bank().rate("USD", "USD")}
	}
	
	@Test
	def testMixedAddition() {
	  val fiveBucks = Money.dollar(5)
	  val tenFrancs = Money.franc(10);
	  val bank = new Bank()
	  bank.addRate("CHF", "USD", 2)
	  val result = bank.reduce(fiveBucks.plus(tenFrancs), "USD")
	  assert(Money.dollar(10) === result)
	}
}