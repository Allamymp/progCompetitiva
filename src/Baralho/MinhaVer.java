package Baralho;

import java.util.*;

public class MinhaVer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split("");
        Map<String, List<Integer>> map = new HashMap<>();
        //C,E,U,P
        map.put("C", new ArrayList<>());
        map.put("E", new ArrayList<>());
        map.put("U", new ArrayList<>());
        map.put("P", new ArrayList<>());
        int[] values = new int[4];


        for (int i = 0; i < input.length - 1; i += 3) {
            Integer card = Integer.parseInt(input[i] + input[i + 1]);
            String naipe = input[i + 2];

            if (map.containsKey(naipe) && map.get(naipe).contains(card)) {
                updateValues(values, naipe, -99);
            } else {
                map.get(naipe).add(card);
                updateValues(values, naipe, 1);
            }
        }

        for (int i : values) {
            output(i);
        }
    }

    public static void output(int value) {

        if (value == 13) {
            System.out.println(0);
        }
        if (value < 13 && value >= 0) {
            System.out.println(13 - value);
        }
        if (value < 0) {
            System.out.println("erro");
        }
    }

    public static void updateValues(int[] array, String naipe, int value) {
        //C,E,U,P
        switch (naipe) {
            case "C" -> array[0] += value;

            case "E" -> array[1] += value;

            case "U" -> array[2] += value;

            case "P" -> array[3] += value;
        }

    }
}

