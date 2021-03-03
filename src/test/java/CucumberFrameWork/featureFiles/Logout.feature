Feature: Login into account
    Existing user must be able to login into account using valid credentials
Scenario: Login onto account with correct credentials
Given User navigates to log page
And User enters valid creds
And User clicks on log button
And User taken to main page
And User click logout button
When User clicked on logout button
Then User must be taken to login page

