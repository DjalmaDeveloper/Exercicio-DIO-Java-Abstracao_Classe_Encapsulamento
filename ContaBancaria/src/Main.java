import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escolha um valor para sua conta:");
        double valorInicial = sc.nextDouble();

        Conta conta = new Conta(valorInicial);

        int opcao = 0;

        do{
            System.out.println("===ESCOLHA UMA OPÇÃO===");
            System.out.println("1 - Consultar Saldo");
            System.out.println("2 - Consultar Cheque Especial");
            System.out.println("3 - Depositar Dinheiro");
            System.out.println("4 - Sacar Dinheiro");
            System.out.println("5 - Pagar Boleto");
            System.out.println("6 - Ver se está em Cheque Especial");
            System.out.println("0 - Sair");
            opcao = sc.nextInt();

            switch (opcao){
                case 1:
                    conta.consultarSaldo();
                    break;
                case 2:
                    conta.consultarChequeEspecial();
                    break;
                case 3:
                    System.out.println("Digite o valor para depósito:");
                    double valor = sc.nextDouble();
                    conta.depositarDinheiro(valor);
                    break;
                case 4:
                    System.out.println("Digite o valor para saque:");
                    valor = sc.nextDouble();
                    conta.sacarDinheiro(valor);
                    break;
                case 5:
                    System.out.println("Digite o valor do boleto:");
                    valor = sc.nextDouble();
                    conta.pagarBoleto(valor);
                    break;
                case 6:
                    conta.estaUsandoChequeEspecial();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }
        } while (true);
    }
}