package CSTgame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ManipuladorDeArquivo {
    public static void leitor(String nome) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(nome));
        String linha = "";
        while (true) {
            if (linha != null) {
                System.out.println(linha);

            } else
                break;
            linha = buffRead.readLine();
        }
        buffRead.close();
    }
    public static void escritor(List<itemConsumivel> qualquer, String nome) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(nome));
        for (itemConsumivel itemConsumivel : qualquer) {
            buffWrite.append(itemConsumivel.getNome());
        }
        buffWrite.close();
    }
    public static void escritor2(List<itemEquipavel> qualquer, String nome) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(nome));
        for (itemEquipavel itemConsumivel : qualquer) {
            buffWrite.append(itemConsumivel.getNomeItem());
        }
        buffWrite.close();
    }
}

