@Accounts
Feature: Opportunity

  Background: 
    Given I have application URL
    When I login with valid credentials
    Then I should be able to see home page

  Scenario: Verify pop up  should be displayed when price book is changed from standard to GRC pricebook
    Given I login as a GRC users
    When I will click on Accounts tab
    And I will search for the existing account from the list
    And I go to the opportunites related list
    And I click on the new sale opportunity
    And I create a new opportunity with all the mandatory details
    Then I validate the popup and GRC pricebook

  Scenario: Verify GRC Opportunity is checked once it is changed from Standard prce book to GRC pricebook
    Given I login as a GRC users
    When I will click on Accounts tab
    And I will search for the existing account from the list
    And I go to the opportunites related list
    And I click on the new sale opportunity
    And I create a new opportunity with all the mandatory details
    Then I validate the popup and GRC pricebook
    And I validate the GRC Opportunity is checked or not

  Scenario: verify the fields Partners and Distribution,Partner Engagement Type,GSA Sale present in opportunity page once it is created
    Given I login as a GRC users
    When I will click on Accounts tab
    And I will search for the existing account from the list
    And I go to the opportunites related list
    And I click on the new sale opportunity
    And I create a new opportunity with all the mandatory details
    Then I validate the popup and GRC pricebook
    And I validate the fields Partners and Distribution,Partner Engagement Type,GSA Sale

  Scenario: Verify whether the popup up is displayed when user is creating quote before addition of contact Role
    Given I login as a GRC users
    When I will click on Accounts tab
    And I will search for the existing account from the list
    And I go to the opportunites related list
    And I click on the new sale opportunity
    And I create a new opportunity with all the mandatory details
    And I will create GRC pricebook
    And I will add the products
    And I will add Primary contact in contact roles Opty page

  Scenario: Verify the Closed Date when an new opportunity is created
    Given I login as a GRC users
    When I will click on Accounts tab
    And I will search for the existing account from the list
    And I go to the opportunites related list
    And I click on the new sale opportunity
    And I create a new opportunity with all the mandatory details
    Then I validate the popup and GRC pricebook
    And I validate the closed date

  Scenario: Verify GSA Sale and its related fields is available on the GRC opportunity page layout.
    Given I login as a GRC users
    When I will click on Accounts tab
    And I will search for the existing account from the list
    And I go to the opportunites related list
    And I click on the new sale opportunity
    And I create a new opportunity with all the mandatory details
    Then I validate the popup and GRC pricebook
    And I validate GSA Sale and its related cases

  Scenario: Verify the GSA Sale field is positioned below the Partner Engagement Type field
    Given I login as a GRC users
    When I will click on Accounts tab
    And I will search for the existing account from the list
    And I go to the opportunites related list
    And I click on the new sale opportunity
    And I create a new opportunity with all the mandatory details
    Then I validate the popup and GRC pricebook
    And I validate whether GSA Sale field is positioned below the Partner Engagement Type field

  Scenario: Verify that GSA Sale field is added to all opportunity page layout
    Given I login as a GRC users
    When I will click on Accounts tab
    And I will search for the existing account from the list
    And I go to the opportunites related list
    And I click on the new sale opportunity
    And I create a new opportunity with all the mandatory details
    Then I validate whether the GSA Sale field is added or not

  Scenario: Verify that GSA Sale field is reportable
    Given I login as a GRC users
    When I will click on Reports tab
    And I will click on New Report
    And I will search and click on Oportunities
    And I will click on Create button
    And I will click and search GSA Sale
    And I wll drag and drop GSA sale to the Report
    Then I will validate where the GSA sale field is in header section of the report

  Scenario: Verify that GSA Sale field is unchecked by default
    Given I login as a GRC users
    When I will click on Reports tab
    And I will click on New Report
    And I will search and click on Oportunities
    And I will click on Create button
    And I will click and search GSA Sale
    And I wll drag and drop GSA sale to the Report

  Scenario Outline: Verify that GSA Sale field is editable for all profiles
    Given I login as "<users>"
    When I will click on Accounts tab
    And I will search for the existing account from the list
    And I go to the opportunites related list
    And I click on the new sale opportunity
    And I create a new opportunity with all the mandatory details
    Then I will validate the GSA Sale field is editable for all profiles

    Examples: 
      | users        |
      | Sarah Inman  |
      | Barnabas Acs |
      | gana prabhu  |

  Scenario: Verify Corporate - Manufacturing and Corporate - Retail values are available in Organisation Type field on the account page layout
    Given I login as a GRC users
    When I will click on Accounts tab
    And I will search for the existing account from the list
    And I will click on Organisation Type dropdown list
    Then I verify the fields are present or not

  Scenario: Verify that Corporate - Manufacturing and Corporate - Retail value are enables for Prospect types on account.
    Given I login as a GRC users
    When I will click on Accounts tab
    And I will search for the existing prospect account
    And I will click on Organisation Type dropdown list
    Then I verify the fields are present or not

  Scenario Outline: Verify Corporate - Manufacturing and Corporate - Retail value are enables for both Internal Referral & Standard Lead types
    Given I login as a GRC users
    When I will click on the Leads tab
    And I will select the "<types>"
    And I will click on continue button
    And I will click on dropdown List
    Then I verify Corporate - Manufacturing and Corporate - Retail value are enabled

    Examples: 
      | types             |
      | Standard Lead     |
      | Internal Referral |

  Scenario: Verify that Account classification field present on the account detail page should be populated with Buy Side
    Given I login as a GRC users
    When I will click on Accounts tab
    And I will search for the existing account from the list
    And I will click on Organisation Type dropdown list
    And I will select the Org Type Values from drop down
    Then I validate the Account classification field present on the account detail page for Corporate - Manufacturing
    And I validate the Account classification field present on the account detail page for Corporate - Retail value

  Scenario: Verify that the user is able to have different currency in opportunity apart from account currency
    Given I am on the Opportunities Page
    When I search and select the existing opportunity
    And I select the different currency in opportunity apart from account currency
    Then User able to have different currency in opportunity apart from account currency

  Scenario: Verify that the different currency change is applicable only for Sales quote
    Given I am on the Opportunities Page
    When I search and select the existing opportunity
    And I select the different currency in opportunity apart from account currency
    Then I verify different currency change is applicable only for Sales quote

  Scenario: Verify the field Close Date Push Counter of type Formula is created on Opportunity object
    Given I login as a GRC users
    When I will click on Accounts tab
    And I will search for the existing account from the list
    And I go to the opportunites related list
    And I click on the new sale opportunity
    And I create a new opportunity with all the mandatory details
    Then I validate the popup and GRC pricebook
    And I Verify the field Close Date Push Counter of type Formula is created on Opportunity object

  Scenario: Verify the field Original close date on an Opportunity has changed
    Given I login as a GRC users
    When I will click on Accounts tab
    And I will search for the existing account from the list
    And I go to the opportunites related list
    And I click on the new sale opportunity
    And I create a new opportunity with all the mandatory details
    Then I validate the popup and GRC pricebook
    And I Verify the field Original close date on an Opportunity has changed

  Scenario: Verify that the new field Close Date Push Counter increases the count every time the field close date gets updated
    Given I login as a GRC users
    When I will click on Accounts tab
    And I will search for the existing account from the list
    And I go to the opportunites related list
    And I click on the new sale opportunity
    And I create a new opportunity with all the mandatory details
    Then I validate the popup and GRC pricebook
    And I Verify the field Original close date push counter on an Opportunity has changed
