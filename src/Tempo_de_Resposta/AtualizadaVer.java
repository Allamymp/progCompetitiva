package Tempo_de_Resposta;

import java.util.Scanner;

public class AtualizadaVer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        int[] times = new int[101];
        int[] response = new int[101];
        int currentTime = 0;
        int biggestFriendIndex = 0;
        char lastOperation = '-';

        for (int i = 0; i < n; i++) {
            String[] inputs = sc.nextLine().split(" ");
            char operation = inputs[0].charAt(0);
            int time = Integer.parseInt(inputs[1]);

            if (lastOperation != 'T' && operation != 'T') {
                currentTime++;
            }
            switch (operation) {
                case 'R' -> {
                    times[time] = currentTime;
                    if (time > biggestFriendIndex) {
                        biggestFriendIndex = time + 2;
                    }
                    lastOperation = 'R';
                }
                case 'T' -> {
                    currentTime += time;
                    lastOperation = 'T';
                }
                case 'E' -> {
                    int waitingTime = currentTime - times[time];
                    response[time] += waitingTime;
                    times[time] = 0;
                    lastOperation = 'E';
                }
            }

        }
        for (int k = 0; k < biggestFriendIndex; k++) {
            if (times[k] != 0) {
                response[k] = -1;
            }
        }
        for (int j = 0; j < biggestFriendIndex; j++) {
            if (response[j] != 0) {
                System.out.println(j + " " + response[j]);
            }
        }
    }
}
