import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class insertReserva {

    public void insertReserva (reserva r) {


        try {
            Connection conexao = DriverManager.getConnection(
                "jdbc:postgresql://dpg-cvrcj1h5pdvs738ejo90-a.oregon-postgres.render.com/xddb",
                "xddb_user",
                "57DydjJrJPVR7SzmuFGcOKwTYJ4mXOi2"
            );
            
            String sql = "INSERT INTO reserva (id_cliente, id_quarto, data) VALUES (?, ?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, r.id_cliente);
            stmt.setInt(2, r.id_quarto);
            stmt.setString(3, r.data);

            stmt.executeUpdate();

            System.out.println("Reserva salva com sucesso!");

            stmt.close();
            conexao.close();

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
        }
    }
}