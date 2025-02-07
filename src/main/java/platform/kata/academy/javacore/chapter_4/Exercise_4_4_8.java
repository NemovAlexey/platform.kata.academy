package platform.kata.academy.javacore.chapter_4;

/*
Практическая задача 4.4.8 Практическое задание «Залогируйте два сообщения»

Создайте в статичном публичном методе logging логгер с именем com.javamentor.logging.Test,
залогируйте им два сообщения: первое "Все хорошо" с уровнем INFO и второе "Произошла ошибка" с уровнем WARNING.
java.util.logging.* импортирован за вас
*/

import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercise_4_4_8 {
    public static void main(String[] args) {

    }

    public static void logging() {
        Logger logger = Logger.getLogger("com.javamentor.logging.Test");
        logger.log(Level.INFO, "Все хорошо");
        logger.log(Level.WARNING, "Произошла ошибка");
    }
    
}
