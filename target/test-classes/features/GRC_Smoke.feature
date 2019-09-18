@Accounts
Feature: Smoke Testing

  Background: 
    Given I have application URL
    When I login with valid credentials
    Then I should be able to see home page

  Scenario: Verify user is able to create an GRC Sale opportunity through accounts page
    Given I login as a GRC users
    When I will click on Accounts tab
    And I will search for the existing account from the list
    And I go to the opportunites related list
    And I click on the new sale opportunity
    And I create a new opportunity with all the mandatory details
    And I will create GRC pricebook
    Then I validate the opportunity is created successfully


  Scenario: Verify user is able to create GRC Sale Quote
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

  Scenario: Submit the quote for fulfillment
    Given I login as a GRC users
    When I will click on Accounts tab
    And I will search for the existing account from the list
    And I go to the opportunites related list
    And I click on the new sale opportunity
    And I create a new opportunity with all the mandatory details
    And I will create GRC pricebook
    And I will add the products
    And I will add Primary contact in contact roles Opty page
    Then I will create GRC free trial opportunity
    And I will go to quotes realted tab in oty page
    And I will create new Free trial quote
    And I will submit the Free Trial Quote for Approval
    And I will submit for fullfillment

  Scenario: GRC free trial opportunity creation
    Given I login as a GRC users
    When I will click on Accounts tab
    And I will search for the existing account from the list
    And I go to the opportunites related list
    And I click on the new sale opportunity
    And I create a new opportunity with all the mandatory details
    And I will create GRC pricebook
    And I will add the products
    And I will add Primary contact in contact roles Opty page
    Then I will create GRC free trial opportunity

  Scenario: GRC free trial quote creation
    Given I login as a GRC users
    When I will click on Accounts tab
    And I will search for the existing account from the list
    And I go to the opportunites related list
    And I click on the new sale opportunity
    And I create a new opportunity with all the mandatory details
    And I will create GRC pricebook
    And I will add the products
    And I will add Primary contact in contact roles Opty page
    Then I will create GRC free trial opportunity
    And I will go to quotes realted tab in oty page
    And I will create new Free trial quote

  
  Scenario: Submit Free trial quote
    Given I login as a GRC users
    When I will click on Accounts tab
    And I will search for the existing account from the list
    And I go to the opportunites related list
    And I click on the new sale opportunity
    And I create a new opportunity with all the mandatory details
    And I will create GRC pricebook
    And I will add the products
    And I will add Primary contact in contact roles Opty page
    Then I will create GRC free trial opportunity
    And I will go to quotes realted tab in oty page
    And I will create new Free trial quote
    And I will submit the Free Trial Quote for Approval

  Scenario: Submit Free trial quote for approval
    Given I login as a GRC users
    When I will click on Accounts tab
    And I will search for the existing account from the list
    And I go to the opportunites related list
    And I click on the new sale opportunity
    And I create a new opportunity with all the mandatory details
    And I will create GRC pricebook
    And I will add the products
    And I will add Primary contact in contact roles Opty page
    Then I will create GRC free trial opportunity
    And I will go to quotes realted tab in oty page
    And I will create new Free trial quote
    And I will submit the Free Trial Quote for Approval

  Scenario: Submit the quote to Create order form
    Given I login as a GRC users
    When I will click on Accounts tab
    And I will search for the existing account from the list
    And I go to the opportunites related list
    And I click on the new sale opportunity
    And I create a new opportunity with all the mandatory details
    And I will create GRC pricebook
    And I will add the products
    And I will add Primary contact in contact roles Opty page
    Then I will create GRC free trial opportunity
    And I will go to quotes realted tab in oty page
    And I will create new Free trial quote
    And I will submit the Free Trial Quote for Approval
    And I will submit for fullfillment to create order form

  Scenario: Send the order form to client via send with docusign
    Given I login as a GRC users
    When I will click on Accounts tab
    And I will search for the existing account from the list
    And I go to the opportunites related list
    And I click on the new sale opportunity
    And I create a new opportunity with all the mandatory details
    And I will create GRC pricebook
    And I will add the products
    And I will add Primary contact in contact roles Opty page
    Then I will create GRC free trial opportunity
    And I will go to quotes realted tab in oty page
    And I will create new Free trial quote
    And I will submit the Free Trial Quote for Approval
    And I will send the orderform to client

  Scenario: Submit the free trial quote for fulfillment
    Given I login as a GRC users
    When I will click on Accounts tab
    And I will search for the existing account from the list
    And I go to the opportunites related list
    And I click on the new sale opportunity
    And I create a new opportunity with all the mandatory details
    And I will create GRC pricebook
    And I will add the products
    And I will add Primary contact in contact roles Opty page
    Then I will create GRC free trial opportunity
    And I will go to quotes realted tab in oty page
    And I will create new Free trial quote
    And I will submit the Free Trial Quote for Approval
    And I will submit for fullfillment

  Scenario: Approve all the service delivery and billing CAA's
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
    And I will approve all the scervice delivery and billing CAA

  Scenario: Approve all the service delivery activities
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
    And I will approve all the service delivery activities

  Scenario: Extend the quote line item on free trial quote
    Given I login as a GRC users
    When I will click on Accounts tab
    And I will search for the existing account from the list
    And I go to the opportunites related list
    And I click on the new sale opportunity
    And I create a new opportunity with all the mandatory details
    And I will create GRC pricebook
    And I will add the products
    And I will add Primary contact in contact roles Opty page
    Then I will create GRC free trial opportunity
    And I will go to quotes realted tab in oty page
    And I will create new Free trial quote
    And I will submit the Free Trial Quote for Approval
    And I will submit for fullfillment

  #And I will extend the quote line item on free trial quote
  Scenario: Convert the free trial quote line item
    Given I login as a GRC users
    When I will click on Accounts tab
    And I will search for the existing account from the list
    And I go to the opportunites related list
    And I click on the new sale opportunity
    And I create a new opportunity with all the mandatory details
    And I will create GRC pricebook
    And I will add the products
    And I will add Primary contact in contact roles Opty page
    Then I will create GRC free trial opportunity
    And I will go to quotes realted tab in oty page
    And I will create new Free trial quote
    And I will submit the Free Trial Quote for Approval
    And I will submit for fullfillment
