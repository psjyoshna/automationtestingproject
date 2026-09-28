Feature:Home page Click functionality

@passed
Scenario: Verify user can navigate to the products page
Given navigate to home page
When homepage shows product option
And User click on products
Then products page display



@passed
Scenario Outline:Search for a product successfully
Given user is on the products page
When user enter product name"<product>"
And user click search button
Then user sees search results
Examples:
  | product |
  | tops    |
  | dress   |
  | pen     |
  | phone   |

@wip
Scenario: Add to cart successfully
Given navigate to product page
When user see the product
And click on add to cart
Then product display in the cart successfully
  


