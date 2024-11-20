package Vendas;
import DAO.ProdutosDAO;
public class Produto {
        private int id;
        private String nome;
        private String descricao;
        private double preco;
        private int quantidade;
        private double custo;

    public Produto(String nome,double preco, String descricao) {        
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;        
        this.registrarProduto();
    } 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }
    
    public void registrarProduto(){
        ProdutosDAO dao = new ProdutosDAO();
        dao.adicionarProduto(this);
    }
}
