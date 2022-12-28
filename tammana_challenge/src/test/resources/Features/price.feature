#Author: Hiago Fernandes 

@tag
Feature: Test of product price sums

  @validate_price
  Scenario: Validates the sum of the price of two items and size bag
    Given I visit the Tammana website
    When I click on female category
      And select first product
      And select size
    When add the product in cart  
      And return to previous page
    When I click on male category
      And select first product
      And select size
    When add the product in cart
    When I click on the shopping cart
    Then the price shown must be the sum of all selected products and total items in cart must equal two