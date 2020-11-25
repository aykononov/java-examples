package package03;
/* Пример многопоточного приложения с применением класса Phaser.

Класс Phaser синхронизирует потоки - он определяет объект синхронизации,
который ждет, пока не завершится определенная фаза.
Далее Phaser переходит к следующей стадии или фазе и снова ожидает ее завершения.
*/
import java.util.concurrent.Phaser;

class PhaseThread implements Runnable {
    Phaser phaser;
    String name;

    PhaseThread(Phaser phaser, String name) {
        this.phaser = phaser;
        this.name = name;

        // регистрирует текущий поток как участника
        phaser.register();
    }

    public void run() {
        System.out.println(this.name + " выполняет фазу " + phaser.getPhase());
        phaser.arriveAndAwaitAdvance(); // сообщает, что Первая фаза достигнута
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(this.name + " выполняет фазу " + phaser.getPhase());
        phaser.arriveAndAwaitAdvance(); // сообщает, что Вторая фаза достигнута
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(this.name + " выполняет фазу " + phaser.getPhase());
        phaser.arriveAndDeregister(); // сообщает о Завершении фаз и удаляет с регистрации объект
    }
}

class MultithreadingUsingPhaser {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(1); // число 1 - главный поток
        new Thread(new PhaseThread(phaser, "PhaserThread 1")).start();
        new Thread(new PhaseThread(phaser, "PhaserThread 2")).start();
        new Thread(new PhaseThread(phaser, "PhaserThread 3")).start();

        // ожидаем завершения фазы 0
        int phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");

        // ожидаем завершения фазы 1
        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");

        // ожидаем завершения фазы 2
        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");

        phaser.arriveAndDeregister();
    }
}

/* ----------------------------
PhaserThread 2 выполняет фазу 0
PhaserThread 3 выполняет фазу 0
PhaserThread 1 выполняет фазу 0
Фаза 0 завершена
PhaserThread 1 выполняет фазу 1
PhaserThread 3 выполняет фазу 1
PhaserThread 2 выполняет фазу 1
Фаза 1 завершена
PhaserThread 2 выполняет фазу 2
PhaserThread 1 выполняет фазу 2
PhaserThread 3 выполняет фазу 2
Фаза 2 завершена
 */