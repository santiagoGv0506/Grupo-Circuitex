/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Dyegg
 */
public class SymbolTable {

    private Map<String, Integer> tabla=new HashMap<>();

    public void addEntry(String symbol,int address){
    tabla.put(symbol, address);
    }
    public boolean contains(String symbol){
    return tabla.containsKey(symbol);
    }
    public int getAddress(String symbol){
    return (int) tabla.get(symbol);
    }
 
}
