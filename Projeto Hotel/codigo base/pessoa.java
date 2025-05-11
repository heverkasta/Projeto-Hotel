public class pessoa {
    String nome, sobrenome, endereco;
    int anoNasc;
    long cpf;

	int calcIdade(int anoAtual) {
		return anoAtual - anoNasc;
	}
}