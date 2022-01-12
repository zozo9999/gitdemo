#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@project_01
Feature: test web application project
  
  @login
  Scenario: test sorting A to Z 
    Given a browser is given to a user
    And go to a website
    When enter user info
    And click login
    Then a user entered
 	@high
  Scenario: test sorting Z to A
    Given a user is on the browser.
    When clicks the sorting
    And click high to low
    Then the products become high price.
    #@Sorting_HL
  #Scenario: Price high to low
#		Given Sorting tab is seen.
    #And Showing the list when a user clicks the tab
    #When click "high to low" is clicked. 
   #Then the products become high price. 

  #Scenario: test sorting low to high
    #Given product pages are shown
    #When clicks product add to cart
    #Then I verify that every product can be added.

	#tags example
	# regression
	# prob
	# Then I verify that everyoone has <status>.
	#<status> means status in the example.
  #  Examples: 
   #   | name  | value | status  |
    #  | name1 |     5 | success |
     # | name2 |     7 | Fail    |
