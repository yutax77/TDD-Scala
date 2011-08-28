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
	  val sum = Money.dollar(5).plus(Money.dollar(5))
	  expect(Money.dollar(10)) {sum}
	}
}