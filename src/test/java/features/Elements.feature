Feature: Try the web elements
  A user try to use the web elements clicking
  on left menu "Elements" of the page "https://demoqa.com/elements"

  Background: User click on Elements button
    Given the page elements is opened
    When user click on Elements button
    Then should see list of elements

    Scenario: User click and use TextBox
      Given user click on TextBox button
      When complete the form
      And click Submit button
      Then the user see the entered data
    