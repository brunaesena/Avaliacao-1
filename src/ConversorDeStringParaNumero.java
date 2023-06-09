import java.util.Scanner;

public class ConversorDeStringParaNumero {
    public Integer conversorInteiro(String valorASerConvertido, Scanner input){
        boolean valido = true;
        Integer valorConvertido = 0;
        do {
            try{
                valorConvertido = Integer.parseInt(valorASerConvertido);
                valido = false;
                if (valorConvertido < 0){
                    System.out.println("Digite um número válido!");
                    System.out.println("*Utilize '.' em caso de números decimais.");
                    valorASerConvertido = input.next();
                    valido = true;
                }
            } catch (NumberFormatException numberException){
                System.out.println("Digite um número válido!");
                System.out.println("*Utilize '.' em caso de números decimais.");
                valorASerConvertido = input.next();
            }
        }while (valido);
        return valorConvertido;
    }
    public Double conversorDecimal(String valorASerConvertido, Scanner input){
        boolean valido = true;
        Double valorConvertido = 0.0;
        do {
            try{
                valorConvertido = Double.parseDouble(valorASerConvertido);
                valido = false;
                if (valorConvertido < 0){
                    System.out.println("Digite um número válido!");
                    System.out.println("*Utilize '.' em caso de números decimais.");
                    valorASerConvertido = input.next();
                    valido = true;
                }
            } catch (NumberFormatException numberException){
                System.out.println("Digite um número válido!");
                System.out.println("*Utilize '.' em caso de números decimais.");
                valorASerConvertido = input.next();
            }
        }while (valido);
        return valorConvertido;
    }
}
