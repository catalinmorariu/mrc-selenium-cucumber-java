Feature: Block case feature

  Scenario: Customer search and submit request

    Given I want to test against "https://mrc-pp.metrosystems.net" as "test.user@metrosystems.net"
    And Idam login if required for "user_id" as user and "password" as password and "submit"
    And go to "creditlimit" tile at launchpad
    And enter "15/108105" into "search-input" and pick it from the list
    # should we cancel running request or just fail immediately?
    And if there is a running request then click "Edit" and cancel it via "Cancel" button
    Then there should be "request credit" button and I click it
    # currently only presence, in theory order and exact(should not be any non mentioned) match is possible
    And check presence of "customer details, credit details, sales, comments, attachments" tabs

  Scenario: Credit details

    Given go to "credit details" tab
    Then for customer "15/108105" set "New" limit "Amount" 15000











#    Given I click on element having xpath "//*[@id="react-tabs-3"]/div/div/div/div[2]/table/tbody/tr[4]/td[6]/span"
#    When I click on element having xpath "//*[@id="react-tabs-3"]/div/div/div/div[2]/table/tbody/tr[6]/td/div[2]/div[2]/div[1]/div[2]/div/span"
#    Then I wait for page loading but no more than 2 seconds
#    Then I scroll to element having xpath "//*[@id="react-tabs-3"]/div/div/div/div[2]/table/tbody/tr[6]/td/div[2]/div[2]/div[2]/div[1]/div/div/div/input"
#    And I click on element having xpath "//*[@id="react-tabs-3"]/div/div/div/div[2]/table/tbody/tr[6]/td/div[2]/div[2]/div[2]/div[1]/div/div/div/input"
#    Then I enter "40000" into input field having css "#react-tabs-3 > div > div > div > div.mrc-ui-credit-tab-table-container.mrc-ui-grid-item > table > tbody > tr.mrc-ui-table-r.mrc-ui-table-r-form > td > div:nth-child(3) > div.mrc-ui-form-main-column > div.mrc-ui-card.mrc-ui-card-shadow > div:nth-child(2) > div > div > div > input"
#    Then I clear input field having css "#react-tabs-3 > div > div > div > div.mrc-ui-credit-tab-table-container.mrc-ui-grid-item > table > tbody > tr.mrc-ui-table-r.mrc-ui-table-r-form > td > div:nth-child(5) > div.mrc-ui-form-main-column > div > div > input"
#    Then I enter "25" into input field having css "#react-tabs-3 > div > div > div > div.mrc-ui-credit-tab-table-container.mrc-ui-grid-item > table > tbody > tr.mrc-ui-table-r.mrc-ui-table-r-form > td > div:nth-child(5) > div.mrc-ui-form-main-column > div > div > input"
#    Then I clear input field having css "#react-tabs-3 > div > div > div > div.mrc-ui-credit-tab-table-container.mrc-ui-grid-item > table > tbody > tr.mrc-ui-table-r.mrc-ui-table-r-form > td > div:nth-child(5) > div.mrc-ui-form-main-column > div > div > input"
#    Then I enter "2316546541654" into input field having css "#react-tabs-3 > div > div > div > div.mrc-ui-credit-tab-table-container.mrc-ui-grid-item > table > tbody > tr.mrc-ui-table-r.mrc-ui-table-r-form > td > div:nth-child(5) > div.mrc-ui-form-main-column > div > div > input"
#    Then I clear input field having css "#react-tabs-3 > div > div > div > div.mrc-ui-credit-tab-table-container.mrc-ui-grid-item > table > tbody > tr.mrc-ui-table-r.mrc-ui-table-r-form > td > div:nth-child(5) > div.mrc-ui-form-main-column > div > div > input"
#    Then I enter "25" into input field having css "#react-tabs-3 > div > div > div > div.mrc-ui-credit-tab-table-container.mrc-ui-grid-item > table > tbody > tr.mrc-ui-table-r.mrc-ui-table-r-form > td > div:nth-child(5) > div.mrc-ui-form-main-column > div > div > input"
#    And I click on element having id "react-tabs-6"
#    And I click on element having css "#react-tabs-7 > div > div.mt-5 > button"
#    Then I enter "The customer will be blocked, due to high risk" into input field having css "#react-tabs-7 > div > div.mt-5 > div > div.mrc-ui-modal > div > div > div.mrc-ui-input.clear-both > textarea"
#    And I click on element having css "#react-tabs-7 > div > div.mt-5 > div > div.mrc-ui-modal > div > div > div.mrc-btn-group > button.mrc-btn.mrc-primary-button.mrc-ui-button-small"
#    Then I wait for page loading but no more than 4 seconds
#    And I click on element having id "react-tabs-2"
#    Then I wait for page loading but no more than 2 seconds
#    And I click on element having xpath "//*[@id="react"]/div/main/form/div[3]/button[2]"
#
#  Scenario: CM approval
#
#    Given I click on element having xpath "//*[@id="react"]/div/div/div/div[1]/ul/li[2]/a/img"
#    Then I click on element having xpath "//*[@id="react"]/div/main/div/div[1]/div/div[2]/label/div"
#    Then I wait for page loading but no more than 2 seconds
#    Then I refresh page
#    Then I wait for page loading but no more than 2 seconds
#    Then I refresh page
#    Then I click on link having partial text "15/108105"
#    And I click on element having id "react-tabs-0"
#    And I click on element having id "react-tabs-2"
#    And I click on element having id "react-tabs-4"
#    And I click on element having id "react-tabs-6"
#    And I click on element having id "react-tabs-8"
#    And I click on element having id "react-tabs-10"
#    And I click on element having id "react-tabs-12"
#    And I click on element having id "react-tabs-14"
#    And I click on element having id "react-tabs-18"
#    And I click on element having id "react-tabs-16"
#    And I click on element having id "react-tabs-14"
#    And I click on element having id "react-tabs-12"
#    And I click on element having id "react-tabs-10"
#    And I click on element having id "react-tabs-8"
#    And I click on element having id "react-tabs-6"
#    And I click on element having id "react-tabs-4"
#    And I click on element having id "react-tabs-2"
#    And I click on element having id "react-tabs-0"
#    And I click on element having id "react-tabs-14"
#    And I click on element having id "react-tabs-2"
#    And I click on element having id "mrc-block-button"
#
#  Scenario: Customer search and submit request
#
#    Given I click on element having xpath "//*[@id="react"]/div/main/div/div[1]/a[1]/label/h2"
#    When I enter "15/108105" into input field having id "search-input"
#    Then I click on element having xpath "//*[@id="react"]/div/main/div/section[2]/ul/li[2]/a/div/h2[1]"
#    Then I wait for page loading but no more than 2 seconds
#    And I click on element having xpath "//*[@id="react"]/div/main/div/div[4]/button"
#    And I click on element having id "react-tabs-2"
#    And I click on element having id "react-tabs-4"
#    And I click on element having id "react-tabs-6"
#    And I click on element having id "react-tabs-8"
#    And I click on element having id "react-tabs-0"
#    And I click on element having id "react-tabs-2"
#    And I click on element having xpath "//*[@id="react"]/div/main/form/div[3]/button[2]"
