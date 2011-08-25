package com.yutax77
import org.scalatest.testng.TestNGSuite
import org.testng.annotations.Test

class MoneyTest extends TestNGSuite {
	@Test
	def testMultiplication() {
	  val five = new Dollar(5)
	  val ten = five.times(2)
	  expect(10) {ten.amount}
	  val fifteen = five.times(3)
	  expect(15) {fifteen.amount}
	}
	
	@Test
	def testEquality() {
	  expect(true) {((new Dollar(5)) == (new Dollar(5)))}
	  expect(false) {new Dollar(5) == new Dollar(6)}
	}
}