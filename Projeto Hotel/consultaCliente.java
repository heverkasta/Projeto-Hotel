import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class consultaCliente {
    public void consultaCliente () {
        try {
            Connection conexao = DriverManager.getConnection(
                "jdbc:postgresql://dpg-cvrcj1h5pdvs738ejo90-a.oregon-postgres.render.com/xddb",
                "xddb_user",
                "57DydjJrJPVR7SzmuFGcOKwTYJ4mXOi2"
            );

            Scanner entrada = new Scanner(System.in);

            System.out.print("Digite o nome para a busca: ");
            String busca = entrada.nextLine();

            String sql = "SELECT * FROM cliente WHERE nome like '%"+busca+"%'";
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            boolean find = false;

            System.out.println("Dados da pesquisa: ");
            while (rs.next()) {
                find = true;
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String sobrenome = rs.getString("sobrenome");
                String cpf = rs.getString("cpf");
                int anoNascimento = rs.getInt("ano_nascimento");

                System.out.println(id + " - " + nome + " " + sobrenome + " | CPF: " + cpf + " | Nasc: " + anoNascimento);
            }

            if (find == false) {
                System.out.println("Nenhum dado encontrado.");
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (Exception e) {
            System.out.println("Erro ao consultar: " + e.getMessage());
        }
    }
}