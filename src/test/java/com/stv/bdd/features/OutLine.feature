Feature: Search checking

  Scenario Outline: Check search input and dropdown
    Given Homepage is loaded
    And Search bar is visible
    When The User enters "<request>" in the search bar
    And Dropdown menu appears
    And The User backspace search bar
#  And Dropdown menu contains Run
    When Dropdown menu is hidden
    Then Search bar is not empty

    Examples:
      | request |
      | run     |
      | gym     |