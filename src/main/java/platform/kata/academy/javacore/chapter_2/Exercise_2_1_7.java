package platform.kata.academy.javacore.chapter_2;

/*
Практическая задача 2.1.7 Практическое задание «Работа с объектами»

Описание задачи:
На игровом поле находится робот. Позиция робота на поле описывается двумя целочисленным координатами: X и Y.
Ось X смотрит слева направо, ось Y — снизу вверх. Вспомни, как рисовал графики функций в школе.
В начальный момент робот находится в некоторой позиции на поле. Также известно,
куда робот смотрит: вверх, вниз, направо или налево. Ваша задача — привести робота в заданную точку игрового поля.
Робот описывается классом Robot. Вы можете пользоваться следующими его методами (реализация тебе неизвестна):

Пример:
В метод передано: toX == 3, toY == 0;
начальное состояние робота такое:
robot.getX() == 0, robot.getY() == 0, robot.getDirection() == Direction.UP

Чтобы привести робота в указанную точку (3, 0), метод должен вызвать у робота следующие методы:
robot.turnRight();
robot.stepForward();
robot.stepForward();
robot.stepForward();

Требования:
1. должен быть метод public static void moveRobot(Robot robot, int toX, int toY)
2. метод moveRobot должен переместить робота в позицию int toX, int toY
*/

public class Exercise_2_1_7 {
    public static void main(String[] args) {
        new Exercise_2_1_7().test();
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        if (robot.getX() < toX) {
            while (robot.getDirection() != Direction.RIGHT) {
                robot.turnRight();
            }
        } else {
            while (robot.getDirection() != Direction.LEFT) {
                robot.turnRight();
            }
        }
        while (robot.getX() != toX) {
            robot.stepForward();
        }

        if (robot.getY() < toY) {
            while (robot.getDirection() != Direction.UP) {
                robot.turnRight();
            }
        } else {
            while (robot.getDirection() != Direction.DOWN) {
                robot.turnRight();
            }
        }
        while (robot.getY() != toY) {
            robot.stepForward();
        }
    }

    public class Robot {
        private int x;
        private int y;
        private Direction direction;

        public Robot(int x, int y, Direction direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }

        public Robot() {
        }

        public Direction getDirection() {
            return direction;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public void setDirection(Direction direction) {
            this.direction = direction;
        }

        public void turnLeft() {
            switch (getDirection()) {
                case UP -> setDirection(Direction.LEFT);
                case RIGHT -> setDirection(Direction.UP);
                case DOWN -> setDirection(Direction.RIGHT);
                case LEFT -> setDirection(Direction.DOWN);
            }
        }

        public void turnRight() {
            switch (this.getDirection()) {
                case UP -> setDirection(Direction.RIGHT);
                case RIGHT -> setDirection(Direction.DOWN);
                case DOWN -> setDirection(Direction.LEFT);
                case LEFT -> setDirection(Direction.UP);
            }
        }

        public void stepForward() {
            switch (getDirection()) {
                case RIGHT -> x++;
                case LEFT -> x--;
                case UP -> y++;
                case DOWN -> y--;
            }
        }

        @Override
        public String toString() {
            return "Robot{" +
                    "x=" + x +
                    ", y=" + y +
                    ", direction=" + direction +
                    '}';
        }
    }

    public enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    public void test() {
        Robot robot = new Robot(0, 0, Direction.UP);
        moveRobot(robot, 3, 0);
    }
}
