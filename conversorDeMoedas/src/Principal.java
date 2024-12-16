import com.google.gson.Gson;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        int continuacao = 0;
        int dinheiro;
        Gson gson = new Gson();
        while(continuacao != 7) {
            System.out.println("""
                ******************************************************
                Seja bem-vindo/a ao Conversor de Moeda =]
                
                1) Dólar =>> Peso argentino
                2) Peso argentino =>> Dólar
                3) Dólar =>> Real brasileiro
                4) Real brasileiro =>> Dólar
                5) Dólar =>> Peso colombiano
                6) Peso colombiano =>> Dólar
                7) Sair
                
                Escola uma opção válida:
                ******************************************************
                """);
            continuacao = sc.nextInt();
            if(continuacao == 1) {
                Requisicao req = new Requisicao();
                System.out.println("Digite o valor que deseja converter:");
                dinheiro = sc.nextInt();
                String json = (req.getEndereco("pair/USD/ARS/" + dinheiro));
                ValorConvertido conversao = gson.fromJson(json, ValorConvertido.class);
                System.out.println("Valor " + dinheiro + " [USD] corresponde ao valor final de =>>> " + conversao.conversion_result() + " [ARS]");
            }
            if(continuacao == 2) {
                Requisicao req = new Requisicao();
                System.out.println("Digite o valor que deseja converter:");
                dinheiro = sc.nextInt();
                String json = (req.getEndereco("pair/ARS/USD/" + dinheiro));
                ValorConvertido conversao = gson.fromJson(json, ValorConvertido.class);
                System.out.println("Valor " + dinheiro + " [ARS] corresponde ao valor final de =>>> " + conversao.conversion_result() + " [USD]");
            }
            if(continuacao == 3) {
                Requisicao req = new Requisicao();
                System.out.println("Digite o valor que deseja converter:");
                dinheiro = sc.nextInt();
                String json = (req.getEndereco("pair/USD/BRL/" + dinheiro));
                ValorConvertido conversao = gson.fromJson(json, ValorConvertido.class);
                System.out.println("Valor " + dinheiro + " [USD] corresponde ao valor final de =>>> " + conversao.conversion_result() + " [BRL]");
            }
            if(continuacao == 4) {
                Requisicao req = new Requisicao();
                System.out.println("Digite o valor que deseja converter:");
                dinheiro = sc.nextInt();
                String json = (req.getEndereco("pair/USD/BRL/" + dinheiro));
                ValorConvertido conversao = gson.fromJson(json, ValorConvertido.class);
                System.out.println("Valor " + dinheiro + " [BRL] corresponde ao valor final de =>>> " + conversao.conversion_result() + " [USD]");
            }
            if(continuacao == 5) {
                Requisicao req = new Requisicao();
                System.out.println("Digite o valor que deseja converter:");
                dinheiro = sc.nextInt();
                String json = (req.getEndereco("pair/USD/COP/" + dinheiro));
                ValorConvertido conversao = gson.fromJson(json, ValorConvertido.class);
                System.out.println("Valor " + dinheiro + " [USD] corresponde ao valor final de =>>> " + conversao.conversion_result() + " [COP]");
            }
            if(continuacao == 6) {
                Requisicao req = new Requisicao();
                System.out.println("Digite o valor que deseja converter:");
                dinheiro = sc.nextInt();
                String json = (req.getEndereco("pair/COP/USD/" + dinheiro));
                ValorConvertido conversao = gson.fromJson(json, ValorConvertido.class);
                System.out.println("Valor " + dinheiro + " [COP] corresponde ao valor final de =>>> " + conversao.conversion_result() + " [USD]");
            }

        }

    }
}
