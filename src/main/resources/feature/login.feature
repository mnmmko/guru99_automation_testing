Feature:
 Scenario Outline:
    Given user add username "<username>"
    When user add password "<password>"
    And submit login
    And assertion username
    Then Logout
  Examples:
    | username | password |
    |mngr454711|bEbypYt   |