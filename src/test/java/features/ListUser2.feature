Feature: List Users

  @Severity=BLOCKER
  Scenario: List Users with valid page value 2
    Given end point is given
    When user submits the post request with numeric page value
    Then verify status code is correct
    
	@Severity=CRITICAL
  Scenario: List Users with valid page value 3
    Given end point is given
    When user submits the post request with numeric page value
    Then verify status code is correct
    
  @SeverityLevel.NORMAL
  Scenario: List Users with valid page value 4
    Given end point is given
    When user submits the post request with numeric page value
    Then verify status code is correct