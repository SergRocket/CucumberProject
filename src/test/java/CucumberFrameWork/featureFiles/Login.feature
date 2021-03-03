Feature: Login into account
    Existing user must be able to login into account using valid credentials
Scenario: Login onto account with correct credentials
Given User navigates to login page
And User enters valid credentias
And User clicks on login button
When User clicked on login button
Then User must be taken to main page

