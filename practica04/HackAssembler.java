/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dyegg
 */
public class HackAssembler {

//    private String nameArc = "Add.asm";
    private Parser parse;
    private SymbolTable symbolTable;
    private Code code;
    private List<String> document;
    private int defaultValue = 16;

    public HackAssembler() throws IOException {
        parse = new Parser();
        document = new ArrayList<>();
        symbolTable = new SymbolTable();
        this.symbolTable.addEntry("R0", 0);
        this.symbolTable.addEntry("R1", 1);
        this.symbolTable.addEntry("R2", 2);
        this.symbolTable.addEntry("R3", 3);
        this.symbolTable.addEntry("R4", 4);
        this.symbolTable.addEntry("R5", 5);
        this.symbolTable.addEntry("R6", 6);
        this.symbolTable.addEntry("R7", 7);
        this.symbolTable.addEntry("R8", 8);
        this.symbolTable.addEntry("R9", 9);
        this.symbolTable.addEntry("R10", 10);
        this.symbolTable.addEntry("R11", 11);
        this.symbolTable.addEntry("R12", 12);
        this.symbolTable.addEntry("R13", 13);
        this.symbolTable.addEntry("R14", 14);
        this.symbolTable.addEntry("R15", 15);
        this.symbolTable.addEntry("SCREEN", 16384);
        this.symbolTable.addEntry("KBD", 24576);
        this.symbolTable.addEntry("SP", 0);
        this.symbolTable.addEntry("LCL", 1);
        this.symbolTable.addEntry("ARG", 2);
        this.symbolTable.addEntry("THIS", 3);
        this.symbolTable.addEntry("THAT", 4);
    }

    public void firstPass() {
        while (parse.hasMoreLines()) {
            if (parse.instructionType().equals("L_INSTRUCTION")) {
                this.symbolTable.addEntry(parse.symbol(), parse.getCount());
                parse.deleteL_Instruction();
            } else {
                parse.advance();
            }
        }
    }

    public void secondPass() {
        parse.setCount(0);
        int valor;
        int valor2=0;
        String aux;
        while (parse.hasMoreLines()) {
            if (parse.instructionType().equals("A_INSTRUCTION")) {
                if (symbolTable.contains(parse.symbol())) {
                    valor = symbolTable.getAddress(parse.symbol());
                    document.add(Integer.toBinaryString(valor));

                } else {
                    aux = parse.symbol();
                    try {
                        valor = Integer.parseInt(aux);
                        valor2=valor;
                    } catch (NumberFormatException e) {
                        valor2 = defaultValue;
                        defaultValue++;
                    } finally {
                        symbolTable.addEntry(aux, valor2);
                        document.add(Integer.toBinaryString(valor2));

                    }
                }
            } else if (parse.instructionType().equals("C_INSTRUCTION")) {
                code = new Code(parse.getCurrentLine());
                document.add("111" + code.compFunction() + code.destFunction() + code.jumpFunction());
            }
            parse.advance();
        }
    }

    public void escribir() {
        BufferedWriter escritor;
        try {
            escritor = new BufferedWriter(new FileWriter("C:\\Users\\Dyegg\\OneDrive\\Documentos\\NetBeansProjects\\Assembler\\src\\Logica\\Pong.hack"));
            for (String j : document) {
                while (j.length() < 16) {
                    j = "0" + j;
                }
                escritor.write(j);
                escritor.write("\n");
            }
            escritor.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException {
        HackAssembler hack = new HackAssembler();
        hack.firstPass();
        hack.secondPass();
        hack.escribir(); 
    }

}
