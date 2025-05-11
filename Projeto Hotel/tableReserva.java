import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class tableReserva {
    public static void main(String[] args) {
        try {
            Connection conexao = DriverManager.getConnection(
                "jdbc:postgresql://dpg-cvrcj1h5pdvs738ejo90-a.oregon-postgres.render.com/xddb",
                "xddb_user",
                "57DydjJrJPVR7SzmuFGcOKwTYJ4mXOi2"
            );

            String sql = "CREATE TABLE IF NOT EXISTS reserva (" +
                         "id SERIAL PRIMARY KEY," +
                         "id_cliente INT," +
                         "id_quarto INT," +
                         "data VARCHAR(10)," +
                         "CONSTRAINT clientres FOREIGN KEY (id_cliente) REFERENCES cliente (id)," +
                         "CONSTRAINT quartores FOREIGN KEY (id_quarto) REFERENCES quartos (id)" +
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