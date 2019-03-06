
Feature: Search Specific Text
    Description: This function will check the action that the particular text is looking for

    Background: User got searching result
        Given User navigates to the google page
        When User submit searching word
        Then Result page should be shown

    Scenario: Navigate first link and find specific text in the title
        Given User is on result page
        When User navigates first link
        Then Title must contain specific text

    Scenario: find a specific link on the first pages of the search result
        Given User is on result page
        When User is searching specific link on results pages
        Then detected link must be on the result page
