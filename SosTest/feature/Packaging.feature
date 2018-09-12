Feature: Testing Packaging Process on SosTest Website

Scenario: Part Weight Entry
	Given I login sostestKoton website with correct supplier user 
    | efeg | test1234 |
	When I click OrderManagement module in the OrderManagement menu
	  And I filter order to "363041" 
	  And I select the order
	  And I click Start Packaging button
	  And I enter Weight of Part
	  | 0 | 105 |
	  | 0 | 106 |
	  | 0 | 107 |
	  | 0 | 108 |
	  | 0 | 109 |
	  | 0 | 110 |
	  | 0 | 111 |
 	  And I click submit button 
	Then The part weight should successfully be submitted via the order weight info form
