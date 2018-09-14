Feature: Deposit into an active account 

Scenario: Deposit cash 
	Given I have $5 in my checking account
	#	I set up an account with a balance is $5
	#	I insert my ATM card
	#	I enter my pin 
	When I deposit $10
	# 	I select deposit cash option
	#	I insert my $10 cash into the deposit slot
	#	I confirm the deposit amount
	
	Then I should have $15 in my balance.
	# 	I check my balance
	# 	The balance of my account should be $15