## Параметры запуска для командной строки


### Пресеты через system.properties:

* `./gradlew clean test -Denvironment=local_chrome`

* `./gradlew clean test -Denvironment=local_safari`

* `./gradlew clean test -Denvironment=remote_chrome`

* `./gradlew clean test -Denvironment=remote_safari`


### Запуск с параметрами, пример:

`./gradlew clean test -DbrowserName=chrome -DbrowserVersion=128.0`


### Доступные параметры:

* `threads` - количество параллельных потоков, default: `8`

* `browserName` - название браузера, default: `chrome`

* `browserVersion` - версия браузера; игнорируется, если не указана

* `browserSize` - размер окна браузера, default: `1920x1080`

* `headless` - headless режим браузера, default: `false`

* `timeout` - максимальная задержка до падения теста, default: `10000` ms

* `remote` - адрес удаленного сервера Selenide; игнорируется, если оставить пустым

браузеры: `chrome`, `safari`, `firefox`, `legacy_firefox`, `ie`, `opera`, `edge`.


### После окончания тестов:

`./gradlew allureServe` для отчетов.