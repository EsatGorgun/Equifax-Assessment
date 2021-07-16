Feature: Employee Details
  User Story: I should be able to get any specific employee details and delete it

  Scenario: Use Get and Delete methods from the specified end-points
    When Use Get and Delete methods, see successful Status Codes
    Then Get a specific Employee details
    And Delete an Employee, and see message : successfully! deleted Records