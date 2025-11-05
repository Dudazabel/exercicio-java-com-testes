package org.example.repository;

import org.example.model.Produto;
import org.example.util.ConexaoBanco;

import java.sql.*;
import java.util.List;

public class ProdutoRepositoryImpl implements ProdutoRepository{

    @Override
    public Produto save(Produto produto) throws SQLException {
        String query = "INSERT INTO teste(nome, preco, quantidade, categoria) VALUES (?,?,?,?)";

        try(Connection conn = ConexaoBanco.conectar();
            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){

            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setString(4, produto.getCategoria());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if(rs.next()){
                produto.setId(rs.getInt(1));
            }
        }catch(SQLException erro){
            erro.printStackTrace();
        }
        return produto;
    }

    @Override
    public List<Produto> findAll() throws SQLException {
        return null;
    }

    @Override
    public Produto findById() throws SQLException {
        return null;
    }

    @Override
    public Produto update(Produto produto) throws SQLException {
        return null;
    }

    @Override
    public void deleteById(int id) throws SQLException {

    }
}
