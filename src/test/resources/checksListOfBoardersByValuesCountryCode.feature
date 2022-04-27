
Feature: Test
  Scenario Outline: Test that checks a list of boarders by values country code <countryCode>
    When User entered valid three-character country code "<countryCode>"
    Then Actual list of boarder "<key>"
    Then Actual list of boarder equals expectedList "<expectedStringCountryBorders>"
    Examples:
      |countryCode|   key    | expectedStringCountryBorders                                     |
      |AZE        |borders[0]|ARM,GEO,IRN,RUS,TUR                                               |
      |BLR        |borders[0]|LVA,LTU,POL,RUS,UKR                                               |
      |CHN        |borders[0]|AFG,BTN,MMR,HKG,IND,KAZ,PRK,KGZ,LAO,MAC,MNG,PAK,RUS,TJK,VNM,NPL   |
      |EST        |borders[0]|LVA,RUS                                                           |
      |FIN        |borders[0]|NOR,SWE,RUS                                                       |