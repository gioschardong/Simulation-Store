public class Produto {
    private String nomeProduto;
    private double preco;
    private int quantEstocada;
    private double PrecoTotal=0; // Preço total da Compra
    private int numeroDeProdutos=0; // Quantidade de Produtos Vendidos
    
    public Produto(String id, double valor, int estoque){ //Construtor
        
        //atributos do produto
        nomeProduto=id;
        quantEstocada=estoque;
        if(valor>0)
            preco=valor;
        else{
            System.out.println("Valor de inicialização inválido. Preço iniciado com zero");
            preco=0;
        }
    }

    public String getNomeProduto(){
        return nomeProduto;
    }

    public double getPreco(){
        return preco;
    }

    public int getQuantEstocada(){
        return quantEstocada;
    }
    
    public String toString(){
        return "Produto: "+nomeProduto+" / preço: R$"+preco+ " / Estoque: "+quantEstocada;
    }

    public void maisEstoque(int MorePro){
        if(MorePro>0)
            quantEstocada=quantEstocada+MorePro; 
        else
            System.out.println("Valor de adição inválido");
    }

    public void adicionarCarrinho(int quantidadeCompra){
        PrecoTotal=0; // Preço total da Compra
        numeroDeProdutos=numeroDeProdutos+quantidadeCompra; // Quantidade de Produtos Vendidos
        if(quantEstocada<quantidadeCompra){
            System.out.println("Este Produto possui apenas "+quantEstocada+" unidades no estoque");
        }
        else{
            if(quantidadeCompra>0){
                quantEstocada=quantEstocada-quantidadeCompra;
                PrecoTotal = preco*quantidadeCompra;
            }
            else
                System.out.println("Valor de adição inválido");
        }
    }

    public double getPrecoTotal(){
        return PrecoTotal;
    }
    
    public void zerarPrecoTotal(){
        PrecoTotal=0;
    }

    public int getNumeroDeProdutos(){
        return numeroDeProdutos;
    }
}

    public void maisEstoque(int MorePro){
        if(MorePro>0)
            quantEstocada=quantEstocada+MorePro; 
        else
            System.out.println("Valor de adição inválido");
    }

    public void adicionarCarrinho(int quantidadeCompra){
        PrecoTotal=0; // Preço total da Compra
        numeroDeProdutos=numeroDeProdutos+quantidadeCompra; // Quantidade de Produtos Vendidos
        if(quantidadeCompra>0){
            quantEstocada=quantEstocada-quantidadeCompra;
            PrecoTotal = preco*quantidadeCompra;
        }
        else
            System.out.println("Valor de adição inválido");
    }

    public double getPrecoTotal(){
        return PrecoTotal;
    }
    
    public void zerarPrecoTotal(){
        PrecoTotal=0;
    }

    public int getNumeroDeProdutos(){
        return numeroDeProdutos;
    }
}
