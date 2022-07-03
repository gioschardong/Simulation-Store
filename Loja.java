public class Loja {
    private int nProdutos;
    private Produto [] listaPro = new Produto[100];
    private int numeroDeVendas=0; // Quantidades de vendas da loja
    private double totalVendas=0; // Valor total das vendas
    private double mediaVendas=0; // Valor medio das vendas

    public boolean cadastraProduto(String id, double valor, int estoque){
        if(nProdutos<100){
            listaPro[nProdutos] = new Produto(id, valor, estoque);
            nProdutos++;
            return true;
        }
        else
            return false;
    }

    public void todosProdutos(){
        if(nProdutos==0)
            System.out.println("Não há Produtos cadastrados\n");
        else
        {
            System.out.println("\nHá "+nProdutos+" produtos cadastrados");
            for(int pos=0; pos<nProdutos; pos++)
                System.out.printf("     Produto_%02d (%s): R$ %.2f / Quantidade Estocada: %02d\n", pos, listaPro[pos].getNomeProduto(), listaPro[pos].getPreco(), listaPro[pos].getQuantEstocada());
        }
    }

    public void produtosEmEstoque(){
        if(nProdutos==0)
            System.out.println("Não há Produtos cadastrados\n");
        else{
            for(int pos=0; pos<nProdutos; pos++){
                if(listaPro[pos].getQuantEstocada()!=0){
                    System.out.printf("     Produto_%02d (%s): R$ %.2f / Quantidade Estocada: %02d\n", pos, listaPro[pos].getNomeProduto(), listaPro[pos].getPreco(), listaPro[pos].getQuantEstocada());
                }
            }
        }
    }

    public void foraDeEstoque(){
        if(nProdutos==0)
            System.out.println("Não há Produtos cadastrados\n");
        else{
            for(int pos=0; pos<nProdutos; pos++){
                if(listaPro[pos].getQuantEstocada()==0){
                    System.out.printf("     Produto_%02d (%s): R$ %.2f / Quantidade Estocada: %02d\n", pos, listaPro[pos].getNomeProduto(), listaPro[pos].getPreco(), listaPro[pos].getQuantEstocada());
                }
            }
        }
    }

    public Produto pesquisaProduto(String id){
        Produto resultado = null;
        if(nProdutos==0)
            System.out.println("Não há Produtos cadastrados\n");
        else{
        for(int pos=0; pos<listaPro.length; pos++)
            if(listaPro[pos]!=null){
                if(listaPro[pos].getNomeProduto().toUpperCase().contains(id.toUpperCase()))
                    return listaPro[pos];
            }
        }
        return resultado;
    }

    public double PrecoTotal(){
        double Total_a_Pagar=0;

        for(int pos=0; pos<listaPro.length; pos++){
            if(listaPro[pos]!=null){
                Total_a_Pagar=Total_a_Pagar+listaPro[pos].getPrecoTotal();
            }
        }

        totalVendas = totalVendas + Total_a_Pagar;


        return Total_a_Pagar;
    }

    public void zerarCarrinho(){
        for(int pos=0; pos<listaPro.length; pos++){
            if(listaPro[pos]!=null){
                listaPro[pos].zerarPrecoTotal();
            }
        }
        numeroDeVendas++;
    }

    public int getNumerodeVendas(){
        return numeroDeVendas;
    }

    public double QuantidadeTotal(){
        double totalProduto=0;

        for(int pos=0; pos<listaPro.length; pos++){
            if(listaPro[pos]!=null){
                totalProduto=totalProduto+listaPro[pos].getNumeroDeProdutos();
            }
        }

        return totalProduto;
    }

    public double getTotalDasVendas(){
        return totalVendas;
    }

    public double getMediaDasVendas(){
        if(numeroDeVendas==0){
            System.out.println("Nenhuma venda foi realizada ainda");
        }
        else{
            mediaVendas = totalVendas/numeroDeVendas;
        }
        return mediaVendas;
    }
}
