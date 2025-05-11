import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class criarTabela {
    public static void main(String[] args) {
        try {
            Connection conexao = DriverManager.getConnection(
                "jdbc:postgresql://dpg-cvrbneh5pdvs73fb1uog-a.oregon-postgres.render.com/dbta",
                "alexdbta",
                "W5VgX8mHtyLLTtl50NccaMsyJhkg9axh"
            );

            String sql = "CREATE TABLE IF NOT EXISTS pessoa (" +
                         "id SERIAL PRIMARY KEY," +
                         "nome VARCHAR(100)," +
                         "sobrenome VARCHAR(100)," +
                         "cpf VARCHAR(20)," +
                         "endereco VARCHAR(150)," +
                         "ano_nascimento INT" +
                         ");";

            Statement stmt = conexao.createStatement();
            stmt.executeUpdate(sql);

            System.out.println("Tabela criada com sucesso!");

            stmt.close();
            conexao.close();

        } catch (Exception e) {
            System.out.println("Erro ao criar tabela: " + e.getMessage());
        }
    }
}