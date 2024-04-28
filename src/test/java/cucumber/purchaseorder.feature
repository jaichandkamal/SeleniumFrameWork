
@tag
Feature: purchase the order from e commerce site 
  I want to use this template for my feature file

  Background:
  
  Given I landed on e commerce page
  
  

  @tag2
  Scenario Outline: Positive test for submit order 
    Given Login with username <name> and passowrd <password>
    When I add the product <Productname> to cart
    And checkout <Productname> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on coformationpage

    Examples: 
      | name 					    | password  | Productname   |
      | kamal12@gmail.com | Kunal@121 | IPHONE 13 PRO |
      
