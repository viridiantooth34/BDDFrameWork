
@tag
Feature: Purchase the order from Ecommerce Website


	Background:
	Given I landed on Eccommerce Page

  @tag2
  Scenario Outline: Positive Test of Submitting the order
  
    Given Logged in with username <name> and password <pasword>
    When I add product <productName> to Cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmtionPage

    Examples: 
      | name  								| pasword 				| productName  |
      | rick.bakshi@gmail.com |     Fortminor1! | ZARA COAT 3  |
      
