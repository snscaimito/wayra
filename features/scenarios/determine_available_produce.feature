Feature:  Determine available produce

  Scenario:  I want to see what produce is ready to be picked.
      Given there's a field of broccoli
      When I walk the field
      Then I know how much broccoli is ripe


  Scenario: I want to know how much produce is available to be picked.
      Given there are 50 head of broccoli in the "100 sqm" sample plot
      And "20" head of broccoli are ripe
      And the field is "1 ha" in size
      When I estimate
      Then I know "2000" head of broccoli are ripe


  Scenario: I want to pick available produce.
    Given there is a trailer loaded with 20 boxes of broccoli
    And the trailer came from the "ABC" field
    When the RFID reader reads the RFID tags
    Then all 20 boxes are associated with the "ABC" field
