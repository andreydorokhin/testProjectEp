@all
Feature: User check detected word on the title of first site from result searching by given word

    Scenario: As user I want to verify title contains detected word

        Given User opened search page
        When User inserts detected word and chooses first item from searching results
        Then the title of the opend page must contain detected word


    Scenario: As user I want to see detected link on one of the top five pages of search results

        Given User opened search page
        When User inserts detected word and clicks search buttom
        Then detected link must be on one of the top five pages of search results
