/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Dyegg
 */
public class Parser {

    private BufferedReader archivo;
    private List<String> datos;
    private int count = 0;
    private String currentLine;

    public String getCurrentLine() {
        return currentLine;
    }

    public Parser() throws FileNotFoundException, IOException {
        archivo = new BufferedReader(new FileReader("C:\\Users\\Dyegg\\OneDrive\\Documentos\\NetBeansProjects\\Assembler\\src\\Logica\\Pong.asm"));
        datos = new ArrayList<>();
        String data = archivo.readLine();
        
        while (data != null) {
            data=data.replace(" ","");
            datos.add(data);
            data = archivo.readLine();
        }
        archivo.close();
        deleteComments();
        currentLine = datos.get(count);

    }

    public boolean hasMoreLines() {
        return count < datos.size();
    }

    private void deleteComments() {
        Iterator<String> it = datos.iterator();
        while (it.hasNext()) {
            String aux = it.next();
            if (aux.startsWith("/") || aux.isBlank()) {
                it.remove();
            }
        }
    }

    public int getCount() {
        return count;
    }

    public void deleteL_Instruction() {
        if (instructionType().equals("L_INSTRUCTION")) {
            datos.remove(count);
            this.currentLine = datos.get(count);
        }
    }

    public void setCount(int count) {
        this.count = count;
        this.currentLine = datos.get(count);
    }

    public void advance() {
        if (hasMoreLines()) {
            count++;
            if (count != datos.size()) {
                currentLine = datos.get(count);
            }
        }
    }

    public String instructionType() {
        if (currentLine.startsWith("@")) {
            return "A_INSTRUCTION";
        } else if (currentLine.startsWith("(")) {
            return "L_INSTRUCTION";
        } else {
            return "C_INSTRUCTION";
        }
    }

    public String symbol() {
        String[] s;
        String palabra = "";
        s = currentLine.split("");
        if (instructionType().equals("A_INSTRUCTION")) {
            for (int i = 1; i < s.length; i++) {
                if(!s[i].equals(" ")){
                palabra = palabra + s[i];}
            }
        } else if (instructionType().equals("L_INSTRUCTION")) {
            for (int i = 1; i < s.length - 1; i++) {
                if(!s[i].equals(" ")){
                palabra = palabra + s[i];}
            }
        }
        return palabra;
    }

    public String dest() {
        Code c = new Code(currentLine);
        if (instructionType().equals("C_INSTRUCTION")) {
            return c.getDest();
        } else {
            return "";
        }
    }

    public String comp() {
        Code c = new Code(currentLine);
        if (instructionType().equals("C_INSTRUCTION")) {
            return c.getComp();
        } else {
            return "";
        }
    }

    public String jump() {
        Code c = new Code(currentLine);
        if (instructionType().equals("C_INSTRUCTION")) {
            return c.getJump();
        } else {
            return "";
        }
    }
}
