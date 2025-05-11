import java.util.Scanner;
public class cadastro {
    public static void main (String[] args) {
        pessoa p = new pessoa();
		Scanner entrada = new Scanner(System.in);
		int ano = 2025;

        System.out.print("Digite seu nome: ");
		p.nome = entrada.nextLine();

		System.out.print("Digite seu sobrenome: ");
		p.sobrenome = entrada.nextLine();

		System.out.print("Digite seu endereço: ");
		p.endereco = entrada.nextLine();

		System.out.print("Digite seu ano de nascimento: ");
		p.anoNasc = Integer.parseInt(entrada.nextLine());

		System.out.print("Digite seu cpf: ");
		p.cpf = Long.parseLong(entrada.nextLine());

        System.out.println("Nome: " + p.nome);
        System.out.println("Sobrenome: " + p.sobrenome);
        System.out.println("Endereço: " + p.endereco);
        System.out.println("Idade em "+ano+": " + p.calcIdade(ano) + "anos.");
        System.out.println("CPF: " + p.cpf);
		
		insertDB ins = new insertDB();
		ins.savePessoa(p);
    }
}