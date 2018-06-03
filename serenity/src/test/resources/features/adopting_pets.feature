@adopting-pets
Feature: Adopting pets from Puppy Adoption Agency 
	As a pet lover,
    I want to adopt one or more pet
    So that they can choose my furniture.
  
@Kiet_WIP
Scenario: Adopting one pet successfully 
	Given I am at Puppy Adoption Agency website "http://puppies.herokuapp.com" 
	When I adopt these pets: 
		| Brook   |
		| Twinkie |  
	And I pay for the adoption with: 
		| name     | address                                   | email         | payType |
		| John Doe | 123 Main Street, Somewhere, Virginia, USA | jdoe@mail.com | Check   |
	Then I should see a message "Thank you for adopting a puppy!" 
