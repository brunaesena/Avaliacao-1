import java.text.DecimalFormat;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        DecimalFormat decimal = new DecimalFormat("#,###.00");
        ConversorDeStringParaNumero conversor = new ConversorDeStringParaNumero();

        Double media = 0.0;
        Double somaMediaDisc = 0.0;
        Integer qtdReprovado = 0;
        Integer qtdAprovado = 0;
        Integer qtdFinal = 0;
        Double  maiorMedia = 0.0;
        Double  menorMedia = 0.0;
        Double mediaGeralDisc = 0.0;
        String turmaNome;
        Double somaMediaGeralTurma = 0.0;
        Double mediaGeralturma = 0.0;

        System.out.println("Qual o nome da turma analisada? ");
        System.out.println("Em caso de nome composto, utilizar o '_'. Exemplo: 'ADS-NASSAU'.");
        turmaNome = leia.next();

        System.out.println("Quantas disciplinas serao digitadas?");
        String inputQtdDisciplinas = leia.next();
        int qtdDisciplinas = conversor.conversorInteiro(inputQtdDisciplinas,leia);
        String[] disciplinasNome = new String[qtdDisciplinas];

        for(var i = 0; i < qtdDisciplinas; i++){
            System.out.println("Digite o nome da "+ (i+1) +"ª disciplina: ");
            System.out.println("Em caso de nome composto, utilizar o '_'. Exemplo: 'Logica-Programacao'.");
            disciplinasNome[i] = leia.next();
        }

        for(var i = 0; i < qtdDisciplinas; i++){
            System.out.println("Quantos alunos existe na disciplina de "+ disciplinasNome[i]+ "?");
            String inputQtdAlunos = leia.next();
            int qtdAlunos = conversor.conversorInteiro(inputQtdAlunos,leia);

            for(var j = 0; j < qtdAlunos; j++){
                System.out.println("Digite a primeira nota do " + (j+1) + "º aluno: ");
                String inputAv1 = leia.next();
                Double av1 = conversor.conversorDecimal(inputAv1,leia);
                while (av1 < 0.0 || av1 > 10.0){
                    System.out.println("Digite uma nota valida de 0.0 a 10.0!");
                    inputAv1 = leia.next();
                    av1 = conversor.conversorDecimal(inputAv1,leia);
                }
                System.out.println("Digite a segunda nota do " + (j+1) + "º aluno: ");
                String inputAv2 = leia.next();
                Double av2 = conversor.conversorDecimal(inputAv2,leia);
                while (av2 < 0.0 || av2 > 10.0){
                    System.out.println("Digite uma nota valida de 0.0 a 10.0!");
                    inputAv2 = leia.next();
                    av2 = conversor.conversorDecimal(inputAv2,leia);
                }

                media = (av1.doubleValue() + av2.doubleValue()) /2;
                somaMediaDisc = somaMediaDisc + media;
                mediaGeralDisc = somaMediaDisc / qtdAlunos;

                if(media >= 4 && media < 7){
                    qtdFinal++;
                } else if (media >= 7) {
                    qtdAprovado++;
                }
                else {
                    qtdReprovado++;
                }
                if(j == 0){
                    maiorMedia = media;
                    menorMedia = media;
                } else if (media > maiorMedia) {
                    maiorMedia = media;
                } else if (media < menorMedia) {
                    menorMedia = media;
                }
            }
            System.out.println("-------------------------------");
            System.out.println("#### RESUMO DA DISCIPLINA ####");
            System.out.println("DISCIPLINA:" + disciplinasNome[i]);
            System.out.println("QTD TOTAL DE ALUNOS: " + qtdAlunos);
            System.out.println("MÉDIA GERAL DA DISCIPLINA: " + mediaGeralDisc);
            System.out.println("MAIOR MÉDIA DA DISCIPLINA: " + maiorMedia);
            System.out.println("MENOR MÉDIA DA DISCIPLINA: " + menorMedia);
            System.out.println("QTD ALUNOS REPROVADOS: " + qtdReprovado);
            System.out.println("QTD ALUNOS NA FINAL: " + qtdFinal);
            System.out.println("QTD ALUNOS APROVADOS: "+ qtdAprovado);
            System.out.println("-------------------------------");

            somaMediaGeralTurma = somaMediaGeralTurma + mediaGeralDisc;
            somaMediaDisc = (double)0;
            mediaGeralDisc = (double) 0;
            qtdReprovado = 0;
            qtdFinal = 0;
            qtdAprovado = 0;
        }

        mediaGeralturma = somaMediaGeralTurma / qtdDisciplinas;

        System.out.println("-------------------------------");
        System.out.println("#### RESUMO DA TURMA ####");
        System.out.println("TURMA: " + turmaNome);
        System.out.println("QTD DE DISCIPLINAS: " + qtdDisciplinas);
        System.out.println("MÉDIA GERAL DA TURMA: " + decimal.format(mediaGeralturma));
        System.out.println("-------------------------------");

    }

}
