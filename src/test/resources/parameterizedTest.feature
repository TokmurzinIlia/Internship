#language:ru
#encoding:UTF-8

@test
Функционал: Параметризированный запуск тестов

  Структура сценария: Проверка цены гаджета <countryCode>


    Допустим цена гаджента равна "<countryCode>"
    Тогда статус код 200

    Примеры:
    |countryCode|
    |AZE|
    |BLR|
    |CHN|
    |EST|
    |FIN|

