@adopt-pets 
Feature: Adopt a pet from Puppy Adoption Agency 
	As a pet lover,
    I want to adopt a puppy
    So that they can chew my furniture.

@Kiet_WIP
Scenario: Adopt one pet 
	Given the adoption agency has a pet named "Topsy" 
	When I adopt the pet "Topsy"
	And I pay for the adoption using "Check" with PII as "John Doe", "123 Main Street, Some Town, AL 12345", "jdoe@email.com" 
	Then I should receive this note "Thank you for adopting a puppy!" 
