import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class Livraria {
    public static ArrayList<Produto> arrayProduto = new ArrayList<Produto>();
    public static void main (String[] args) throws Exception{
        FileInputStream arquivo = new FileInputStream("src/livros.txt");
        Scanner entradaTexto = new Scanner(arquivo);
        Scanner input = new Scanner(System.in);
        String [] SL;
        String linha;

        while(entradaTexto.hasNextLine() == true){
            linha = entradaTexto.nextLine();
            SL = linha.split(",");

            Produto produto = new Produto(Integer.parseInt(SL[0]), SL[1], Integer.parseInt(SL[2]), SL[3], SL[4], Double.parseDouble(SL[5]), Integer.parseInt(SL[6]));
            arrayProduto.add(produto);

        }

        int opcao = 999;
        while(opcao != 0){
            System.out.println();
            System.out.println("Digite a opção desejada: ");
            System.out.println("1 - Cadastrar novo livro.");
            System.out.println("2 - Listar livros.");
            System.out.println("3 - Buscar livros por nome.");
            System.out.println("4 - Buscar livros por categoria.");
            System.out.println("5 - Buscar livros por preço.");
            System.out.println("6 - Busca por quantidade em estoque.");
            System.out.println("7 - Busca por valor no estoque.");
            System.out.println("8 - Valor total no estoque.");
            System.out.println("9 - Atualizar arquivo de estoque.");
            System.out.println("0 - Encerrar.");

            opcao = input.nextInt();

            if(opcao == 0){
                System.out.println("Salvar alterações em arquivo? (1 - Sim | 2 -  Não)");
                int salvar = 0;
                salvar = input.nextInt();
                if(salvar == 1){
                    atualizarArquivo(arrayProduto);
                }
            }

            switch (opcao){
                case 1:
                    novoProduto();
                    break;
                case 2:
                    listarProduto();
                    break;
                case 3:
                    buscarNome();
                    break;
                case 4:
                    buscarArea();
                    break;
                case 5:
                    buscarPreco();
                    break;
                case 6:
                    buscarEstoque();
                    break;
                case 7:
                    buscarValorEstoque();
                    break;
                case 8:
                    calcularValorEstoque();
                    break;
                case 9:
                    atualizarArquivo(arrayProduto);
                    break;
                default:
                    System.out.println("Digite uma opção válida!");
            }

        }
    }

    public static void atualizarArquivo(ArrayList<Produto> arrayProduto){
        String nomeArquivo = "src/livros.txt";

        try {
            FileWriter gravaArquivo = new FileWriter(nomeArquivo);
            BufferedWriter escreveArquivo = new BufferedWriter(gravaArquivo);

            for (Produto produto : arrayProduto) {
                // Escreve as informações do produto no arquivo
                escreveArquivo.write(produto.getCodigo() + "," + produto.getTitulo() + "," + produto.getAno() + "," + produto.getArea() + "," + produto.getEditora() + "," + produto.getValor() + "," + produto.getQtdEstoque());
                escreveArquivo.newLine();
            }

            escreveArquivo.close();
            System.out.println("As informações foram gravadas no arquivo com sucesso.");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao gravar as informações no arquivo.");
            e.printStackTrace();
        }
    }

    public static void novoProduto (){
        Scanner input = new Scanner(System.in);
        String titulo, editora, area;
        int codigo, ano, qtdEstoque;
        double valor;

        System.out.println("");
        System.out.println("Digite o título do livro: ");
        input.useDelimiter("\n");
        titulo = input.next();
        System.out.println("Digite a editora do livro: ");
        editora = input.next();
        System.out.println("Digite a area(categoria) do livro: ");
        area = input.next();
        System.out.println("Digite o codigo do livro: ");
        codigo = input.nextInt();
        System.out.println("Digite o ano do livro: ");
        ano = input.nextInt();
        System.out.println("Digite a quantidade em estoque: ");
        qtdEstoque = input.nextInt();
        System.out.println("Digite o valor do livro: ");
        valor = input.nextDouble();

        Produto produto = new Produto(codigo,titulo,ano,area,editora,valor,qtdEstoque);
        arrayProduto.add(produto);

    }

    public static void listarProduto(){
        for(int i = 0; i < arrayProduto.size(); i++){
            arrayProduto.get(i).info();
        }
    }

    public static void buscarNome(){
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o nome do livro que quer buscar: ");
        input.useDelimiter("\n");
        String nome = input.next();
        int control = 0;

        //preciso usar esse for pra poder usar o .produto.buscaNome
        for(Produto produto: arrayProduto){
            control = produto.buscaTitulo(nome, control);
        }
        if(control == 0){
            System.out.println("Livro não encontrado!");
        }
    }
    public static void buscarArea(){
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o nome do livro que quer buscar: ");
        input.useDelimiter("\n");
        String categoria = input.next();
        int control = 0;

        //preciso usar esse for pra poder usar o .produto.buscaArea
        for(Produto produto: arrayProduto){
            control = produto.buscaArea(categoria, control);
        }
        if(control == 0){
            System.out.println("Categoria não encontrada!");
        }
    }
    public static void buscarPreco(){
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o valor máximo que deseja buscar: ");
        input.useDelimiter("\n");
        double preco = input.nextDouble();
        int control = 0;

        //preciso usar esse for pra poder usar o .produto.buscaPreco
        for(Produto produto: arrayProduto){
            control = produto.buscaPreco(preco, control);
        }
        if(control == 0){
            System.out.println("Nenhum livro nessa faixa de preço!");
        }
    }
    public static void buscarValorEstoque(){
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o valor máximo que deseja buscar: ");
        input.useDelimiter("\n");
        double valorTotalEstoque = input.nextDouble();
        int control = 0;

        //preciso usar esse for pra poder usar o .produto.buscaValorEstoque
        for(Produto produto: arrayProduto){
            control = produto.buscaValorEstoque(valorTotalEstoque, control);
        }
        if(control == 0){
            System.out.println("Nenhum livro nessa faixa de valor de estoque!");
        }
    }
    public static void buscarEstoque(){
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o valor máximo que deseja buscar: ");
        input.useDelimiter("\n");
        int estoque = input.nextInt();
        int control = 0;

        //preciso usar esse for pra poder usar o .produto.buscaEstoque
        for(Produto produto: arrayProduto){
            control = produto.buscaEstoque(estoque, control);
        }
        if(control == 0){
            System.out.println("Nenhum livro nessa faixa de preço!");
        }
    }
    public static void calcularValorEstoque(){
        double valor = 0;

        for(Produto produto: arrayProduto){
            valor += produto.getValorEstoque();
        }
        System.out.println("Valor total em estoque: R$ " + valor);
    }
}
