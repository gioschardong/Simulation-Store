import java.util.Scanner;
public class P_Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Loja minhaLoja = new Loja();
        
        int escolha;

        int MorePro; // Adicionar ao Estoque
        double valor; //Preço
        String id; // Nome
        int estoque; // Valor estocado
        int quantidadeCompra; // Quantidade de produtos a ser comprada

        do{
            escolha=menuLoja();
        
            switch(escolha){
                case 1:
                    System.out.println(" \n --> Cadastrar Produto \n");
                    System.out.print("   Informe um Nome para o Produto: ");
                    id=in.nextLine(); //Inserir nome
                    System.out.print("   Informe um preço: ");
                    valor = Double.parseDouble(in.nextLine()); // Inserir Preço
                    System.out.print("   Informe a Quantidade Estocada: ");
                    estoque = Integer.parseInt(in.nextLine()); // Inserir quantidade estocada
                    minhaLoja.cadastraProduto(id, valor, estoque);
                    break;
                case 2:
                    escolha=menuVisu();
                    switch(escolha){
                        case 1: // Todos os produtos
                            minhaLoja.todosProdutos();
                            break;
                        case 2: // Produtos em estoque
                            minhaLoja.produtosEmEstoque();
                            break;
                        case 3: // Produtos fora de estoque
                            minhaLoja.foraDeEstoque();
                            break;
                    }
                    break;
                case 3:
                    System.out.println("\n--> Adicionar ao estoque\n");
                    System.out.print("Informe o Produto:");
                    String nomeProduto = in.nextLine(); // Selecionar Produto
                    Produto umProduto = minhaLoja.pesquisaProduto(nomeProduto);
                    if(umProduto!=null){
                        System.out.println("\n--> Dados do Produto");
                        System.out.println(umProduto.toString()); // Mostrar dados do Produto
                        System.out.print("\nAdicionar unidades ao Estoque: ");
                        MorePro = in.nextInt(); //Quantidade de produtos a serem adicionadas
                        umProduto.maisEstoque(MorePro);
                    }
                    else{
                        System.out.println("O produto "+nomeProduto+" não foi encontrado");
                    }
                    break;
                case 4:
                    escolha=menuCompra();
                    switch(escolha){
                        case 1:
                            minhaLoja.produtosEmEstoque();
                            System.out.print("Informe o Produto: ");
                            nomeProduto = in.nextLine(); // Selecionar Produto
                            umProduto = minhaLoja.pesquisaProduto(nomeProduto);
                            if(umProduto!=null){
                                System.out.print("\nAdicionar unidades ao Carrinho: ");
                                quantidadeCompra = Integer.parseInt(in.nextLine()); //Quantidade de produtos a serem adicionadas
                                umProduto.adicionarCarrinho(quantidadeCompra);
                            }
                            else{
                                System.out.println("O produto "+nomeProduto+" não foi encontrado");
                            }
                            break;
                        case 2:
                            System.out.println("O total a pagar de sua compra é: R$ "+ minhaLoja.PrecoTotal());
                            minhaLoja.zerarCarrinho();
                            break;
                    } 
                    break;
                case 5:
                    escolha=menuControle();
                    switch(escolha){
                        case 1:
                            System.out.println("Foram vendidos "+minhaLoja.QuantidadeTotal()+" Produtos");
                            break;
                        case 2:
                            System.out.println("\nForam realizadas "+minhaLoja.getNumerodeVendas()+" Vendas");
                            break;
                        case 3:
                            System.out.printf("O valor total das vendas foi de: R$ %.2f",minhaLoja.getTotalDasVendas());
                            break;
                        case 4:
                            System.out.printf("O valor médio das vendas foi de: R$ %.2f",minhaLoja.getMediaDasVendas());
                            break;
                    }
            }
        }while(escolha!=0);
    }

    public static int menuLoja(){
        int opcao;
        Scanner usr = new Scanner(System.in);
        do{
            System.out.println("\n=-=-=-==-==-=-=-=-=-=-=-=-=-=--=-=-=-=-=");
            System.out.println("|            Menu de opcoes            |");
            System.out.println("| 1 - Cadastrar Produto                |");
            System.out.println("| 2 - Visualizar Produtos              |");
            System.out.println("| 3 - Incluir Produtos no Estoque      |");
            System.out.println("| 4 - Realizar Compra                  |");
            System.out.println("| 5 - Controle Financeiro              |");
            System.out.println("| 0 - Sair                             |");
            System.out.println("=-=-=-==-==-=-=-=-=-=-=-=-=-=--=-=-=-=-=\n");
            System.out.print("Escolha a opcao: ");
            opcao = usr.nextInt();
        }while(opcao<0 || opcao>5);
        return opcao;
    }

    public static int menuVisu(){
        int opcao;
        Scanner usr = new Scanner(System.in);
        do{
            System.out.println("\n=-=-=-==-==-=-=-=-=-=-=-=-=-=--=-=-=-=-=");
            System.out.println("|         Menu de Visualização         |");
            System.out.println("|  1 - Todos os Produtos               |");
            System.out.println("|  2 - Produtos em  estoque            |");
            System.out.println("|  3 - Produtos fora de estoque        |");
            System.out.println("=-=-=-==-==-=-=-=-=-=-=-=-=-=--=-=-=-=-=\n");
            System.out.print("Escolha a opcao: ");
            opcao = usr.nextInt();
        }while(opcao<1 || opcao>3);
        return opcao;
    }

    public static int menuCompra(){
        int opcao;
        Scanner usr = new Scanner(System.in);
        do{
            System.out.println("\n=-=-=-==-==-=-=-=-=-=-=-=-=-=--=-=-=-=-=");
            System.out.println("|            Menu de Compra            |");
            System.out.println("|  1 - Adicionar Produtos ao Carrinho  |");
            System.out.println("|  2 - Finalizar Compra                |");
            System.out.println("=-=-=-==-==-=-=-=-=-=-=-=-=-=--=-=-=-=-=\n");
            System.out.print("Escolha a opcao: ");
            opcao = usr.nextInt();
        }while(opcao<1 || opcao>2);
        return opcao;
    }

    public static int menuControle(){
        int opcao;
        Scanner usr = new Scanner(System.in);
        do{
            System.out.println("\n=-=-=-==-==-=-=-=-=-=-=-=-=-=--=-=-=-=-=");
            System.out.println("|           Menu de Controle           |");
            System.out.println("|  1 - Quantidade de produtos vendidos |");
            System.out.println("|  2 - Quantidade de Vendas            |");
            System.out.println("|  3 - O valor total das vendas        |");
            System.out.println("|  4 - O valor médio das vendas        |");
            System.out.println("=-=-=-==-==-=-=-=-=-=-=-=-=-=--=-=-=-=-=\n");
            System.out.print("Escolha a opcao: ");
            opcao = usr.nextInt();
        }while(opcao<1 || opcao>4);
        return opcao;
    }

