@adopt-pets 
Feature: Adopt pets from Puppy Adoption Agency 
	As a pet lover,
    I want to adopt one or more pet
    So that I can have some companion when I am home alone
  
Scenario: Adopt pets successfully
	Given I am at a Pet Adoption Agency to adopt some pets
	When I adopt these pets: 
		| Brook   |
		| Twinkie |  
	And I pay for the adoption with: 
		| name     | address                                   | email         | payType |
		| John Doe | 123 Main Street, Somewhere, Virginia, USA | jdoe@mail.com | Check   |
	Then I should be thanked with a message "Thank you for adopting a puppy!" 
