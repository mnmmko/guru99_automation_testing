Feature:
  Scenario:
    Given user add username
    When user add password
    And submit login
    And assertion username
    Then Logout
