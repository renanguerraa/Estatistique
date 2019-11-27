import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Estatisque {
   
    public static void main(String[] args) throws IOException {
       
        Scanner tc = new Scanner(System.in);
       
        int quantDados, testeModa = 0;
   
        double media = 0.0, modaQtd = 1, modaNum = 0;  
        double mediana, mediana1, mediana2;
        double amplitude = 0, dp = 0, variancia = 0;
       
        //data
        Calendar data = Calendar.getInstance();
       
        //horario
        SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss");
        Date hora = Calendar.getInstance().getTime();
       
        int op = 0, op2 = 0;
        int a, b, c, d, l, f, g, h;
       
        do{
            a = 0; b = 0; c = 0; d = 0; l = 0; f = 0; g = 0; h = 0;
           
            System.out.println("Digite o titulo: ");
            String titulo = tc.nextLine();
           
            System.out.println("");

            System.out.println("Deseja fazer o calculo sobre quantos dados? "); // limite 50
            quantDados = tc.nextInt();
           
            while(quantDados > 50 || quantDados <= 1){
                System.out.println("\n" + "O limite de dados permitidos é 50, digite um valor abaixo ou igual a 50!"); // limite 50
                quantDados = tc.nextInt();
            }
           
            double dados[] = new double[quantDados];
           
            mediana1 = dados[(dados.length/2)-1];
            mediana2 = dados[dados.length/2];
            mediana = mediana1 + mediana2;
            int vetorModa1[] = {};
            double vetorNum1[] = {};
            double vetorModa2[] = {};
            double vetorNum2[] = {};
           
            System.out.println("");

            for (int cont = 0; cont < dados.length; cont++) {
               
                System.out.println("Valor do dado "+ (cont + 1) +": ");
                dados[cont] = tc.nextDouble();
               
                System.out.println("");
            }
           
            do{
               
                System.out.println("\nDeseja fazer o que com esses dados? \n"
                        + "1- Media \n"
                        + "2- Moda \n"
                        + "3- Mediana \n"
                        + "4- Frequencia Absoluta \n"
                        + "5- Frequencia Relativa \n"
                        + "6- Amplitude \n"
                        + "7- Desvio Padrão \n"
                        + "8- Variancia \n"
                        + "0- Sair");    
                op = tc.nextInt();
               
                System.out.println("");
           
                switch(op){
                   
                    case 1:{ a++;
                       
                        double numeros = 0;
                       
                        for(int cont = 0; cont < dados.length; cont++){
                           
                            numeros += dados[cont];
                            media = numeros/dados.length;
                        }
                       
                        System.out.println("A media é: "+ media);
                        break;
                    }
                   
                    case 2:{ b++;
                       
                        //ordenação do vetor
                        double aux;
                       
                        for (int cont1 = 0; cont1 < dados.length; cont1++)
                        {
                            for (int cont2 = 0; cont2 < dados.length; cont2++)
                            {
                                if (dados[cont1] < dados[cont2])
                                {
                                    aux = dados[cont1];
                                    dados[cont1] = dados[cont2];
                                    dados[cont2] = aux;
                                }
                            }
                        }
                       
                        // descobrindo a moda
                        int vetorModa[] = new int[dados.length];
                        double vetorNum[] = new double[dados.length];
                        double numTeste;
                        int contTeste;
                        int numRepetido;
                       
                       
                        for (int cont1 = 0; cont1 < dados.length; cont1++)
                        {
                            numRepetido = 0;
                            contTeste = 0;
                            numTeste = dados[cont1];
                           
                            for(int cont3 = 0; cont3<dados.length; cont3++)
                            {
                                if(numRepetido != 1){
                                    if(numTeste == vetorNum[cont3]){
                                        numRepetido = 1;
                                    }
                                }
                                else cont3 = dados.length -1;
                            }
                           
                            if(numRepetido != 1)
                            {
                                for (int cont2 = 0; cont2 < dados.length; cont2++)
                                {
                                    if(numTeste == dados[cont2])
                                    {
                                        contTeste += 1;
                                    }
                                }
                                vetorModa[cont1] = contTeste;
                                vetorNum[cont1] = numTeste;
                            }
                        }
                       
                        for(int cont4 = 0; cont4<vetorModa.length; cont4++){
                            if(vetorModa[cont4] > modaQtd)
                            {
                                modaQtd = vetorModa[cont4];
                                modaNum = vetorNum[cont4];
                                testeModa = 1;
                            }
                        }
                       
                        if(testeModa == 1) // result moda
                        {
                            System.out.println("Moda: "+ modaNum);
                            System.out.println("Quatidade de repetições: "+ modaQtd );
                        }
                        else
                        {
                            System.out.println("Dados amodais");
                        }
                           
                       
                        break;
                    }
                   
                    case 3:{ c++;
                       
                        double aux;
                        for (int cont1 = 0; cont1 < dados.length; cont1++)
                        {
                            for (int cont2 = 0; cont2 < dados.length; cont2++)
                            {
                                if (dados[cont1] < dados[cont2])
                                {
                                    aux = dados[cont1];
                                    dados[cont1] = dados[cont2];
                                    dados[cont2] = aux;
                                }
                            }
                        }
                       
                        if(dados.length % 2 == 0){
                            mediana = (dados[(dados.length/2)]) + (dados[(dados.length/2)]-1);
                            System.out.println("Mediana: "+mediana/2);
                        }
                        else if (dados.length % 2 == 1){
                            mediana = dados[(dados.length/2)];
                            System.out.println("Mediana: "+mediana);
                        }
                        break;
                    }
                   
                    case 4:{ d++;
                       
                        //ordenação do vetor
                        double aux;
                        for (int cont1 = 0; cont1 < dados.length; cont1++)
                        {
                            for (int cont2 = 0; cont2 < dados.length; cont2++)
                            {
                                if (dados[cont1] < dados[cont2])
                                {
                                    aux = dados[cont1];
                                    dados[cont1] = dados[cont2];
                                    dados[cont2] = aux;
                                }
                            }
                        }
                       
                        // descobrindo a moda
                        vetorModa1 = new int[dados.length];
                        vetorNum1 = new double[dados.length];
                        double numTeste;
                        int contTeste;
                        int numRepetido;
                       
                       
                        for (int cont1 = 0; cont1 < dados.length; cont1++)
                        {
                            numRepetido = 0;
                            contTeste = 0;
                            numTeste = dados[cont1];
                           
                            for(int cont3 = 0; cont3<dados.length; cont3++)
                            {
                                if(numRepetido != 1){
                                    if(numTeste == vetorNum1[cont3]){
                                        numRepetido = 1;
                                    }
                                }
                                else cont3 = dados.length -1;
                            }
                           
                            if(numRepetido != 1)
                            {
                                for (int cont2 = 0; cont2 < dados.length; cont2++)
                                {
                                    if(numTeste == dados[cont2])
                                    {
                                        contTeste += 1;
                                    }
                                }
                                vetorModa1[cont1] = contTeste;
                                vetorNum1[cont1] = numTeste;
                                System.out.println("Dado: " + vetorNum1[cont1]);  
                                System.out.println("Frequencia Absoluta: " + vetorModa1[cont1]);
                            }
                        }
                       
                        break;
                    }
                   
                    case 5:{ l++;
                       
                        //ordenação do vetor
                        double aux;
                        for (int cont1 = 0; cont1 < dados.length; cont1++)
                        {
                            for (int cont2 = 0; cont2 < dados.length; cont2++)
                            {
                                if (dados[cont1] < dados[cont2])
                                {
                                    aux = dados[cont1];
                                    dados[cont1] = dados[cont2];
                                    dados[cont2] = aux;
                                }
                            }
                        }
                       
                        // descobrindo a moda
                        vetorModa2 = new double[dados.length];
                        vetorNum2 = new double[dados.length];
                        double numTeste;
                        int contTeste;
                        int numRepetido;
                       
                       
                        for (int cont1 = 0; cont1 < dados.length; cont1++)
                        {
                            numRepetido = 0;
                            contTeste = 0;
                            numTeste = dados[cont1];
                           
                            for(int cont3 = 0; cont3<dados.length; cont3++)
                            {
                                if(numRepetido != 1){
                                    if(numTeste == vetorNum2[cont3]){
                                        numRepetido = 1;
                                    }
                                }
                                else cont3 = dados.length -1;
                            }
                           
                            if(numRepetido != 1)
                            {
                                for (int cont2 = 0; cont2 < dados.length; cont2++)
                                {
                                    if(numTeste == dados[cont2])
                                    {
                                        contTeste += 1;
                                    }
                                }
                                vetorModa2[cont1] = contTeste;
                                vetorNum2[cont1] = numTeste;
                                System.out.println("Dado: " + vetorNum2[cont1]);  
                                System.out.println("Frequencia Relativa: " + (vetorModa2[cont1]*100)/dados.length+"%");
                            }
                        }
                       
                        break;          
                    }
                   
                    case 6:{ f++;
                        double aux;
                        for (int cont1 = 0; cont1 < dados.length; cont1++)
                        {
                            for (int cont2 = 0; cont2 < dados.length; cont2++)
                            {
                                if (dados[cont1] < dados[cont2])
                                {
                                    aux = dados[cont1];
                                    dados[cont1] = dados[cont2];
                                    dados[cont2] = aux;
                                }
                            }
                        }
                       
                        double menor = dados[0];
                        double maior = dados[(dados.length)-1];
                       
                        amplitude = maior - menor;
                       
                        System.out.println("Amplitude: "+ amplitude);
                        break;
                    }
                   
                    case 7:{ g++;
                       
                        double numeros = 0;
                        for(int cont=0; cont<dados.length; cont++){
                            numeros += dados[cont];
                        }
                        double media2 = numeros/dados.length;
                        double x = 0.0;
                        for(int cont=0; cont<dados.length; cont++){
                            x += Math.pow((dados[cont] - media2), 2);
                        }
                        dp = Math.sqrt((x)/dados.length);
                        System.out.println("Desvio padrão: "+ dp);
                       
                        break;
                    }
                   
                    case 8:{ h++;
                       
                        double numeros = 0;
                        for(int cont=0; cont < dados.length; cont++){
                            numeros += dados[cont];
                        }
                        double media2 = numeros / dados.length;
                        variancia = 0.0;
                        for(int cont=0; cont<dados.length; cont++){
                            variancia += Math.pow((dados[cont] - media2), 2);
                        }
                       
                        variancia = variancia/dados.length;
                        System.out.println("Variancia: "+ variancia);
                        break;
                    }
                }
            }while(op != 0);
               
                System.out.println("Deseja salvar? \n"
                        + "1- Sim \n"
                        + "2- Não");
                int salvar = tc.nextInt();
         
                tc.nextLine();
               
                if(salvar == 1){
                   
                    FileWriter fw = new FileWriter("C:\\relatorio.txt", true);            
                    PrintWriter pw = new PrintWriter(fw);
                   
                    pw.printf("----------------------------------- \n");
                    pw.printf(formato.format(hora) +" - "+ data.get(Calendar.DAY_OF_MONTH)+"/"+(data.get(Calendar.MONTH)+1)+"/"+data.get(Calendar.YEAR)+ "\n");
                    pw.printf("----------------------------------- \n");
                   
                    pw.printf(titulo +"\n\n");
                   
                    pw.printf("Dados = {");
                           
                    for(int i = 0; i < dados.length; i++){
                       
                        pw.printf(dados[i] +", ");
                    }
                   
                    pw.printf("}\n\n");
                   
                    // media
                    if(a > 0){
                        pw.printf(String.valueOf("A média (Me) é calculada somando-se todos os valores de um conjunto de dados e dividindo-se pelo número de elementos deste conjunto.\n"));
                        pw.printf(String.valueOf("A formula da média é Me = Soma de termos / nº de termos \n"));
                        pw.printf(String.valueOf("Logo a media dos dados apresentados é: "+ media +"\n\n"));
                    }
                   
                    // moda
                    if(b > 0){
                        pw.printf("A Moda (Mo) representa o valor mais frequente de um conjunto de dados, sendo assim, para defini-la basta observar a frequência com que os valores aparecem. \n");
                        if(testeModa == 1)
                        {
                            pw.printf("Logo a moda dos dados apresentados é: "+ modaNum + "\n");
                            pw.printf("Quatidade de repetições: "+ modaQtd +"\n\n");
                        }
                        else
                        {
                            pw.printf("A moda dos dados apresentados é: Dados amodais \n\n");
                        }
                    }
                   
                    // mediana
                    if(c > 0){
                        if(dados.length % 2 == 0){

                            pw.printf("A Mediana (Md) representa o valor central de um conjunto de dados. Para encontrar o valor da mediana é necessário colocar os valores em ordem crescente ou decrescente.\n");
                            pw.printf("Logo a mediana dos dados apresentados é: "+ mediana/2 +"\n\n");
                        }
                        else if (dados.length % 2 == 1){

                            pw.printf("A Mediana (Md) representa o valor central de um conjunto de dados. Para encontrar o valor da mediana é necessário colocar os valores em ordem crescente ou decrescente.\n");
                            pw.printf("Logo a mediana dos dados apresentados é: "+ mediana +"\n\n");
                        }
                    }
                   
                    // FA
                    if(d > 0){
                        
                        pw.printf("A frequência absoluta corresponde à quantidade de ocorrências de um mesmo resultado \n");
                        
                        for(int cont1 = 0; cont1 < dados.length; cont1++){
                     
                            pw.printf("O dado apresentado foi: "+ String.valueOf(vetorNum1[cont1]) +"\n");
                            pw.printf("A frequencia absoluta desse dado apresentado é: "+ String.valueOf(vetorModa1[cont1]) +"\n\n");
                        }    
                    }
                   
                    // FR
                    if(l > 0){
                        
                        pw.printf("Em estatística denomina-se frequência relativa o resultado obtido da divisão entre a frequência absoluta - o valor que é observado na população - e a quantidade de elementos da amostra. Geralmente é apresentada na forma de porcentagem. \n");
                        
                        for(int cont1 = 0; cont1 < dados.length; cont1++){
                            if(vetorNum2[cont1] != 0){
                  
                                pw.printf("O dado apresentado foi: "+ String.valueOf(vetorNum2[cont1]) +"\n");
                                pw.printf("A frequencia relativa desse dado apresentado é: " + String.valueOf((vetorModa2[cont1]*100)/dados.length)+"%%\n\n");;
                            }
                        }
                    }

                    // ampli
                    if(f > 0){
                        pw.printf(String.valueOf("Em um conjunto de informações numéricas, a primeira medida de tendência central é chamada amplitude e é obtida a partir da diferença entre a maior informação da lista e a menor\n"));
                        pw.printf(String.valueOf("Amplitude: "+ amplitude +"\n\n"));
                    }
                   
                    // desvio p
                    if(g > 0){
                        pw.printf(String.valueOf("O desvio padrão é uma medida que indica a dispersão dos dados dentro de uma amostra com relação à média (se o dado está desviado muito acima da media ou muito abaixo). \n"));
                        pw.printf(String.valueOf("O desvio padrão dos dados apresentados é: "+ dp +"\n\n"));
                    }
                   
                    // variancia
                    if(h > 0){
                        pw.printf(String.valueOf("variância é uma medida de dispersão que mostra o quão distante cada valor desse conjunto está do valor central (quanto o dado esta acima da media ou abaixo). \n"));
                        pw.printf(String.valueOf("A variancia dos dados apresentado é: "+ variancia +"\n\n"));
                    }
                   
                    try {
                        Runtime.getRuntime().exec("explorer C:\\relatorio.txt");
                    }
                    catch (Exception e)
                    {
                       
                    }
                   
                    pw.printf("\n\n\n");
                    pw.close();
                }
               
                System.out.println("\nDeseja fazer o calculo sobre outros dados? \n"
                + "0- Nao \n"
                + "1- Sim ");
                op2 = tc.nextInt();
               
                System.out.println("");
               
            tc.nextLine();
               
        }while(op2 != 0);
    }
}