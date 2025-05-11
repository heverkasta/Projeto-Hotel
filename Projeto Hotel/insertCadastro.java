import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class insertCadastro {

    public void insertCadastro (cliente c) {
        try {
            Connection conexao = DriverManager.getConnection(
                "jdbc:postgresql://dpg-cvrcj1h5pdvs738ejo90-a.oregon-postgres.render.com/xddb",
                "xddb_user",
                "57DydjJrJPVR7SzmuFGcOKwTYJ4mXOi2"
            );

            String sql = "INSERT INTO cliente (nome, sobrenome, cpf, ano_nascimento) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, c.nome);
            stmt.setString(2, c.sobrenome);
            stmt.setLong(3, c.cpf);
            stmt.setInt(4, c.anoNasc);

            stmt.executeUpdate();

            System.out.println("Cadastro salvo com sucesso!");

            stmt.close();
            conexao.close();

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
        }
    }
}