package com.mwguerra;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    // Volatile
    volatile static String volatileFrase = "Frase em volatile String";

    public static void main(String[] args) {
        // Objetos imutáveis
        Integer numero = 1111;
        String frase = "Frase em String";

        // StringBuilder
        StringBuilder stringBuilderFrase = new StringBuilder("Frase em StringBuffer");

        // Objetos thread safe
        AtomicInteger atomicNumero = new AtomicInteger(2222);
        StringBuffer stringBufferFrase = new StringBuffer("Frase em StringBuffer");
        AtomicReference<String> atomicFrase = new AtomicReference<>();

        atomicFrase.set("Frase em atomic String");

        System.out.println("#######################################");
        System.out.println("# TESTE DE REFERÊNCIAS PARA OBJETOS");
        System.out.println("# Variáveis não primitivas");
        System.out.println("#######################################\n");
        System.out.println("--- VALORES ORIGINAIS ---");
        System.out.println("Integer: " + numero);
        System.out.println("Integer (Atomic): " + atomicNumero);
        System.out.println("String: " + frase);
        System.out.println("String (volatile): " + volatileFrase);
        System.out.println("String (StringBuilder): " + stringBuilderFrase);
        System.out.println("String (StringBuffer): " + stringBufferFrase);
        System.out.println("String (Atomic): " + atomicFrase);

        modificaVariaveis(numero, frase, stringBuilderFrase, atomicNumero, stringBufferFrase, atomicFrase);

        System.out.println("\n--- APÓS TENTAR MODIFICAÇÃO ---");
        System.out.println("Integer [Imutável]: " + numero);
        System.out.println("Integer (Atomic) [Thread Safe]: " + atomicNumero);
        System.out.println("String [Imutável]: " + frase);
        System.out.println("String (volatile): " + volatileFrase);
        System.out.println("String (StringBuilder): " + stringBuilderFrase);
        System.out.println("String (StringBuffer) [Thread Safe]: " + stringBufferFrase);
        System.out.println("String (Atomic) [Thread Safe]: " + atomicFrase);
    }

    protected static void modificaVariaveis(Integer numero, String frase, StringBuilder stringBuilderFrase, AtomicInteger atomicNumero, StringBuffer stringBufferFrase, AtomicReference<String> atomicFrase) {
        numero = numero + 1000;
        atomicNumero.getAndAdd(1000);
        frase = frase.concat(" - Alterada");
        stringBufferFrase.append(" - Alterada");
        stringBuilderFrase.append(" - Alterada");
        volatileFrase = volatileFrase.concat(" - Alterada");
        atomicFrase.getAndSet(atomicFrase.get() + " - Alterada");
    }
}
