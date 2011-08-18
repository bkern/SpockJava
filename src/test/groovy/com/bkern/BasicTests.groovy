package com.bkern

import spock.lang.*

/*
 * @author Barry Kern
 */
class BasicTests extends Specification {
	
	def basicStringTest() {
		given:
			def myString = "Hello World!"
		expect:
			myString.length() == 12 
	}
	def basicStringTest2() {
		given:
			def myString = "Hello World!"
		expect:
		 "!dlroW olleH" == myString.reverse()
			
	}
	def basicStringTest3() {
		given:
			def myString = "Spock"
		expect:
			"S" == myString.getAt(0)
	}

	def basicStringTest3JavaWay() {
		given:
			def myString = "Spock"
		expect:
			"S" == myString.charAt(0)
	}	
	
	def basicStringTestLessGroovyMoreJava(){
		given:
			String myString = "Java";
		when:
			myString = myString.concat("AndSpock");
		then:
			"JavaAndSpock" == myString
	}
	def basicStringTestMoreGroovyLessJava(){
		given:
			def myString = "Groovy"
		when:
			def result = myString + "AndSpock"
		then:
			"GroovyAndSpock" == result
	}
	def basicListTest(){
		given:
			def list = ['apples','oranges','pears']
		expect:
			3 == list.size()
		
		}
	def anotherListTest(){
		given:
			def list = ['apples','oranges','pears']
		expect:
			list.contains('apples')
		}
	def groovyListRemoval(){
		given:
			def list = ['apples','oranges','pears']
		when:
			list -= 'apples'
		then:
			list.size() == 2
		 
		and:
			list.contains('apples') == false
		}
	def javaListRemoval(){
		given:
			ArrayList<String> list  = new ArrayList<String> ();
			list.add("apples");
			list.add("oranges");
			list.add("pears");
		when:
			list.remove("apples");
		then:
			list.size() == 2
		and:
			list.contains("apples") == false
		
		}
	}
	
