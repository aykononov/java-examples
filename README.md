<small>

## полезные примеры на Java

[/package01/ListFilesDemo - Вывести списокв файлов](https://github.com/aykononov/JavaExamples/tree/main/src/main/java/package01/ListFilesDemo.java "Посмотреть пример ...")

[/package02/PhoneBookFromTextFile - Телефонная книга читает и записывает в текстовый файл](https://github.com/aykononov/JavaExamples/tree/main/src/main/java/package02/PhoneBookFromTextFile.java "Посмотреть пример ...")

[/package03/PhaseThreadDemo - Пример многопоточного приложения с применением класса Phaser](https://github.com/aykononov/JavaExamples/tree/main/src/main/java/package03/PhaseThreadDemo.java "Посмотреть пример Java")


<details><summary>Класс Phaser ... </summary>

<small>

>Класс *Phaser* синхронизирует потоки, он определяет объект синхронизации, который ждет, пока не завершится определенная фаза.  
>Далее *Phaser* переходит к следующей стадии или фазе и снова ожидает ее завершения.
>
>Конструкторы для создания объекта *Phaser*:
>```
>Phaser() // создает объект без каких-либо участников
>Phaser(int parties) // регистрирует передаваемое количество участников
>Phaser(Phaser parent) // устанавливает родительский объект Phaser
>Phaser(Phaser parent, int parties) // устанавливает родительский объект Phaser и регистрирует количество участников
>```
>Основные методы класса *Phaser*:
>```
>int register():              регистрирует участника, который выполняет фазы, и возвращает номер текущей фазы - обычно фаза 0
>int arrive():                сообщает, что участник завершил фазу и возвращает номер текущей фазы
>int arriveAndAwaitAdvance(): аналогичен методу arrive, только при этом заставляет phaser ожидать завершения фазы всеми остальными участниками
>int arriveAndDeregister():   сообщает о завершении всех фаз участником и снимает его с регистрации. Возвращает номер текущей фазы или отрицательное число, если синхронизатор Phaser завершил свою работу
>int getPhase():              возвращает номер текущей фазы
>```
>
</small>

</details>

[/package04/GetCurrentTimestamp - Получить текущую метку времени](https://github.com/aykononov/JavaExamples/tree/main/src/main/java/package04/GetCurrentTimestamp.java "Посмотреть пример ...")

</small>