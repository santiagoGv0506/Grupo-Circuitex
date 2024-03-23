/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author Dyegg
 */
public class Code {

    private String dest;
    private String comp;
    private String jump;

    public Code(String line) {
        if (line.contains("=") && line.contains(";")) {
            String[] datos = line.split("=");
            dest = datos[0];
            String[] datos2 = datos[1].split(";");
            comp = datos2[0];
            jump = datos2[1];
        } else if (line.contains("=") && !line.contains(";")) {
            String[] datos = line.split("=");
            dest = datos[0];
            comp = datos[1];
            jump = null;
        } else if (!line.contains("=") && line.contains(";")) {
            String[] datos = line.split(";");
            comp = datos[0];
            jump = datos[1];
            dest = null;
        } else {
            comp = line;
            dest = null;
            jump = null;
        }
    }

    public String compFunction() {
        String binary;
        switch (comp) {
            case "0":
                binary = "0101010";
                break;
            case "1":
                binary = "0111111";
                break;
            case "-1":
                binary = "0111010";
                break;
            case "D":
                binary = "0001100";
                break;
            case "A":
                binary = "0110000";
                break;
            case "M":
                binary = "1110000";
                break;
            case "!D":
                binary = "0001101";
                break;
            case "!A":
                binary = "0110001";
                break;
            case "!M":
                binary = "1110001";
                break;
            case "-D":
                binary = "0001111";
                break;
            case "-A":
                binary = "0110011";
                break;
            case "-M":
                binary = "1110011";
                break;
            case "D+1":
                binary = "0011111";
                break;
            case "A+1":
                binary = "0110111";
                break;
            case "M+1":
                binary = "1110111";
                break;
            case "D-1":
                binary = "0001110";
                break;
            case "A-1":
                binary = "0110010";
                break;
            case "M-1":
                binary = "1110010";
                break;
            case "D+A":
                binary = "0000010";
                break;
            case "D+M":
                binary = "1000010";
                break;
            case "D-A":
                binary = "0010011";
                break;
            case "D-M":
                binary = "1010011";
                break;
            case "A-D":
                binary = "0000111";
                break;
            case "M-D":
                binary = "1000111";
                break;
            case "D&A":
                binary = "0000000";
                break;
            case "D&M":
                binary = "1000000";
                break;
            case "D|A":
                binary = "0010101";
                break;
            case "D|M":
                binary = "1010101";
                break;
            default:
                binary = null;
        }
        return binary;
    }

    public String destFunction() {
        String binary;
        if (dest != null) {
            switch (dest) {
                case "M":
                    binary = "001";
                    break;
                case "D":
                    binary = "010";
                    break;
                case "DM":
                    binary = "011";
                    break;
                case "A":
                    binary = "100";
                    break;
                case "AM":
                    binary = "101";
                    break;
                case "AD":
                    binary = "110";
                    break;
                case "ADM":
                    binary = "111";
                    break;
                default:
                    binary = "000";
            }
        } else {
            binary = "000";
        }
        return binary;
    }

    public String jumpFunction() {
        String binary;
        if (jump != null) {
            switch (jump) {
                case "JGT":
                    binary = "001";
                    break;
                case "JEQ":
                    binary = "010";
                    break;
                case "JGE":
                    binary = "011";
                    break;
                case "JLT":
                    binary = "100";
                    break;
                case "JNE":
                    binary = "101";
                    break;
                case "JLE":
                    binary = "110";
                    break;
                case "JMP":
                    binary = "111";
                    break;
                default:
                    binary = "000";
            }
        } else {
            binary = "000";
        }
        return binary;
    }

    public String getDest() {
        return dest;
    }

    public String getComp() {
        return comp;
    }

    public String getJump() {
        return jump;
    }
}
