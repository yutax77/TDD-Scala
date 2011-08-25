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
	  expect(true) {((new Franc(5)) == (new Franc(5)))}
	  expect(false) {new Franc(5) == new Franc(6)}
	  expect(false) {new Franc(5) == Money.dollar(5)}
	}
	
	@Test
	def testFrancMultiplication() {
	  val five = new Franc(5)
	  expect(new Franc(10)) {five.times(2)}
	  expect(new Franc(15)) {five.times(3)}
	}
}