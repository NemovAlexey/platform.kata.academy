package platform.kata.academy.javacore.chapter_3;

/*
Практическая задача 3.2.4 Практическое задание «Реализовать метод getCreditForClient»

Есть класс BankClient - это класс, описывающий клиента банка.

Есть интерфейс BankWorker. Объект класса, который реализует этот интерфейс, является работником банка,
в задачу которого входит одобрение или отклонение заявок на кредиты.

У него есть метод checkClientForCredit, который на вход принимает экземпляр BankClient и возвращает true,
если всё в порядке и кредит переданному клиенту можно выдавать, или false - если клиент не подходит под условия кредита.
Также, этот метод может выбросить исключение BadCreditHistoryException, если у клиента плохая кредитная история.
Или ProblemWithLawException, если у клиента есть проблемы с законом.

Ваша задача:

Реализовать метод getCreditForClient, который принимает работника банка и клиента, который хочет получить кредит.
Метод должен возвращать true - если кредит выдать можно и все условия соблюдены и false если есть какие-то проблемы.
Если клиенту отказали в выдаче кредита по причине плохой банковской истории - метод должен выводить в консоль сообщение
"Проблемы с банковской историей", если клиенту отказали по причине проблем с законом, то ничего выводить на экран не нужно.
*/

public class Exercise_3_2_4 {
    public static void main(String[] args) {
        new Exercise_3_2_4().test();
    }

    public boolean getCreditForClient(BankWorker bankWorker, BankClient bankClient) {
        try {
            return bankWorker.checkClientForCredit(bankClient);
        } catch (BadCreditHistoryException e) {
            System.out.println("Проблемы с банковской историей");
        } catch (ProblemWithLawException e) {
            //ignore
        }
        return false;
    }

    public class BankClient {
        private String problem;

        public BankClient(String problem) {
            this.problem = problem;
        }

        public String getProblem() {
            return problem;
        }
    }

    public interface BankWorker {
        boolean checkClientForCredit(BankClient bankClient) throws BadCreditHistoryException, ProblemWithLawException;
    }

    public class BankEmployee implements BankWorker {
        @Override
        public boolean checkClientForCredit(BankClient bankClient) throws BadCreditHistoryException, ProblemWithLawException {
            return switch (bankClient.getProblem()) {
                case "Problem with law" -> throw new ProblemWithLawException();
                case "Bad Credit History" -> throw new BadCreditHistoryException();
                case "Good Credit history" -> true;
                default -> false;
            };
        }
    }

    public class BadCreditHistoryException extends Exception {
    }

    public class ProblemWithLawException extends Exception {
    }

    private void test() {
        BankClient client1 = new BankClient("Some problem");
        BankClient client2 = new BankClient("Problem with law");
        BankClient client3 = new BankClient("Good Credit history");
        BankClient client4 = new BankClient("Bad Credit History");
        BankWorker employee = new BankEmployee();

        System.out.println(getCreditForClient(employee, client1));
        System.out.println(getCreditForClient(employee, client2));
        System.out.println(getCreditForClient(employee, client3));
        System.out.println(getCreditForClient(employee, client4));
    }
}
