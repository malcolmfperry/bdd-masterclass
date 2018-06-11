# Introduction
This project consists of Java test code using the Selenium Web Driver framework
to develop 'acceptance' or 'customer' tests.

The automated tests are written by a programmer for testing a desired behavior
of an application. The `scenario` might have come from a conversation between
a product owner (business analyst, etc.) and a tester (most likely a 
non-programmer). A scenario might have been something like this:

```
Given I am at the Puppy Adoption Agency
When I adopt a pet named Topsy
And I pay for it using a check by the name of John Doe who resides at 123 Main Street, New York, NY 12345 and can be contacted via jdoe@email.com
Then I should see this thank you message "Thank you for adopting a puppy!"
```
The programmer might have taken this Given-When-Then (another name, Gherkin) 
statements and translate it into a set of programming instructions like this:

```
given_I_am_at_the_Puppy_Adoption_Agency();
when_I_adopt_a_pet_named("Topsy");
and_I_pay_for_it_using(new PaymentInfo("Check", "John Doe", "123 Main Street, New York, NY 12345", "jdoe@email.com"));
then_I_should_see_this_thank_you_message("Thank you for adopting a puppy!");
```

The similarity, unfortunately, ends at the above statements. Subsequent activities
are mainly for individuals who can read and understand the Java language.

In order to know how well the tests run, the programmer mainly reads the output
log file and explain how things work.

Although, the tests are for the customers (i.e., acceptance), the 

# How to run
Consider running `run_tests.cmd` for Windows or `run_tests.sh` for 
Linux. I ran these scripts from Windows 10 & Ubuntu 16.04.

## JVM
The code in this repository requires Java 8.

# Styles for Selenium Page Objects
This project introduces two styles of dealing with web pages: 1) Page Object
Model (POM) and Page Factory (PF). Page Factory is a built-in framework 
by the Selenium framework.

# Selenium Web Driver with Page Object Model (POM)
This style is a simple programming practice where it requires basic knowledge
and skillset for Selenium driver. It is focusing on organizing web pages 
separate from the testing logic.

# Selenium Web Driver with Page Factory (PF)
By using Page Factory framework, you can leverage the `@FindBy` annotation; 
thus, it make programming the Selenium driver code a bit easier to read
and maintain.

