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

  @Test3
  Scenario: Main test
    When we getting main data from server
    Then temp is 280.32
    And pressure is 1012
    And humidity is 81
    And temp_min is 279.15
    And temp_max is 281.15

