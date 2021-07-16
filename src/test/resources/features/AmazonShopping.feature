Feature: Shopping a book
  User Story: As a user, They should be able to search and purchase a book

  Scenario: Verification of Book's price
    When Visit amazon.com
    Given Search for Book qa testing for beginners
    Then Click on first item in the listed results
    And Before click on add to cart assert price from Step Three
    Then Click on Add to Cart
    And Before Click on Proceed to Checkout assert price from Step Three
    Then Click on proceed to checkout
    And On the checkout page assert price from Step Three

