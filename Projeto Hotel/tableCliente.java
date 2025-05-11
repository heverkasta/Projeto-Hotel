import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class tableCliente {
    public static void main(String[] args) {
        try {
            Connection conexao = DriverManager.getConnection(
                "jdbc:postgresql://dpg-cvrcj1h5pdvs738ejo90-a.oregon-postgres.render.com/xddb",
                "xddb_user",
                "57DydjJrJPVR7SzmuFGcOKwTYJ4mXOi2"
            );

            String sql = "CREATE TABLE IF NOT EXISTS cliente (" +
                         "id SERIAL PRIMARY KEY," +
                         "nome VARCHAR(100)," +
                         "sobrenome VARCHAR(100)," +
                         "cpf VARCHAR(20)," +
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