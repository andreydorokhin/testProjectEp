@all
Feature: User check detected word on the title of first site from result searching by given word

    Scenario: As user I want to verify title contains word

    Given User opened search page
    When User inserts detected word
    Then results of request appear on the page

        And User clicks first item

        Given defined site is opened
        When User research allocated title of the page
        Then the title must contain detected word