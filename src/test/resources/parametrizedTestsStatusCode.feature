
  Feature: Test status code with valid country code
    Scenario Outline: Test status code with valid three-character country code to uppercase <countryCode>
      When User entered valid three-character country code "<countryCode>"
      Then User get status code 200
      Examples:
        |countryCode|
        |AZE|
        |BLR|
        |CHN|
        |EST|
        |FIN|

    Scenario Outline: Test status code with valid alpfa2 code country code to uppercase <countryCode>
      When User entered valid three-character country code "<countryCode>"
      Then Take alpfa2 code from response
      Then User get response with alpfa2 code
      Then User get status code 200
      Examples:
        |countryCode|
        |AZE|
        |BLR|
        |CHN|
        |EST|
        |FIN|