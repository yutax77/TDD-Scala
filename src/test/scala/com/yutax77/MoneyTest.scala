package com.yutax77
import org.scalatest.testng.TestNGSuite
import org.testng.annotations.Test

class MoneyTest extends TestNGSuite {
	@Test
	def testMultiplication() {
	  val five = new Dollar(5)
	  five.times(2)
	  expect(10) {five.amount}
	}
}