Feature: Layout language switch
  As a user I should able to switch language at layout.

  Scenario: Check layout
    Then element having class "launchpad" should have attribute "alt" with value "Launch Pad"

    And element having class "span-metro-blue" should have text as "Limit Check"
    And element having class "mrc-icon-large" should have attribute "alt" with value "Limit Check"
    And element having class "limitcheck" should have attribute "alt" with value "Limit Check"

    And element having class "span-metro-blue" should have text as "Quick Check"
    And element having class "mrc-icon-large" should have attribute "alt" with value "Quick Check"
    And element having class "quickcheck" should have attribute "alt" with value "Quick Check"

    And element having class "span-metro-blue" should have text as "History"
    And element having class "mrc-icon-large" should have attribute "alt" with value "History"
    And element having class "history" should have attribute "alt" with value "History"

    And element having class "span-metro-blue" should have text as "Inbox"
    And element having class "mrc-icon-large" should have attribute "alt" with value "Inbox"
    And element having class "inbox" should have attribute "alt" with value "Inbox"

    And element having class "span-metro-blue" should not have text as "Credit Correction"
    And element having class "mrc-icon-large" should not have attribute "alt" with value "Credit Correction"
    And element having class "mrc-icon-base" should not have attribute "alt" with value "Credit Correction"

  Scenario: Switch to German
    Given I select "de" option by text from dropdown having id "language-select"

    And element having class "launchpad" should have attribute "alt" with value "Kreditportal"

    And element having class "span-metro-blue" should have text as "Kundenprüfung"
    And element having class "mrc-icon-large" should have attribute "alt" with value "Kundenprüfung"
    And element having class "limitcheck" should have attribute "alt" with value "Kundenprüfung"

    And element having class "span-metro-blue" should have text as "Quick Check"
    And element having class "mrc-icon-large" should have attribute "alt" with value "Quick Check"
    And element having class "quickcheck" should have attribute "alt" with value "Quick Check"

    And element having class "span-metro-blue" should have text as "Historie"
    And element having class "mrc-icon-large" should have attribute "alt" with value "Historie"
    And element having class "history" should have attribute "alt" with value "Historie"

    And element having class "span-metro-blue" should have text as "Inbox"
    And element having class "mrc-icon-large" should have attribute "alt" with value "Inbox"
    And element having class "inbox" should have attribute "alt" with value "Inbox"

  Scenario: Switch to Spanish
    Given I select "es" option by text from dropdown having id "language-select"

    Then element having class "launchpad" should have attribute "alt" with value "Panel de Control"

    And element having class "span-metro-blue" should have text as "Revisión de límite"
    And element having class "mrc-icon-large" should have attribute "alt" with value "Revisión de límite"
    And element having class "limitcheck" should have attribute "alt" with value "Revisión de límite"

    #And element having class "span-metro-blue" should have text as "Quick Check"
    #And element having class "mrc-icon-large" should have attribute "alt" with value "Quick Check"
    #And element having class "quickcheck" should have attribute "alt" with value "Quick Check"

    And element having class "span-metro-blue" should have text as "Histórico"
    And element having class "mrc-icon-large" should have attribute "alt" with value "Histórico"
    And element having class "history" should have attribute "alt" with value "Histórico"

    And element having class "span-metro-blue" should have text as "Inbox"
    And element having class "mrc-icon-large" should have attribute "alt" with value "Inbox"
    And element having class "inbox" should have attribute "alt" with value "Inbox"

  Scenario: Switch back to English
    Given I select "en" option by text from dropdown having id "language-select"

    Then element having class "span-metro-blue" should have text as "Limit Check"
    And element having class "mrc-icon-large" should have attribute "alt" with value "Limit Check"
    And element having class "limitcheck" should have attribute "alt" with value "Limit Check"

    And element having class "span-metro-blue" should have text as "Quick Check"
    And element having class "mrc-icon-large" should have attribute "alt" with value "Quick Check"
    And element having class "quickcheck" should have attribute "alt" with value "Quick Check"

    And element having class "span-metro-blue" should have text as "History"
    And element having class "mrc-icon-large" should have attribute "alt" with value "History"
    And element having class "history" should have attribute "alt" with value "History"

    And element having class "span-metro-blue" should have text as "Inbox"
    And element having class "mrc-icon-large" should have attribute "alt" with value "Inbox"
    And element having class "inbox" should have attribute "alt" with value "Inbox"
