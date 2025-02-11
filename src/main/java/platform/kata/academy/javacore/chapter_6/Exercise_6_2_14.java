package platform.kata.academy.javacore.chapter_6;

/*
Практическая задача 6.2.14 Практическое задание «Generics, коллекции и Stream API. Успешный код»

В этой задаче вам предстоит самостоятельно написать набор классов таким образом,
чтобы данный код успешно компилировался и выполнялся.
Вам предстоит использовать новые знания про generics, коллекции и Stream API.
В приведенном коде используется оператор assert. Этот оператор используется для того, чтобы проверять определенные
инварианты в коде. С помощью него возможно писать небольшие тесты и следить за корректностью своей программы
(в обычной ситуации предпочтительно для этих целей использовать библиотеки для модульного тестирования,
которые выходят за рамки базового курса).

Оператор выглядит следующим образом:

assert предикат: сообщение;

Предикат — выражение с типом boolean. Если выражение является ложным, то в программе возникает исключение AssertionError
с соответствующим сообщением.

По-умолчанию данная функциональность отключена. Чтобы ее включить, необходимо передать специальный ключ -ea в параметры
виртуальной машины. Сделать это можно прямо при запуске в консоли с помощью программы java, либо указав этот ключ
в настройках запуска программы в вашей IDE. В случае IntellijIDEA, например, эта опция указывается в поле Run —>
Edit Configurations... —> конфигурация запуска вашей программы —> VM Options.
Код, который необходимо заставить успешно работать:

В конечном итоге, вам нужно реализовать классы MailService, MailMessage и Salary (и, вероятно, вспомогательные классы
и интерфейсы) и отправить их код в форму. Все классы должны быть публичными и статическими
(ваши классы подставятся во внешний класс для тестирования).

В идеологически правильном решении не должно фигурировать ни одного оператора instanceof.

В классе для тестирования объявлены следующие импорты:
*/

import java.util.*;
import java.util.function.Consumer;

public class Exercise_6_2_14 {
    public static void main(String[] args) {
        test();
    }

    private static void test() {

    }

    interface Sendable<T> {
        String getFrom();

        String getTo();

        T getContent();
    }

    public static class AbstractSendable<T> implements Sendable<T> {
        private final String from;
        private final String to;
        private final T content;

        private AbstractSendable(String from, String to, T content) {
            this.from = from;
            this.to = to;
            this.content = content;
        }

        @Override
        public String getFrom() {
            return from;
        }

        @Override
        public String getTo() {
            return to;
        }

        @Override
        public T getContent() {
            return content;
        }
    }

    public static class MailMessage extends AbstractSendable<String> {
        public MailMessage(String from, String to, String content) {
            super(from, to, content);
        }
    }

    public static class Salary extends AbstractSendable<Integer> {
        public Salary(String from, String to, int content) {
            super(from, to, content);
        }
    }

    public static class MailService<T> implements Consumer<Sendable<T>> {
        private final Map<String, List<T>> mailBox = new HashMap<>() {
            @Override
            public List<T> get(Object key) {
                return super.getOrDefault(key, Collections.emptyList());
            }
        };

        public Map<String, List<T>> getMailBox() {
            return mailBox;
        }

        @Override
        public void accept(Sendable<T> sendable) {
            List<T> contents = !mailBox.get(sendable.getTo()).isEmpty() ? mailBox.get(sendable.getTo()) : new ArrayList<>();
            contents.add(sendable.getContent());
            mailBox.put(sendable.getTo(), contents);
        }
    }
}
