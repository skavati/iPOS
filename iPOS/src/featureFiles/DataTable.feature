Feature: Login Action
 
Scenario Outline: Successful Login with Valid Credentials
	Given User is on Login Page
	Given User enters user name <username>
	And User enters password <password>
	When User clicks on login button
	Then User <full name> displayed successfully
	
	Examples:
	|username|password|full name   |	
	|ss      |ss1     |Admin System|
	|rh      |rh1     |Rose Hill   |
	|rl      |rl1     |Ronald Low  |