import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class tableQuartos {
    public static void main(String[] args) {
        try {
            Connection conexao = DriverManager.getConnection(
                "jdbc:postgresql://dpg-cvrcj1h5pdvs738ejo90-a.oregon-postgres.render.com/xddb",
                "xddb_user",
                "57DydjJrJPVR7SzmuFGcOKwTYJ4mXOi2"
            );

            String sql = "CREATE TABLE IF NOT EXISTS quartos (" +
                         "id SERIAL PRIMARY KEY," +
                         "cama_casal INT," +
                         "cama_solteiro INT" +
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