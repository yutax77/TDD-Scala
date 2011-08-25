package com.yutax77
import org.scalatest.testng.TestNGSuite
import org.testng.annotations.Test

class MoneyTest extends TestNGSuite {
	@Test
	def testMultiplication() {
	  val five = new Dollar(5)
	  expect(new Dollar(10)) {five.times(2)}
	  expect(new Dollar(15)) {five.times(3)}
	}
	
	@Test
	def testEquality() {
	  expect(true) {((new Dollar(5)) == (new Dollar(5)))}
	  expect(false) {new Dollar(5) == new Dollar(6)}
	}
	
	@Test
	def testFrancMultiplication() {
	  val five = new Franc(5)
	  expect(new Franc(10)) {five.times(2)}
	  expect(new Franc(15)) {five.times(3)}
	}
}