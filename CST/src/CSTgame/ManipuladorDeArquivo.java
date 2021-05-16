package CSTgame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManipuladorDeArquivo {
    public static void leitorConsumivel(String nome, List<itemConsumivel> qualquer, partidaCST partidaCST) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(nome));
        String linha = "";
        int ID = 0;
        qualquer.clear();
        qualquer = new ArrayList<>();
        while (true) {
            if (linha != null) {
                String[] fatiada = linha.split(" ");
                if(fatiada[0] == "FlexaoPyke"){
                    ID = 1;
                }else if(fatiada[0] == "Pizza"){
                    ID = 2;
                }else{
                    ID = 3;
                }
                System.out.println(fatiada[2]);
                    //qualquer.add(new itemConsumivel(fatiada[0] , (int)fatiada[2].charAt(0), partidaCST, ID));
                
                

            } else
                break;
            linha = buffRead.readLine();
        }
        buffRead.close();
    }
    public static void leitorEquipavel(String nome, List<itemEquipavel> qualquer, partidaCST partidaCST) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(nome));
        String linha = "";
        int ID = 0;
        qualquer.clear();
        qualquer = new ArrayList<>();
        while (true) {
            if (linha != null) {
                String[] fatiada = linha.split(" ");
                if(fatiada[0] == "CamisaDaPlaystation"){
                    ID = 1;
                }else if(fatiada[0] == "TacoDeSinuca"){
                    ID = 2;
                }
                //qualquer.add(new itemEquipavel(fatiada[0], partidaCST, ID));

            } else
                break;
            linha = buffRead.readLine();
        }
        buffRead.close();
    }
    public static void escritorConsumivel(List<itemConsumivel> qualquer, String nome, partidaCST partidaCST) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(nome));
        time timevencendor = partidaCST.testaQuemGanhou();
        if(timevencendor == time.ORACULO){
            for (itemConsumivel itemConsumivel : qualquer) {
                buffWrite.append(itemConsumivel.getNome() + " O " + itemConsumivel.getQuantidade() + "\n");
            }
        }else{
            for (itemConsumivel itemConsumivel : qualquer) {
                buffWrite.append(itemConsumivel.getNome() + " T " + itemConsumivel.getQuantidade()+ "\n");
            }
        }

        buffWrite.close();
    }
    public static void escritorEquipavel(List<itemEquipavel> qualquer, String nome, partidaCST partidaCST) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(nome));
        time timevencendor = partidaCST.testaQuemGanhou();
        if(timevencendor == time.ORACULO){
            for (itemEquipavel itemConsumivel : qualquer) {
                buffWrite.append(itemConsumivel.getNomeItem() + " O" + "\n");
            }
        }else{
            for (itemEquipavel itemConsumivel : qualquer) {
                buffWrite.append(itemConsumivel.getNomeItem() + " T" + "\n");
            }
        }

        buffWrite.close();
    }
}

