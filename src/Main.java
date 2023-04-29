import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        Double media = (double) 0;
        Double somaMediaDisc = (double) 0;
        Integer qtdReprovado = 0;
        Integer qtdAprovado = 0;
        Integer qtdFinal = 0;
        Double  maiorMedia = (double) 0;
        Double  menorMedia = (double) 0;
        Double mediaGeralDisc = (double) 0;



        System.out.println("Quantas disciplinas serao digitadas?");
        int qtdDisciplinas = leia.nextInt();
        String[] disciplinasNome = new String[qtdDisciplinas];
        for(var i = 0; i < qtdDisciplinas; i++){
            System.out.println("Qual o nome da "+ (i+1) +"ª disciplina");
            disciplinasNome[i] = leia.next();
        }
        for(var i = 0; i < qtdDisciplinas; i++){
            System.out.println("Quantos alunos existe na disciplina "+ disciplinasNome[i]+ "?");
            int qtdAlunos = leia.nextInt();
            for(var j = 0; j < qtdAlunos; j++){
                System.out.println("Digite a primeira nota: ");
                Double av1 = leia.nextDouble();
                System.out.println("Digite a segunda nota: ");
                Double av2 = leia.nextDouble();

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
            System.out.println("DISCIPLINA:" + qtdAlunos);
            System.out.println("QTD TOTAL DE ALUNOS: " + qtdAlunos);
            System.out.println("MÉDIA GERAL DA DISCIPLINA: " + mediaGeralDisc);
            System.out.println("MAIOR MÉDIA DA DISCIPLINA: " + maiorMedia);
            System.out.println("MENOR MÉDIA DA DISCIPLINA: " + menorMedia);
            System.out.println("QTD ALUNOS REPROVADOS: " + qtdReprovado);
            System.out.println("QTD ALUNOS NA FINAL: " + qtdFinal);
            System.out.println("QTD ALUNOS APROVADOS: "+ qtdAprovado);
        }

    }

        }
