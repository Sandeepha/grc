 Feature: GAM Approval

  Scenario: Submit quote for approval
    Given I login as a GRC users
    When I will click on Accounts tab
    And I will search for the existing account from the list
    And I go to the opportunites related list
    And I click on the new sale opportunity
    And I create a new opportunity with all the mandatory details
    And I will create GRC pricebook
    And I will add the products
    And I will add Primary contact in contact roles Opty page
    And I will go to quotes realted tab in oty page
    And I will create new quote
    And I will submit the quote for Approval

  Scenario: Submit the quote and approval CA
    Given I login as a GRC users
    When I will click on Accounts tab
    And I will search for the existing account from the list
    And I go to the opportunites related list
    And I click on the new sale opportunity
    And I create a new opportunity with all the mandatory details
    And I will create GRC pricebook
    And I will add the products
    And I will add Primary contact in contact roles Opty page
    And I will go to quotes realted tab in oty page
    And I will create new quote
    And I will submit the quote for Approval
    And I will get the GAM user and login
    Then I will approve the Quote

  Scenario: Create order form and Send the order form to client via send with docusign
    Given I login as a GRC users
    When I will click on Accounts tab
    And I will search for the existing account from the list
    And I go to the opportunites related list
    And I click on the new sale opportunity
    And I create a new opportunity with all the mandatory details
    And I will create GRC pricebook
    And I will add the products
    And I will add Primary contact in contact roles Opty page
    And I will go to quotes realted tab in oty page
    And I will create new quote
    And I will submit the quote for Approval
    And I will get the GAM user and login
    Then I will approve the Quote
    And I login as a GRC user
    And I will approve as CA user
    And I will create order form and send to client with docsign
