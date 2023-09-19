import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String borda = "-".repeat(30);
        System.out.println(borda);
        System.out.println("BEM VINDO À CASA DE APOSTAS");
        System.out.println(borda);
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Qual é o seu nome? ");
        String name = sc.next();
        System.out.println("ATENÇÃO!");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("ATENÇÃO!");
        TimeUnit.SECONDS.sleep(1);
        System.out.printf("Player %s está na casa!%n", name);
        TimeUnit.SECONDS.sleep(1);
        double saldo = 0.00;
        int opcao = -1;
        while (opcao != 0) {
            System.out.println(borda);
            System.out.printf("""
                    Menu LOTOFÁCIL:
                    Player: %s
                    Saldo: R$ %.2f
                    1) Apostar de 0 a 100
                    2) Apostar de A à Z
                    3) Apostar em par ou ímpar
                    0) Sair%n""",name, saldo);
            System.out.println(borda);
            System.out.println("Escolha uma opção:");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1 -> {
                    int number, number_random;
                    System.out.println("Digite um número de 0 a 100: ");
                    number = sc.nextInt();
                    if (number >= 0 && number <= 100) {
                        Random random = new Random();
                        number_random = random.nextInt(100 + 1);
                        if (number_random == number) {
                            saldo += 1000;
                            System.out.println("Você ganhou R$ 1.000,00");
                        } else {
                            System.out.printf("Que pena! O número sorteado foi: %d%n", number_random);
                        }
                    } else {
                        System.out.println("Aposta inválida!");
                    }
                    TimeUnit.SECONDS.sleep(2);
                }
                case 2 -> {
                    System.out.println("Digite uma letra de A à Z: ");
                    char letter = (char) System.in.read();
                    boolean x = Character.isLetter(letter);
                    if (x) {
                        letter = Character.toUpperCase(letter);
                        if (letter == 'M') {
                            saldo += 500;
                            System.out.println("Você ganhou R$ 500,00");
                        } else {
                            System.out.println("Que pena! A letra sorteada foi M!");
                        }
                    } else {
                        System.out.println("Aposta inválida!");
                    }
                    TimeUnit.SECONDS.sleep(2);
                }
                case 3 -> {
                    System.out.println("Digite um número inteiro: ");
                    int num = sc.nextInt();
                    num = num % 2;
                    if (num == 0) {
                        saldo += 100;
                        System.out.println("Você ganhou R$ 100,00");
                    } else {
                        System.out.println("Que pena!\n" +
                                           "O número digitado é ímpar e a premiação foi para números pares.");
                    }
                    TimeUnit.SECONDS.sleep(2);
                }
                case 0 -> {
                    System.out.printf("Adeus, %s... Você ganhou R$ %.2f!%n", name, saldo);
                    TimeUnit.SECONDS.sleep(1);
                }
                default -> System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}
