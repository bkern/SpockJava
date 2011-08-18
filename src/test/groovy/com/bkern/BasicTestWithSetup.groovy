package com.bkern;

import spock.lang.*

/*
 * @author Barry Kern
 */
class BasicTestWithSetup extends Specification {

	
	/*
	 * Spock provides some methods similar to JUnit @Before and @After
	 * See setup/cleanup and setupSpeck and cleanupSpecs
	 */
	def bigList
	
	def setup() {
		bigList = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15]
	}
	
	def nowTestBigList(){
		expect:
			bigList.size()  == 15
	}
	def anotherBigListTest(){
		when:
			bigList -= 9
		then:
			[1,2,3,4,5,6,7,8,10,11,12,13,14,15] == bigList
		
		and:
			bigList.size() == 14
	}
	
		
}