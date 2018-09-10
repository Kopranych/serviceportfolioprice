### serviceportfolioprice

Сервис на базе Spring для подсчета текущей стоимости портфеля (набора) акций и их распределение по секторам

Посредством REST API post **http://localhost:8080/portfolio/sum_price** на вход сервиса подается объект, представляющий собой произвольный набор акций с указанием количества каждой из них.

Входные данные
```
 {
    "stocks":[
      {
         "symbol":"ARWR",
         "volume":50
      },
      {
         "symbol":"MCFT",
         "volume":10
      },
      {
         "symbol":"CRNX",
         "volume":1
      },
      {
         "symbol":"OKTA",
         "volume":1
      }
    ]
}
```
На выходе возвращается объект, содержащий суммарную стоимость набора акций (value) и распределение по секторам (allocations).

Ожидаемый результат
```
{
 "value":1600000,
 "allocations":[
  {
     "sector":"Technology",
     "assetValue":600000,
     "proportion":0.375
  },
  {
     "sector":"Healthcare",
     "assetValue":1000000,
     "proportion":0.625
  }
 ]
}
```
Для сборки приложения в ОС Windows необходимо иметь установленный Java 8 JDK и скачать репозиторий через среду разработки например Intellij IDEA деплой и запуск проекта производить через SpringBoot контейнер сервлетов так же в проекте имеется собранный war файл проекта который можно запустить через консоль находясь в папке с этим файлом командой **java -jar userservice-0.0.1-SNAPSHOT.war**

Для проверки работы сервиса можно воспользоваться rest клиентом для chrome POSTMAN https://chrome.google.com/webstore/detail/tabbed-postman-rest-clien/coohjcphdfgbiolnekdpbcijmhambjff или анологичными программами
