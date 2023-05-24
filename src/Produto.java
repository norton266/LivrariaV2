import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Produto {
    Scanner input = new Scanner(System.in);
    String titulo, editora, area;
    int codigo, ano, qtdEstoque;
    double valorEstoque, valor;

    Produto(int codigo, String titulo, int ano, String area, String editora, double valor, int qtdEstoque) {
        this.titulo = titulo;
        this.editora = editora;
        this.area = area;
        this.codigo = codigo;
        this.ano = ano;
        this.valor = valor;
        this.qtdEstoque = qtdEstoque;
        this.valorEstoque = 0;

        calculaValorEstoque();

    }
    public void calculaValorEstoque(){
        this.valorEstoque = this.qtdEstoque * this.valor;
    }

    public void info(){
        System.out.println("");
        System.out.println(">>>>>Cod#" +this.codigo);
        System.out.println("Título/Editora: "+this.titulo+"/"+this.editora);
        System.out.println("Categoria: "+this.area);
        System.out.println("Ano: "+this.ano);
        System.out.println("Valor: R$ "+this.valor);
        System.out.println("Estoque: "+this.qtdEstoque+" unidades.");
        System.out.println("Valor total em estoque: R$ "+this.valorEstoque);
    }

    public int buscaTitulo(String nome, int control){
        if(this.titulo.contains(nome)){
            info();
            control++;
        }
        return control;
    }

    public int buscaArea(String categoria, int control){
        if(this.area.equals(categoria)){
            info();
            control++;
        }
        return control;
    }
    public int buscaPreco(double preco, int control){
        if(this.valor <= preco){
            info();
            control++;
        }
        return control;
    }

    public int buscaEstoque(int estoque, int control){
        if(this.qtdEstoque <= estoque){
            info();
            control++;
        }
        return control;
    }
    public int buscaValorEstoque(double valorTotalEstoque, int control){
        if(this.valorEstoque > valorTotalEstoque){
            info();
            control++;
        }
        return control;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public void setValorEstoque(double valorEstoque) {
        this.valorEstoque = valorEstoque;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getEditora() {
        return editora;
    }

    public String getArea() {
        return area;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getAno() {
        return ano;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public double getValorEstoque() {
        return valorEstoque;
    }

    public double getValor() {
        return valor;
    }

}
