package com.company;

import java.lang.ref.Cleaner;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int escolha = 0;
        String email = null;
        String Tel = null;
        String nome = null;
        String cpf = null;
        int n = 0;

        Map<String, String> listaAluno = new HashMap<String, String>();

        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Digite a opção Desejada:");
            System.out.println("1 - Cadastro de aluno");
            System.out.println("2 - Excluir aluno");
            System.out.println("3 - Listar alunos");
            System.out.println("4 - Alterar Cadastro de alunos");
            System.out.println("0 - Sair");

            escolha = Integer.parseInt(input.nextLine());

            switch (escolha) {

                case 1:
                    System.out.println("Digite o CPF:");
                    cpf = input.nextLine();
                    if (listaAluno.containsKey(cpf)) {
                        System.out.println("Ja consta na lista!!");
                        System.out.println("Digite outro CPF:");
                        cpf = input.nextLine();
                    }
                    System.out.println("Digite o nome completo:");
                    nome = input.nextLine();
                    System.out.println("Digite o Telefone:");
                    Tel = input.nextLine();
                    System.out.println("Digite o email:");
                    email = input.nextLine();

                    listaAluno.put(cpf, "- Nome: " + nome.toUpperCase() + "- E-mail: " + email.toLowerCase() + "- Telefone: " + Tel);
                    System.out.println("Digite 1 para retornar ao menu ou 0 para finalizar");
                    n = Integer.parseInt(input.nextLine());
                    break;
                case 2:
                    System.out.println("Digite o CPF:");
                    cpf = input.nextLine();
                    listaAluno.remove(cpf);
                    System.out.println("Deletado com Sucesso!");
                    System.out.println("Digite 1 para retornar ao menu ou 0 para finalizar");
                    n = Integer.parseInt(input.nextLine());
                    break;
                case 3:
                    if (listaAluno.isEmpty()) {
                        System.out.println("Lista vazia!");
                    } else {
                        for (String chaveAluno : listaAluno.keySet()) {
                            System.out.println(listaAluno.get(chaveAluno) + " CPF: " + chaveAluno);
                        }
                    }
                    System.out.println("Digite 1 para retornar ao menu ou 0 para finalizar");
                    n = Integer.parseInt(input.nextLine());
                    break;
                case 4:
                    System.out.println("Digite o CPF de quem deseja alterar os dados:");
                    cpf = input.nextLine();
                    System.out.println(listaAluno.get(cpf));
                    int opcao = 0;
                    int outro = 0;
                    do {
                        System.out.println("Digite para alterar 1-Nome 2-Telefone 3-Email");
                        opcao = Integer.parseInt(input.nextLine());
                        if (opcao == 1) {
                            System.out.println("Digite o nome completo:");
                            nome = input.nextLine();

                            System.out.println("Alterado com Sucesso!");
                            listaAluno.put(cpf, "- Nome: " + nome.toUpperCase() + "- E-mail: " + email.toLowerCase() + "- Telefone: " + Tel);
                            System.out.println("Alterar mais algum campo? 1 para sim - 0 para não");
                            outro = Integer.parseInt(input.nextLine());
                        } else if (opcao == 2) {
                            System.out.println("Digite o Telefone:");
                            Tel = input.nextLine();
                            System.out.println("Alterado com Sucesso!");
                            listaAluno.put(cpf, "- Nome: " + nome.toUpperCase() + "- E-mail: " + email.toLowerCase() + "- Telefone: " + Tel);
                            System.out.println("Alterar mais algum campo? 1 para sim - 0 para não");
                            outro = Integer.parseInt(input.nextLine());
                        } else if (opcao == 3) {
                            System.out.println("Digite o email:");
                            email = input.nextLine();
                            email.toLowerCase();
                            System.out.println("Alterado com Sucesso!");
                            listaAluno.put(cpf, "- Nome: " + nome.toUpperCase() + "- E-mail: " + email.toLowerCase() + "- Telefone: " + Tel);
                            System.out.println("Alterar mais algum campo? 1 para sim - 0 para não");
                            outro = Integer.parseInt(input.nextLine());
                        } else {
                            System.out.println("Sem Alterações!");
                            outro = 0;
                        }

                    } while (outro != 0);
                    break;
                default:
                    System.out.println("Digite uma opção do menu!");
                    n = 1;
                    break;
            }
        } while (n != 0);
    }
}