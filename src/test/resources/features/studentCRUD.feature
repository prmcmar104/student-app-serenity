#Feature: Student Application
#
#  As a user I want to test Student Application
#
#  Scenario Outline: Verify CRUD operation of student app
#    Given Student application is running
#    When I create a new student by providing the information firstName "<firstName>" lastName "<lastName>" email "<email>" programme "<programme>" courses "<courses>"
#    Then I verify that the student with "<firstName>" is created
#    And I update the student with information firstName "<firstName>" lastName "<lastName>" email "<email>" programme "<programme>" courses "<courses>"
#    Then The student with firstName "<firstName>" is updated successfully
#    And I delete the student that created with firstName "<firstName>"
#    Then The student deleted successfully from the application
#    Examples:
#      | firstName | lastName | email            | programme        | courses |
#      | Prime1    | Testing  | prime1@gmail.com | Computer Science | JAVA    |
#      | Prime2    | Testing  | prime2@gmail.com | Api Testing      | Python  |