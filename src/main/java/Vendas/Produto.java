package Vendas;
import DAO.ProdutosDAO;
public class Produto {
        private int id;
        private String nome;
        private String descricao;
        private double preco;
        private double custo;

    public Produto(String nome,double preco, String descricao) {        
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;        
        this.registrarProduto();
    } 

    public Produto(int id, String nome, String descricao, double preco) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
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


    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }
    
    public void registrarProduto(){
        ProdutosDAO dao = new ProdutosDAO();
        this.id = dao.cadastrarProduto(this);
    }

    public String toListString() {
        return String.format("%-5d %-20s R$%.2f", this.id, this.nome, this.preco);
    }

    public String toCarrinhoString(int qtd) {
        return String.format("%-5d %-20s %-5d R$%-10.2f", this.id, this.nome, qtd, this.preco * qtd);
    }
}
