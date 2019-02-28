@all
Feature: User check detected word on the title of first site from result searching by given word

    Scenario: As user I want to verify title contains word

    Given User opened search page
    When User inserts detected word
    Then results of request appear on the page
        Then defined site is opened after clicking first item
        Then the title of the page must contain detected word