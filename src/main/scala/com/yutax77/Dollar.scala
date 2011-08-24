package com.yutax77

class Dollar(var amount: Int) {
	def times(multiplier: Int): Dollar = {
	  amount *= multiplier
	  return null
	}
}