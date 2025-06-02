public class Conta {
    private double saldo;
    private double chequeEspecial;
    private double limiteChequeEspecial;
    private boolean chequeEspecialAtivo;

    public Conta(double saldo) {
        if (saldo < 0) return; // Não permite saldo negativo
        this.saldo = saldo;
        if (saldo <= 500.0) {
            this.chequeEspecial = 50.0;
        }
        else{
            this.chequeEspecial = saldo * 0.5;
        }
        this.limiteChequeEspecial = this.chequeEspecial;
        this.chequeEspecialAtivo = false;
    }

    private boolean isChequeEspecialAtivo() {
        return chequeEspecialAtivo;
    }

    private double getChequeEspecial() {
        return chequeEspecial;
    }

    private double getSaldo() {
        return saldo;
    }

    private double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    public void consultarSaldo(){
        System.out.println("Saldo: R$" + getSaldo());
    }

    public void consultarChequeEspecial(){
        if (isChequeEspecialAtivo()){
            System.out.println("Valor Atual de Cheque Especial: R$" + getChequeEspecial());
            System.out.println("Limite Cheque Especial: R$" + getLimiteChequeEspecial());
        }
        else {
            System.out.println("Cheque Especial Inativo: R$" + getChequeEspecial());
        }
    }

    public void depositarDinheiro(double valor){
        if(valor <= 0) return; // Não permite depósito de valor negativo ou zero
        if(saldo < 0 && isChequeEspecialAtivo()){
            double emprestado = limiteChequeEspecial - chequeEspecial;
            saldo += (valor - (emprestado * 0.2));
            chequeEspecial += emprestado;
            if (saldo > 0){
                chequeEspecialAtivo = false;
            }
        }
        else{
            saldo += valor;
        }
    }

    public void sacarDinheiro(double valor){
        if (valor > saldo){
            System.out.println("Saldo insuficiente para saque");
        }
        else{
            saldo -= valor;
        }
    }

    public void pagarBoleto(double valor){
        if (saldo >= valor){
            saldo -= valor;
            return;
        }
        if (valor > saldo && valor <= saldo + chequeEspecial){
            if (!isChequeEspecialAtivo()) {
                chequeEspecialAtivo = true;
            }
            saldo -= valor;
            chequeEspecial += saldo;
            System.out.println("Boleto pago com cheque especial.");
            return;
        }
        if (isChequeEspecialAtivo() && valor <= chequeEspecial) {
            saldo -= valor;
            chequeEspecial -= valor;
            return;
        }
        if (valor > saldo + chequeEspecial) {
            System.out.println("Saldo insuficiente para pagamento do boleto");
        }
    }

    public void estaUsandoChequeEspecial(){
        if (isChequeEspecialAtivo()){
            System.out.println("Você está usando o cheque especial.");
        }
        else{
            System.out.println("Você NÃO está usando o cheque especial.");
        }
    }
}
