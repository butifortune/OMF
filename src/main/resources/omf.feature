@regression
Feature: test

  Scenario: Test case 1
#    Given I am on dashboard
#    And I want to test
  #  And I want to calculate loan repayment
    Given I navigate to Old Mutual Finance Web site and verify that the title
    And Navigate to PERSONAL LOANS page and verify that you are on the correct page
    And  Navigate to CALCULATE, select R50 000 from the dropdown then click next.
    And click and dropdown Select 60 MONTHS from the “How long do you need to repay it?”
    And click calculate button
    Then Validate the amounts under the RESULT SUMMARY section.
