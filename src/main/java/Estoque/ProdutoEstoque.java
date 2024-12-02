/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estoque;

import Vendas.Produto;

/**
 *
 * @author Anderson S
 */
public class ProdutoEstoque {
    private Produto produto;
    private float custo;
    private String dataEntrada;
    private int quantidade;
    
    public ProdutoEstoque(Produto produto,int quantidade, float custo, String dataEntrada){
        this.custo = custo;
        this.produto = produto;
        this.quantidade = quantidade;
        this.dataEntrada = dataEntrada;
    }
    
}
