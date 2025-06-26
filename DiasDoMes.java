import java.util.Scanner;


public class DiasDoMes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       
        // Recebe a entrada do mês
        System.out.print("Digite o nome do mês (ex: janeiro) ou o número do mês (1-12): ");
        String entrada = scanner.nextLine().trim().toLowerCase();
       
        int mes;
        try {
            // Tenta converter a entrada para número
            mes = Integer.parseInt(entrada);
            if (mes < 1 || mes > 12) {
                System.out.println("Erro: Número do mês deve estar entre 1 e 12!");
                scanner.close();
                return;
            }
        } catch (NumberFormatException e) {
            // Mapeia nomes de meses para números
            mes = switch (entrada) {
                case "janeiro" -> 1;
                case "fevereiro" -> 2;
                case "março", "marco" -> 3;
                case "abril" -> 4;
                case "maio" -> 5;
                case "junho" -> 6;
                case "julho" -> 7;
                case "agosto" -> 8;
                case "setembro" -> 9;
                case "outubro" -> 10;
                case "novembro" -> 11;
                case "dezembro" -> 12;
                default -> -1;
            };
            if (mes == -1) {
                System.out.println("Erro: Nome do mês inválido!");
                scanner.close();
                return;
            }
        }
       
        // Calcula a quantidade de dias
        int dias;
        switch (mes) {
            case 2: // Fevereiro
                System.out.print("Digite o ano (ex: 2025): ");
                int ano;
                try {
                    ano = Integer.parseInt(scanner.nextLine());
                    if (ano < 0) {
                        System.out.println("Erro: Ano deve ser um número positivo!");
                        scanner.close();
                        return;
                    }
                    dias = isAnoBissexto(ano) ? 29 : 28;
                } catch (NumberFormatException e) {
                    System.out.println("Erro: Digite um ano válido!");
                    scanner.close();
                    return;
                }
                break;
            case 4, 6, 9, 11: // Abril, Junho, Setembro, Novembro
                dias = 30;
                break;
            default: // Janeiro, Março, Maio, Julho, Agosto, Outubro, Dezembro
                dias = 31;
        }
       
        // Obtém o nome do mês para exibição
        String nomeMes = switch (mes) {
            case 1 -> "Janeiro";
            case 2 -> "Fevereiro";
            case 3 -> "Março";
            case 4 -> "Abril";
            case 5 -> "Maio";
            case 6 -> "Junho";
            case 7 -> "Julho";
            case 8 -> "Agosto";
            case 9 -> "Setembro";
            case 10 -> "Outubro";
            case 11 -> "Novembro";
            case 12 -> "Dezembro";
            default -> "Desconhecido";
        };
       
        // Exibe o resultado
        System.out.printf("O mês de %s tem %d dias.%n", nomeMes, dias);
        System.out.println("Processamento concluído com sucesso!");
       
        scanner.close();
    }
   
    // Verifica se o ano é bissexto
    public static boolean isAnoBissexto(int ano) {
        return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
    }
}
