package platform.kata.academy.javacore.chapter_2;

/*
Практическая задача 2.3.11 Практическое задание «Использовать различные модификаторы доступа»

Цель: Закрепить знания по использованию модификаторов доступа

Что нужно знать:
1. Классы, методы.
2. Модификаторы доступа

Дан класс Human
Класс этот находится в пакете "Дом". Объекты этого класса — люди — обладают информацией разной степени приватности,
а именно:
1. secret — каждый человек имеет секрет, которым он бы не хотел делиться ни с кем.
2. news — каждый человек знает новость, которую он хотел бы рассказать всем, кто его об этом спросит.
3. experience — опыт. Каждый человек обладает некоторым жизненным опытом, делиться с которыми он хотел бы либо с детьми,
либо с теми, с кем находится в одном доме (пакете)
4. gossip — сплетни. Все любят сплетничать, но делают это все как правило внутри дома (пакета).

Задание:
Добавьте в класс Human 4 метода:
1. getSecret()
2. getNews()
3. getExperience()
4. getGossip()
которые помогут ему реализовать его желание делиться разной информацией с разными людьми. Для этого используйте с методами нужные модификаторы доступа.

Требования:
метод getSecret() возвращает значение поля secret
метод getNews() возвращает значение поля news
метод getExperience() возвращает значение поля experience
метод getGossip() возвращает значение поля gossip
*/

public class Exercise_2_3_11 {
    public static void main(String[] args) {
        test();
    }

    public class Human {
        private final String secret; //секретики
        private final String news; //новости
        private final String experience; //опыт
        private final String gossip; //сплетни

        public Human(String secret, String news, String experience, String gossip) {
            this.secret = secret;
            this.news = news;
            this.experience = experience;
            this.gossip = gossip;
        }

        private String getSecret() {
            return secret;
        }

        public String getNews() {
            return news;
        }

        protected String getExperience() {
            return experience;
        }

        String getGossip() {
            return gossip;
        }
    }


    public static void test() {

    }
}
