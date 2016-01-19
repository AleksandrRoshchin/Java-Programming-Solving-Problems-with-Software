package com.company;

public class Main {

    public static boolean isProtein(String gene, String possibleStopCodon) {
        int stopCodonIndex = gene.indexOf(possibleStopCodon);
        System.out.println(stopCodonIndex);
        return stopCodonIndex != -1 && (stopCodonIndex % 3) == 0;
    }

    public static String stopCodon(String gene) {
        if (isProtein(gene, "tag")) return "tag";
        if (isProtein(gene, "tga")) return "tga";
        if (isProtein(gene, "taa")) return "taa";
        return "";
    }

    public static String findProtein(String dna) {
        int start = dna.indexOf("atg");
        if (start == -1) {
            return "";
        }
        String gene = dna.substring(start);
        String realStopCodon = stopCodon(gene);
        if (realStopCodon.isEmpty()) return "";
        return gene.substring(0, gene.indexOf(realStopCodon) + 3);
    }

    public static void testing() {
        String a = "cccatggggttgaaataataataagagagagagagagagttt";
        String ap = "atggggtttaaataa";
        //String a = "atgcctag";
        //String ap = "";
        //String a = "ATGCCCTAG";
        //String ap = "ATGCCCTAG";
        String result = findProtein(a);
        if (ap.equals(result)) {
            System.out.println("success for " + ap + " length " + ap.length());
        }
        else {
            System.out.println("mistake for input: " + a);
            System.out.println("got: " + result);
            System.out.println("not: " + ap);
        }
    }

    public static void main(String[] args) {
        testing();
    }
}
