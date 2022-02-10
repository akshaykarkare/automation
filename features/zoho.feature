Feature: As a User
         I Want to navigate to Zoho Website on Chrome Browser
         and Sing up for free
         then login

  @zoho @demo
  Scenario: Navigate to Zoho Website on Chrome Browser
    Given Open "zohoURL" Website
    Then click on "Zoho_Home.signInLink"