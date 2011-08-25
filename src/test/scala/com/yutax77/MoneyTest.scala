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
	  expect(true) {Money.franc(5) == Money.franc(5)}
	  expect(false) {Money.franc(5) == Money.franc(6)}
	  expect(false) {Money.franc(5) == Money.dollar(5)}
	}
	
	@Test
	def testFrancMultiplication() {
	  val five = Money.franc(5)
	  expect(Money.franc(10)) {five.times(2)}
	  expect(Money.franc(15)) {five.times(3)}
	}
}