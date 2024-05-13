package Tempo_de_Resposta;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MinhaVer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numN = sc.nextInt();
        sc.nextLine();
        Map<Integer, Integer> map = new HashMap<>();
        int[] response = new int[100];

        char lastOperation = '-';
        int lastTime = 0;

        for (int i = 0; i < numN; i++) {
            String[] input = sc.nextLine().split(" ");
            Integer inputNum = Integer.parseInt(input[1]);
            char operation = input[0].charAt(0);

            if (lastOperation == 'T') {
                updateTimes(map, lastTime);
            } else if (operation != 'T') {
                updateTimes(map, 1);
            }

            switch (operation) {
                case 'R' -> {
                    map.put(inputNum, 0);
                    lastOperation = 'R';
                }
                case 'T' -> {
                    lastOperation = 'T';
                    lastTime = Integer.parseInt(input[1]);
                }
                case 'E' -> {
                    Integer time = map.get(inputNum);
                    if (time == 1) {
                        time = -1;
                    }
                    response[inputNum] += time;
                    lastOperation = 'E';
                }
            }
        }

        for (int i = 0; i < 100; i++) {
            if (response[i] != 0) {
                System.out.println(i + " " + response[i]);
            }
        }
    }

    public static void updateTimes(Map<Integer, Integer> map, int time) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            entry.setValue(entry.getValue() + time);
        }
    }
}
