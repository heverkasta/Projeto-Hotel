import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class insertDB {

    public void savePessoa(pessoa p) {
        try {
            Connection conexao = DriverManager.getConnection(
                "jdbc:postgresql://dpg-cvrcj1h5pdvs738ejo90-a.oregon-postgres.render.com/xddb",
                "xddb_user",
                "57DydjJrJPVR7SzmuFGcOKwTYJ4mXOi2"
            );

            String sql = "INSERT INTO pessoa (nome, sobrenome, cpf, endereco, ano_nascimento) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, p.nome);
            stmt.setString(2, p.sobrenome);
            stmt.setLong(3, p.cpf);
            stmt.setString(4, p.endereco);
            stmt.setInt(5, p.anoNasc);

            stmt.executeUpdate();

            System.out.println("Pessoa salva com sucesso!");

            stmt.close();
            conexao.close();

        } catch (Exception e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }
}