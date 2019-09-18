@Accounts
Feature: Quote

  Background: 
    Given I have application URL
    When I login with valid credentials
    Then I should be able to see home page

  Scenario: Verify that Primary contact and billing contact is mandatory to create a sale quote
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
    Then I will validate whether Primary contact and billing contact is mandatory to create a sale quote

  Scenario: Verify that User is able to create GRC Quote
    			and Verify that contract type, initial term, renewal term, quote name is auto populated
    			and Active Quote Ind checkbox on the opportunity

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
    Then I will verify Active Quote Ind checkbox in Opty Page

  Scenario: Verify that GRC Quote status is moved  to Rejected on the quote detail  page when a Quote is
    			rejected either by CA or Commercial Policy for GRC user

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
    And I will Reject the request in Chatter Page and logout
    And I login as a GRC users
    Then I will validate Quote status is moved to Rejected
    And I will validate user is able to resubmit GRC Quote without Editing the quot
    And I will validate Quote Status is changed from Rejected to In Progress after click on EDIT button

  Scenario: Verify that synchronization is occurred between opty and quote if the stop sync button is clicked
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
    Then I will Verify that synchronization is occurred if the stop sync button is clicked

  Scenario: Verify that Start sync/Stop sync button is available in the quote header page
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
    Then I will validate Start sync/Stop sync button is available in the quote header page

  Scenario: Verify that the different currency change is applicable only for Sales Quote
    Given I am on the Opportunities Page
    When I search and select the existing opportunity
    And I select the different currency in opportunity apart from account currency
    Then I verify different currency change is applicable only for Sales quote

  Scenario: Verify whether the popup up is displayed when user is creating Quote before addition of contact Role
    Given I login as a GRC users
    When I will click on Accounts tab
    And I will search for the existing account from the list
    And I go to the opportunites related list
    And I click on the new sale opportunity
    And I create a new opportunity with all the mandatory details
    Then I validate the popup and GRC pricebook
    And I validate the pop up when user is creating quote before addition of contact Role

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

  Scenario: Verify that synchronization is occurred between opty and quote if the start sync button is clicked
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
    Then I will Verify that synchronization is occurred if the start sync button is clicked

  Scenario: Verify that after clicking on GRC Trial Opportunity button free trial opportunity is created automatically
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
    Then I will validate Start sync/Stop sync button is available in the quote header page
    Then I will validate free trial opportunity is created automatically
