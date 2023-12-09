Feature: Testing FirstCry page

  Scenario Outline: Testing Store Locatore Feature of FirstCry
    Given I oopen the browser and enter URL
    Then I cclick on Login link and enter the email id <email>
    Then I vverify the <title> of the FirstCryPage
    Then I cclick on Stores&Preschools
    Then I Ccllick on findstores

    Examples: 
      | email                    | title                                                                                      |
      | "prpr23091999@gmail.com" | "Baby Products Online India: Newborn Baby Products & Kids Online Shopping at FirstCry.com" |
