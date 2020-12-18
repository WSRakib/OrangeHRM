Feature: This is a practice file for Cucumber
							Cucumber Practice
							
Scenario: We are multipling given numbers
		Given I assign first value
		And 	I assign second value 
		When 	I multiply 
		Then 	I see the total
		
Scenario: We are doing a second attempts 
		Given I assign first value
		And 	I assign second value 
		When 	I multiply 
		Then 	I see the total		
		
Scenario Outline: We are multipling multiple numbers
  			Given I assign first <value>
    When I assign second <value2>
    Then I recive total
    
    
Examples: 
      | value | value2| 
      | 10 		|   	 5|
      | 15 		|    	 6| 
      | 20		|    	 2| 
      | 30		|    	 3| 
  
    
    
    