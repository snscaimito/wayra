Feature:  Determine available produce

  Scenario: Associate shipping boxes with origin
    Given there is a trailer loaded with "20" boxes of "broccoli"
    And the trailer came from the "ABC" field
    When the RFID reader reads the RFID tags
    Then all boxes are associated with the "ABC" field
    And the content tag for all boxes is "broccoli"
    And "20" boxes have been tagged
