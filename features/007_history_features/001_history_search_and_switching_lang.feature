Feature: History search and language switch

  Scenario: Initial check
    Given I click on element having class "history"
    Then element having class "limitcheck" should have attribute "alt" with value "Limit Check"
    And element having class "quickcheck" should have attribute "alt" with value "Quick Check"
    And element having class "history" should have attribute "alt" with value "History"
    And element having class "inbox" should have attribute "alt" with value "Inbox"
    And element having id "search-input" should have attribute "placeholder" with value "Store, Customer Number, Name"

  Scenario: Switch to German
    Given I select "de" option by text from dropdown having id "language-select"
    Then element having class "limitcheck" should have attribute "alt" with value "Kundenprüfung"
    And element having class "quickcheck" should have attribute "alt" with value "Quick Check"
    And element having class "history" should have attribute "alt" with value "Historie"
    And element having class "inbox" should have attribute "alt" with value "Inbox"
    And element having id "search-input" should have attribute "placeholder" with value "Suchkriterien z.B. Markt, KundenNr"

  Scenario: Switch to Spanish
    Given I select "es" option by text from dropdown having id "language-select"
    Then element having class "limitcheck" should have attribute "alt" with value "Revisión de límite"
    And element having class "history" should have attribute "alt" with value "Histórico"
    And element having class "inbox" should have attribute "alt" with value "Inbox"
    And element having id "search-input" should have attribute "placeholder" with value "Centro, Cliente, Número, Nombre"

  Scenario: Switch to back to English
    Given I select "en" option by text from dropdown having id "language-select"
    Then element having class "limitcheck" should have attribute "alt" with value "Limit Check"
    And element having class "quickcheck" should have attribute "alt" with value "Quick Check"
    And element having class "history" should have attribute "alt" with value "History"
    And element having class "inbox" should have attribute "alt" with value "Inbox"
    And element having id "search-input" should have attribute "placeholder" with value "Store, Customer Number, Name"
