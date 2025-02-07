package platform.kata.academy.javacore.chapter_4;

/*
Практическая задача 4.4.9 Практическое задание «Описать набор классов MailService»

Эта задачка совмещает тренировку по материалу предыдущих двух модулей — необходимо разобраться и написать
объект-ориентированный код и при этом коснуться свежих тем — исключений и логирования.
Дан набор классов, описывающих работу гипотетической почтовой системы.
Для начала рассмотрим код, описывающий все используемые сущности.

Вам необходимо описать набор классов, каждый из которых является MailService:

1) UntrustworthyMailWorker — класс, моделирующий ненадежного работника почты, который вместо того,
чтобы передать почтовый объект непосредственно в сервис почты, последовательно передает этот объект набору третьих лиц,
а затем, в конце концов, передает получившийся объект непосредственно экземпляру RealMailService.
У UntrustworthyMailWorker должен быть конструктор от массива MailService (результат вызова processMail
первого элемента массива передается на вход processMail второго элемента, и т. д.) и метод getRealMailService,
который возвращает ссылку на внутренний экземпляр RealMailService, он не приходит массивом
в конструкторе и не настраивается извне класса.

2) Spy — шпион, который логгирует о всей почтовой переписке, которая проходит через его руки.
Объект конструируется от экземпляра Logger, с помощью которого шпион будет сообщать о всех действиях.
Он следит только за объектами класса MailMessage и пишет в логгер следующие сообщения
(в выражениях нужно заменить части в фигурных скобках на значения полей почты):

2.1) Если в качестве отправителя или получателя указан "Austin Powers", то нужно написать в лог сообщение с уровнем WARN:
Detected target mail correspondence: from {from} to {to} "{message}"

2.2) Иначе, необходимо написать в лог сообщение с уровнем INFO: Usual correspondence: from {from} to {to}

3) Thief — вор, который ворует самые ценные посылки и игнорирует все остальное. Вор принимает в конструкторе переменную
int – минимальную стоимость посылки, которую он будет воровать. Также, в данном классе должен присутствовать
метод getStolenValue, который возвращает суммарную стоимость всех посылок, которые он своровал.
Воровство происходит следующим образом: вместо посылки, которая пришла вору, он отдает новую, такую же,
только с нулевой ценностью и содержимым посылки "stones instead of {content}".

4) Inspector — Инспектор, который следит за запрещенными и украденными посылками и бьет тревогу в виде исключения,
если была обнаружена подобная посылка. Если он заметил запрещенную посылку с одним из запрещенных содержимым
("weapons" и "banned substance"), то он бросает IllegalPackageException. Если он находит посылку,
состоящую из камней (содержит слово "stones"), то тревога прозвучит в виде StolenPackageException.
Оба исключения вы должны объявить самостоятельно в виде непроверяемых исключений.

Все классы должны быть определены как публичные и статические, так как в процессе проверки ваш код будет подставлен
во внешний класс, который занимается тестированием и проверкой структуры. Для удобства во внешнем классе объявлено
несколько удобных констант и импортировано все содержимое пакета java.util.logging. Для определения, посылкой или
письмом является Sendable объект воспользуйтесь оператором instanceof.
*/


