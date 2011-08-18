package com.bkern

import spock.lang.*

/*
 * @Author Barry Kern
 */

class User {
	def LoginService loginService
	
	def processLogin(String username, String password){
			try {
				loginService.login(username, password)
			} catch (Exception e) {}			
	}
}

interface LoginService {
	def login(String username, String password)
	public boolean isAuthenticated(String username)

	
}
class MocksAndStubsTest extends Specification {
	
	def "stub login service example" () {
		
		given:
		def  loginService = Mock(LoginService)
		loginService.login("spockUser","password")
		
		when:
		loginService.isAuthenticated("spockUser") >> true
		
		then:
		loginService.isAuthenticated("spockUser") == true
		
	}
	
	def " mock login service example one" () {
		given:
		User u = new User()
		def  loginService = Mock(LoginService)
		u.loginService = loginService
	
		when:
		loginService.processLogin("spockUser" , "secretpassword") >> true
		u.processLogin("spockUser", "secretpassword")
		
		then:
		1 * loginService.login("spockUser", "secretpassword")
	}
	
	def " mock login service example with wildcard arguments which validates method called disregarding actual parameters values" () {
		given:
		User u = new User()
		def  loginService = Mock(LoginService)
		u.loginService = loginService
	
		when:
		loginService.processLogin("spockUser" , "secretpassword") >> true
		u.processLogin("spockUser", "secretpassword")
		
		then:
		1 * loginService.login(_, _)
	}
	
}