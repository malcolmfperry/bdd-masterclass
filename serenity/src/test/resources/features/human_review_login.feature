@human-review-login
Feature: HR Authentication
	As an HR user,
	I want to login using id and password
	So that I can perform my work.

@Login_Test
Scenario: Successful login
	Given I am at the HR website
	When I login using user "admin" and password "12qwaszx@#WESDXC"
	Then I should be landed on the main page with welcome message "Welcome admin"