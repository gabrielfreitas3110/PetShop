package dao;

import connection.MySqlAccess;
import entities.Dog;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DogDao {

    public DogDao() {
    }
    
    public void insert(Dog dog) {
        Connection con = MySqlAccess.getConnection();
        PreparedStatement stm = null;
        
        try {
            String sql = "INSERT INTO tbdog (nome,raca,idade,peso,sexo,cor) "
                    + "VALUES(?,?,?,?,?,?)";
            stm = con.prepareStatement(sql);
            stm.setString(1, dog.getNome());
            stm.setString(2, dog.getRaca());
            stm.setInt(3, dog.getIdade());
            stm.setDouble(4, dog.getPeso());
            stm.setString(5, dog.getSexo());
            stm.setString(6, dog.getCor());
            stm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dados inseridos!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir dados: " + ex);
        } finally {
            MySqlAccess.disconnect(con,stm);
        }
    }
    
    public List<Dog> read() {
        Connection con = MySqlAccess.getConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Dog> dogs = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tbdog";
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while(rs.next()) {
                Dog dog = new Dog();
                dog.setCod(rs.getInt("cod"));
                dog.setNome(rs.getString("nome"));
                dog.setRaca(rs.getString("raca"));
                dog.setIdade(rs.getInt("idade"));
                dog.setPeso(rs.getDouble("peso"));
                dog.setSexo(rs.getString("sexo"));
                dog.setCor(rs.getString("cor"));
                dogs.add(dog);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar ler o banco de dados: " + ex);
        } finally {
            MySqlAccess.disconnect(con,stm,rs);
        }
        return dogs;
    }
    
    public void update(Dog dog) {
        Connection con = MySqlAccess.getConnection();
        PreparedStatement stm = null;
        try {
            String sql = "UPDATE tbdog "
                    + "SET nome=?,raca=?,idade=?,peso=?,sexo=?,cor=? WHERE cod=?";
            stm = con.prepareStatement(sql);
            stm.setString(1, dog.getNome());
            stm.setString(2, dog.getRaca());
            stm.setInt(3, dog.getIdade());
            stm.setDouble(4, dog.getPeso());
            stm.setString(5, dog.getSexo());
            stm.setString(6, dog.getCor());
            stm.setInt(7, dog.getCod());
            stm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dados atualizados!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar atualizar dados: " + ex);
        } finally {
            MySqlAccess.disconnect(con,stm);
        }
    }
    
    public void delete(Dog dog) {
        Connection con = MySqlAccess.getConnection();
        PreparedStatement stm = null;
        
        try {
            String sql = "DELETE FROM tbdog WHERE cod=?";
            stm = con.prepareStatement(sql);
            stm.setInt(1, dog.getCod());
            stm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dados excluido!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir dados: " + ex);
        } finally {
            MySqlAccess.disconnect(con,stm);
        }
    }
    
    public List<Dog> readLike(String search) {
        Connection con = MySqlAccess.getConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Dog> dogs = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tbdog WHERE nome LIKE ?";
            stm = con.prepareStatement(sql);
            stm.setString(1,search + '%');
            rs = stm.executeQuery();
            while(rs.next()) {
                Dog dog = new Dog();
                dog.setCod(rs.getInt("cod"));
                dog.setNome(rs.getString("nome"));
                dog.setRaca(rs.getString("raca"));
                dog.setIdade(rs.getInt("idade"));
                dog.setPeso(rs.getDouble("peso"));
                dog.setSexo(rs.getString("sexo"));
                dog.setCor(rs.getString("cor"));
                dogs.add(dog);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar ler o banco de dados: " + ex);
        } finally {
            MySqlAccess.disconnect(con,stm,rs);
        }
        return dogs;
    }
}
