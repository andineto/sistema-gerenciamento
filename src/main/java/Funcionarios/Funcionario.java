package Funcionarios;

import DAO.FuncionariosDAO;
import java.text.DecimalFormat;

public class Funcionario {
        private int id;
        private String nome;
        private double salario;
        private String cpf;
        private double salarioLiquido;

    public Funcionario(String nome, String cpf, double salario) {
        this.nome = nome;
        this.salario = salario;
        this.cpf = cpf;
        this.salarioLiquido = this.calculoTrabalhista(salario);
    }

    public Funcionario(int id, String nome, String cpf, double salario, double salarioLiquido) {
        this.id = id;
        this.nome = nome;
        this.salario = salario;
        this.cpf = cpf;
        this.salarioLiquido = salarioLiquido;
    }
    
    
    public double calculoTrabalhista(double salarioBruto) {
        double inss;
        double salarioTributavel;
        double ir;
        double salarioLiquido;
        
        //inss
        if (salarioBruto <= 1412.00) {
            inss = salarioBruto * 0.075;
     
        } else if (salarioBruto <= 2666.68 && salarioBruto >= 1412.01) {
            inss = salarioBruto * 0.09 - 21.18; 

        } else if (salarioBruto <= 4000.03 && salarioBruto >= 2666.69) {
            inss = salarioBruto * 0.12 - 101.18;

        } else if(salarioBruto >= 4000.04 && salarioBruto <= 7786.03) {
            inss = salarioBruto * 0.14 - 181.18;

        } else {
            inss = 908.85;
        }
        
        salarioTributavel = salarioBruto - inss;
        
        //Imposto de renda
        if (salarioTributavel <= 2112.00) {
            ir = 0.0;
        } else if (salarioTributavel <= 2826.65 && salarioTributavel >= 2112.01) {
            ir = (salarioTributavel) * 0.075 - 158.00 ;
        } else if (salarioTributavel <= 3751.06 && salarioTributavel >= 2826.67) {
            ir = (salarioTributavel) * 0.15 - 370.40;
        } else if (salarioTributavel <= 4664.68 && salarioTributavel >= 3751.07) {
            ir = (salarioTributavel) * 0.225 - 651.73;
        } else {
            ir = (salarioTributavel) * 0.275 - 884.96;
        }
        
        DecimalFormat df = new DecimalFormat("#.00");
        String impostoRenda = df.format(ir);
        String descontoInss = df.format(inss);
        
        salarioLiquido = salarioTributavel - ir;
        
        System.out.println("O valor a ser pago de inss: " + descontoInss);
        System.out.println("O valor do imposto de renda: " + impostoRenda);
        
        return salarioLiquido;
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

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getSalarioLiquido() {
        return salarioLiquido;
    }

    public void setSalarioLiquido(double salarioLiquido) {
        this.salarioLiquido = salarioLiquido;
    }

    public void registrarFuncionario() {
        FuncionariosDAO fd = new FuncionariosDAO();
        this.id = fd.adicionarFuncionario(this);
        
    }
    
    
}
