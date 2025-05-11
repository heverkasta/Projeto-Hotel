
import java.text.SimpleDateFormat;
import java.util.Scanner;
public class navegacao {
    public static void main(String[] args){
        cliente c = new cliente();
        reserva r = new reserva();
        Scanner entrada = new Scanner(System.in);
        int naveg;
        int repetir;
        while(true){
            System.out.println("Hotel Boa Noite");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-");
            System.out.println("1-Cadastrar Cliente.");
            System.out.println("2-Consultar Clientes.");
            System.out.println("3-Criar Reserva.");
            System.out.println("4-Quartos Disponiveis.");
            System.out.println("5-Reservas.");
            System.out.println("6-Sair.");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-");
            System.out.print("Acao desejada: ");
            naveg = Integer.parseInt(entrada.nextLine());
            switch (naveg) {
                case 1:
                    System.out.print("Digite seu nome: ");
                    c.nome = entrada.nextLine();
                
                    System.out.print("Digite seu sobrenome: ");
                    c.sobrenome = entrada.nextLine();
                
                    System.out.print("Digite seu ano de nascimento: ");
                    c.anoNasc = Integer.parseInt(entrada.nextLine());
                
                    System.out.print("Digite seu cpf: ");
                    c.cpf = Long.parseLong(entrada.nextLine());

                    insertCadastro insC = new insertCadastro();
		            insC.insertCadastro(c);
                    break;
                case 2:
                    consultaCliente cons = new consultaCliente();
                    cons.consultaCliente();
                    break;
                case 3:
                    repetir = 1;
                    while(repetir != 2){
                    System.out.print("Digite o id do cliente: ");
                    r.id_cliente = Integer.parseInt(entrada.nextLine());
            
                    System.out.print("Digite o numero do quarto: ");
                    r.id_quarto = Integer.parseInt(entrada.nextLine());

                    System.out.print("Digite a data (aaaa/mm/dd): ");
                    r.data = entrada.nextLine();


                    insertReserva insR = new insertReserva();
                    insR.insertReserva(r);
                    System.out.print("Deseja fazer outra reserva? (1->Sim, 2->Nao): ");
                    repetir = Integer.parseInt(entrada.nextLine());
                    }
                    break;
                case 4:
                    break;
                case 5:
                    
                    break;
                case 6:
                    return;
            }
        }
    }
}