import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercise_4_4_9 {
    public static final String AUSTIN_POWERS = "Austin Powers";
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";

    public static void main(String[] args) {

    }

    public static class UntrustworthyMailWorker implements MailService {
        private final MailService[] mailServices;
        private final RealMailService realMailService;

        public UntrustworthyMailWorker(MailService[] mailServices) {
            realMailService = new RealMailService();
            this.mailServices = mailServices;
        }

        public RealMailService getRealMailService() {
            return realMailService;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            for (MailService service : mailServices) {
                mail = service.processMail(mail);
            }
            return getRealMailService().processMail(mail);
        }
    }

    public static class Spy implements MailService {
        private final Logger logger;

        public Spy(Logger logger) {
            this.logger = logger;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailMessage mailMessage) {
                String from = mailMessage.getFrom();
                String to = mailMessage.getTo();
                if (AUSTIN_POWERS.equals(from) || AUSTIN_POWERS.equals(to)) {
                    logger.log(Level.WARNING, "Detected target mail correspondence: from {0} to {1} \"{2}\"",
                            new Object[]{from, to, mailMessage.getMessage()});
                } else {
                    logger.log(Level.INFO, "Usual correspondence: from {0} to {1}",
                            new Object[]{from, to});
                }
            }
            return mail;
        }
    }

    public static class Thief implements MailService {
        private final int minPrice;
        private int stolenValue;

        public Thief(int minPrice) {
            this.minPrice = minPrice;
        }

        public int getStolenValue() {
            return stolenValue;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailPackage) {
                Package content = ((MailPackage) mail).getContent();
                if (content.getPrice() >= minPrice) {
                    stolenValue += content.getPrice();
                    content = new Package("stones instead of " + content.getContent(), 0);
                    mail = new MailPackage(mail.getFrom(), mail.getTo(), content);
                }
            }
            return mail;
        }
    }

    public static class Inspector implements MailService {
        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailPackage mailPackage) {
                String content = mailPackage.getContent().getContent().toLowerCase();
                if (content.contains(WEAPONS) || content.contains(BANNED_SUBSTANCE)) {
                    throw new IllegalPackageException();
                }
                if (content.contains("stones")) {
                    throw new StolenPackageException();
                }
            }
            return mail;
        }
    }

    public static class StolenPackageException extends RuntimeException {
    }

    public static class IllegalPackageException extends RuntimeException {
    }

    /*
    Интерфейс: сущность, которую можно отправить по почте.
    У такой сущности можно получить от кого и кому направляется письмо.
    */
    public static interface Sendable {
        String getFrom();

        String getTo();
    }

    /*
    Абстрактный класс, который позволяет абстрагировать логику хранения
    источника и получателя письма в соответствующих полях класса.
    */
    public static abstract class AbstractSendable implements Sendable {

        protected final String from;
        protected final String to;

        public AbstractSendable(String from, String to) {
            this.from = from;
            this.to = to;
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
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            AbstractSendable that = (AbstractSendable) o;

            if (!from.equals(that.from)) return false;
            return to.equals(that.to);
        }

    }

    /*
    Письмо, у которого есть текст, который можно получить с помощью метода `getMessage`
    */
    public static class MailMessage extends AbstractSendable {

        private final String message;

        public MailMessage(String from, String to, String message) {
            super(from, to);
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            MailMessage that = (MailMessage) o;

            return Objects.equals(message, that.message);
        }

    }

    /*
    Посылка, содержимое которой можно получить с помощью метода `getContent`
    */
    public static class MailPackage extends AbstractSendable {
        private final Package content;

        public MailPackage(String from, String to, Package content) {
            super(from, to);
            this.content = content;
        }

        public Package getContent() {
            return content;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            MailPackage that = (MailPackage) o;

            return content.equals(that.content);
        }

    }

    /*
    Класс, который задает посылку. У посылки есть текстовое описание содержимого и целочисленная ценность.
    */
    public static class Package {
        private final String content;
        private final int price;

        public Package(String content, int price) {
            this.content = content;
            this.price = price;
        }

        public String getContent() {
            return content;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Package aPackage = (Package) o;

            if (price != aPackage.price) return false;
            return content.equals(aPackage.content);
        }
    }

    /*
    Интерфейс, который задает класс, который может каким-либо образом обработать почтовый объект.
    */
    public static interface MailService {
        Sendable processMail(Sendable mail);
    }

    /*
    Класс, в котором скрыта логика настоящей почты
    */
    public static class RealMailService implements MailService {

        @Override
        public Sendable processMail(Sendable mail) {
            // Здесь описан код настоящей системы отправки почты.
            return mail;
        }
    }
}
