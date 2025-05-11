import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class quarto {
    public static void main (String[] args) {
		Scanner entrada = new Scanner(System.in);

        int cama_casal, cama_solteiro;

		System.out.print("cama casal: ");
		cama_casal = Integer.parseInt(entrada.nextLine());

        System.out.print("cama solteiro: ");
		cama_solteiro = Integer.parseInt(entrada.nextLine());


        try {
            Connection conexao = DriverManager.getConnection(
                "jdbc:postgresql://dpg-cvrcj1h5pdvs738ejo90-a.oregon-postgres.render.com/xddb",
                "xddb_user",
                "57DydjJrJPVR7SzmuFGcOKwTYJ4mXOi2"
            );

            String sql = "INSERT INTO quartos (cama_casal, cama_solteiro) VALUES (?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, cama_casal);
            stmt.setInt(2, cama_solteiro);

            stmt.executeUpdate();

            System.out.println("Quarto salvo com sucesso!");

            stmt.close();
            conexao.close();

        } catch (Exception e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }
}