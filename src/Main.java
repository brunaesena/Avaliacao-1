import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        DecimalFormat decimal = new DecimalFormat("#.##0.00");

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
// teste git commit
        System.out.println("Qual o nome da turma analisada? ");
        turmaNome = leia.nextLine();

        System.out.println("Quantas disciplinas serao digitadas?");
        int qtdDisciplinas = leia.nextInt();
        String[] disciplinasNome = new String[qtdDisciplinas];
        for(var i = 0; i < qtdDisciplinas; i++){
            System.out.println("Digite o nome da "+ (i+1) +"ª disciplina: ");
            System.out.println("Em caso de nome composto, utilizar o '_'. Exemplo: 'fisica_quantica'.");
            disciplinasNome[i] = leia.next();
        }
        for(var i = 0; i < qtdDisciplinas; i++){
            System.out.println("Quantos alunos existe na disciplina de "+ disciplinasNome[i]+ "?");
            int qtdAlunos = leia.nextInt();
            for(var j = 0; j < qtdAlunos; j++){
                System.out.println("Digite a primeira nota do " + (j+1) + "º aluno: ");
                Double av1 = leia.nextDouble();
                while (av1 < 0.0 || av1 > 10.0){
                    System.out.println("Digite uma nota valida de 0.0 a 10.0!");
                    av1 = leia.nextDouble();
                }
                System.out.println("Digite a segunda nota do " + (j+1) + "º aluno: ");
                Double av2 = leia.nextDouble();
                while (av2 < 0.0 || av2 > 10.0){
                    System.out.println("Digite uma nota valida de 0.0 a 10.0!");
                    av2 = leia.nextDouble();
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
            System.out.println("#### RESUMO DA DISCIPLINA ####");
            System.out.println("DISCIPLINA:" + disciplinasNome[i]);
            System.out.println("QTD TOTAL DE ALUNOS: " + qtdAlunos);
            System.out.println("MÉDIA GERAL DA DISCIPLINA: " + mediaGeralDisc);
            System.out.println("MAIOR MÉDIA DA DISCIPLINA: " + maiorMedia);
            System.out.println("MENOR MÉDIA DA DISCIPLINA: " + menorMedia);
            System.out.println("QTD ALUNOS REPROVADOS: " + qtdReprovado);
            System.out.println("QTD ALUNOS NA FINAL: " + qtdFinal);
            System.out.println("QTD ALUNOS APROVADOS: "+ qtdAprovado);

            somaMediaGeralTurma = somaMediaGeralTurma + mediaGeralDisc;
            somaMediaDisc = (double)0;
            mediaGeralDisc = (double) 0;
            qtdReprovado = 0;
            qtdFinal = 0;
            qtdAprovado = 0;
        }

        mediaGeralturma = somaMediaGeralTurma / qtdDisciplinas;

        System.out.println("#### RESUMO DA TURMA ####");
        System.out.println("TURMA: " + turmaNome);
        System.out.println("QTD DE DISCIPLINAS: " + qtdDisciplinas);
        System.out.println("MÉDIA GERAL DA TURMA: " + decimal.format(mediaGeralturma));

    }

}
