Feature: Testing Packaging Process on SosTest Website

Scenario: Part Weight Entry
	Given I login sostestKoton website with correct supplier user 
    | efeg | test1234 |
	When I click OrderManagement module in the OrderManagement menu
	# And I navigate OrderManagement page
	# And I select a job order 
	# And I click Start Packaging button
	# And I click Part Weight Entry button
	# And I navigate Order Weight Info page
	# And I enter weight unit type gram 
	# And I click submit button 
	Then The part weight should successfully be submitted via the order weight info form