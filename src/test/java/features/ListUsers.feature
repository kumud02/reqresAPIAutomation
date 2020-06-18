Feature: List Users

  Scenario: List Users with valid page value
    Given end point is given
    When user submits the post request with numeric page value
    Then verify status code is correct
