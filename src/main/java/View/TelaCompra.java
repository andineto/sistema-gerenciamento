package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TelaCompra{

    private DefaultListModel<String> listaProdutosModel;
    private DefaultListModel<String> listaCarrinhoModel;

    public TelaCompra() {
        // Criando o JFrame
        JFrame frame = new JFrame("Tela de Compras");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // Lista de produtos (esquerda)
        listaProdutosModel = new DefaultListModel<>();
        carregarProdutos();
        JList<String> listaProdutos = new JList<>(listaProdutosModel);
        JScrollPane scrollProdutos = new JScrollPane(listaProdutos);

        // Lista do carrinho (direita)
        listaCarrinhoModel = new DefaultListModel<>();
        JList<String> listaCarrinho = new JList<>(listaCarrinhoModel);
        JScrollPane scrollCarrinho = new JScrollPane(listaCarrinho);

        // Botão para adicionar ao carrinho (centro)
        JButton btnAdicionar = new JButton(">>");
        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = listaProdutos.getSelectedIndex();
                if (selectedIndex != -1) {
                    String produtoSelecionado = listaProdutosModel.getElementAt(selectedIndex);
                    listaCarrinhoModel.addElement(produtoSelecionado);
                } else {
                    JOptionPane.showMessageDialog(frame, "Selecione um produto!");
                }
            }
        });

        // Layout para organização
        frame.add(scrollProdutos, BorderLayout.WEST);
        frame.add(btnAdicionar, BorderLayout.CENTER);
        frame.add(scrollCarrinho, BorderLayout.EAST);

        frame.setVisible(true);
    }

    // Método para carregar os produtos cadastrados
    private void carregarProdutos() {
        // Exemplo de produtos cadastrados
        List<String> produtos = buscarProdutosDoBanco();
        for (String produto : produtos) {
            listaProdutosModel.addElement(produto);
        }
    }

    // Simulação: buscar produtos no banco de dados
    private List<String> buscarProdutosDoBanco() {
        // Simulação de dados do banco
        List<String> produtos = new ArrayList<>();
        produtos.add("Produto 1 - R$ 10.00");
        produtos.add("Produto 2 - R$ 15.50");
        produtos.add("Produto 3 - R$ 8.90");
        produtos.add("Produto 4 - R$ 25.00");
        return produtos;
    }

    public static void main(String[] args) {
        new TelaCompra();
    }
}
