package platform.kata.academy.javacore.chapter_3;

/*
Практическая задача 3.2.7 Практическое задание «Реализация метода getConnection и try-with-resources»

Реализация метода getConnection и try-with-resources

Реши предыдущую задачу с использованием try-with-resources
*/

public class Exercise_3_2_7 {
    public static void main(String[] args) {

    }

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        for (int i = 0; i < 3; i++) {
            try (RobotConnection robotConnection = robotConnectionManager.getConnection()) {
                robotConnection.moveRobotTo(toX, toY);
                i = 3;
            } catch (RobotConnectionException e) {
                if (i == 2) {
                    throw e;
                }
            }
        }
    }
    
    public interface RobotConnection extends AutoCloseable {
        void moveRobotTo(int x, int y);

        @Override
        void close();
    }

    public interface RobotConnectionManager {
        RobotConnection getConnection();
    }

    public class RobotConnectionException extends RuntimeException {

        public RobotConnectionException(String message) {
            super(message);

        }

        public RobotConnectionException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
