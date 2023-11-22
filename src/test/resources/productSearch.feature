# Feature: megfelel a user story leírásának
@Functional, @Search
Feature: A specific product can be found
  using the "Search" function on the page
"""
Leírás
...
...
Link
"""
  #Rule: a feature működésére vonatkozó szabály (acceptance criteria)
  Rule: If search for an existing product it will be displayed

    # scenario-k közös előfeltételei
    Background:
      Given I open the home page
      And I accept cookies

    #Scenario: ezek tesztesetek
    @TC24
    Scenario: Search for an existing product (mazsola)
      When I search for "mazsola"
      Then 13 products are displayed
      And the product's name contains "mazsola"

    Scenario: Search for an existing product (joghurt)
      When I search for "joghurt"
      Then 191 products are displayed
      And the product's name contains "joghurt"

    @TC_SearchProduct
    Scenario Outline: Search for an item that exists
      When I search for the "<productName>"
      Then "<numOfProducts>" products are displayed
      And the product's name contains "<productName>"
      And header contains the word "<productName>"
      And a product's name contains the "<productName>"

      Examples:
        | productName       | numOfProducts  |
        | mazsola           | 13             |
        | joghurt           | 191             |

  Rule: If search with empty input search is not available

    Background:
      Given I open the home page
      And I accept cookies

    Scenario: Search with empty input
      When I search for ""
      Then search function does nothing

  Rule: If search for a non-existing product a message displayed

    Scenario: Search for an non-existing product (XYZ)
      When I search for "XYZ"
      Then message displayed that the search didn't find anything
      And "Shop groceries" button is available
      And "Search" button is available