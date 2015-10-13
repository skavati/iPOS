Feature: Login
 
Scenario: Successful Login with Valid Credentials
	Given user name "ss"
	And password "ss1"
	When Click on Login button
	Then User name "Admin System" displayed as expected
	
Scenario: Successful Login with Valid Credentials
	Given Enter user name "RH"
	And Enter password "rh1"
	When Click on Login button
	Then User name "Rose Hill"displayed as expected
	
Scenario: Successful Login with Valid Credentials
	Given Enter user name "rl"
	And Enter password "rl1"
	When Click on Login button
	Then User name "Ronald Low" displayed as expected		
	
Scenario:  LogOut 
	When User LogOut from iPOS
	Then Message displayed LogOut Successfully
