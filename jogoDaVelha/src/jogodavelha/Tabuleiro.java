package jogodavelha;


public class Tabuleiro {
    //POR PADRÃO X - HUMANO | O - COMPUTADOR
    public String posicoesTabuleiro[][] = new String[3][3];//mapa do tabuleiro
    public int numeroJogadas;
    private String marcaDoVencedor; //armazenar a marca (X ou O) 
    
    public Tabuleiro(){
        this.numeroJogadas = 0;
        iniciarPosicoes();
        this.marcaDoVencedor = "";
    }
    
    private void iniciarPosicoes(){
        //inicializa todas as posicoes
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                this.posicoesTabuleiro[i][j] = " ";
            }
        }
    }
    private void renovarTela(){
        for(int i = 0; i < 30; i++){
            System.out.println();
        }
        System.out.println("\t\tJOGO DA VELHA");
        System.out.println("X - VOCÊ | O - COMPUTADOR\n");
    }
    public void mostrarTabuleiro(){
       renovarTela(); // padroniza a tela para dar a sensação de atualização
       
       // mostra as marcações do tabuleiro e a jogada 
       for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.print(this.posicoesTabuleiro[i][j]);
                if(j<2){
                    System.out.print("|");
                }
                
            }
            if(i<2){
                System.out.println("\n-|-|-");
            }
        }
        System.out.println("\n");
    }
    public boolean verificarVitoria(){
        //Verificar possibilidade de vitoria por número de jogadas
        if(numeroJogadas < 5){
            return false;
        }
        // em caso de vitoria a variavel "marcaDoVencedor" ira armazenar a marca do jogador
        //Verificar vitoria diagonal 1 
        if(posicoesTabuleiro[0][0].equals(posicoesTabuleiro[1][1]) && posicoesTabuleiro[1][1].equals(posicoesTabuleiro[2][2]) && !(posicoesTabuleiro[1][1].equals(" "))){
            this.marcaDoVencedor = posicoesTabuleiro[0][0];
            return true;
        }
        if(posicoesTabuleiro[2][0].equals(posicoesTabuleiro[1][1]) && posicoesTabuleiro[1][1].equals(posicoesTabuleiro[0][2]) && !(posicoesTabuleiro[1][1].equals(" "))){
            this.marcaDoVencedor = posicoesTabuleiro[2][0];
            return true;
            
        }
        //loop para verificar todas as possibilidades de vitoria verticais e horizontais
        for(int i = 0; i < 3; i++){
            //Verificar vitoria VERTICAL
            if(posicoesTabuleiro[i][0].equals(posicoesTabuleiro[i][1]) && posicoesTabuleiro[i][1].equals(posicoesTabuleiro[i][2]) && !(posicoesTabuleiro[i][1].equals(" "))){
                this.marcaDoVencedor = posicoesTabuleiro[i][0];
                return true;
            }
            
            // Verificar vitoria HORIZONTAL
            if(posicoesTabuleiro[0][i].equals(posicoesTabuleiro[1][i]) && posicoesTabuleiro[1][i].equals(posicoesTabuleiro[2][i]) && !(posicoesTabuleiro[1][i].equals(" "))){
                this.marcaDoVencedor = posicoesTabuleiro[0][i];
                return true;
            }
            
        }
        return false;
    }
    
    public String status(){
        //mostrando status de atual da partida
        boolean statusVitoria = verificarVitoria();//O 2°  if é meramente para satisfazer o comando do exercício
        if(statusVitoria == false && numeroJogadas == 9){
            return "EMPATE";
        }else if(statusVitoria == false){
            return "INACABADO";
        }else{
            if(this.marcaDoVencedor == "X"){
                return "JOGADOR VENCE";
            }else{
                return "COMPUTADOR VENCE";
            }
        }
    }
    
}
