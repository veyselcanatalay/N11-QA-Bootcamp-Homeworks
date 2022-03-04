Feature: e2e test for search functionality.

  Scenario: ui and api testing scenario for Search with known keyword
    Given I open browser and go to the main page
    When I search with "python" in the home page
    Then api endpoint should be called with "python"
    When api returned related results
    Then I should see related results on the main page