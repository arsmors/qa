Feature: Testing coordinates for weather

  @Test1
  Scenario: Coordinates test
    When we getting weather from server
    Then lon is -0.13
    And lat is 51.51

  @Test2
  Scenario: Wind test
    When we getting wind data from server
    Then speed is 4.1
    And deg is 80

