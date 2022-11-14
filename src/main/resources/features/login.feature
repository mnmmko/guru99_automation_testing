Feature:
  @tast01
 Scenario Outline: login
    Given open guru99 login
    When user add username "<username>"
    And user add password "<password>"
    And submit login
    And assertion username
    Then Logout
  Examples:
    | username | password |
    |mngr454711|bEbypYt   |