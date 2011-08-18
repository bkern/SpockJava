package com.bkern

import spock.lang.*
/*
 * @Author Barry Kern
 */
class ParameterizedTestExamples extends Specification {
	
	def "a number multiplied by itself should equal square "(){
		expect:
			number * number == square
		
		where:
		number | square
		2	   | 4
		3	   | 9
		4	   | 16
		5	   | 25
		6      | 36
	}
	
	def "find minimum number" (){
		expect:
		  Math.min(a, b) == c
		  
		 where:
		 a | b | c 
		 3 | 9 | 3
		 4 | 5 | 4
		 8 | 12 | 8
		 19 | 35 | 19
		 100 | 4 | 4
		
	}
	def "show data tables don't need to be local can be sourced elsewhere" () {
		expect:
		originalword.reverse() == backwardsword
		
		where:
		[originalword, backwardsword] <<  new File("target/test-classes/externalCSV.csv").readLines()*.split(",")
	}
	
}