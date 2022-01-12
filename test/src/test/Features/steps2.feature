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
@sorting
Feature: Verify sorting
  @AZ
  Scenario: Test Sorting
    Given I am on the main home page
    When Click Login
    And click sorting A to Z
    Then Products become A to Z

  @ZA
  Scenario: Test Sorting
    Given I am on the main home page
    When Click Login
    And click sorting Z to A
    Then Products become Z to A

	@LH
	Scenario: Test Sorting
    Given I am on the main home page
    When Click Login
    And click sorting L to H
    Then Products become L to H

	@HL
	Scenario: Test Sorting
    Given I am on the main home page
    When Click Login
    And click sorting H to L
    Then Products become H to L
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
