package org.example.service;

import org.example.model.Produto;
import org.example.repository.ProdutoRepository;
import org.example.repository.ProdutoRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class ProdutoServiceImpl implements ProdutoService{

    ProdutoRepository repository = new ProdutoRepositoryImpl();

    @Override
    public Produto cadastrarProduto(Produto produto) throws SQLException{
        if(produto.getPreco() < 0){
            throw new IllegalArgumentException("Preço deve ser positivo.");
        }

        return repository.save(produto);
    }

    @Override
    public List<Produto> listarProdutos() {
        return null;
    }

    @Override
    public Produto buscarPorId(int id) {
        return null;
    }

    @Override
    public Produto atualizarProduto(Produto produto, int id) {
        return null;
    }

    @Override
    public boolean excluirProduto(int id) {
        return false;
    }
}
