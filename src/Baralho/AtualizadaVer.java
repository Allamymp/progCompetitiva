package Baralho;

import java.util.Scanner;

public class AtualizadaVer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char[] input = sc.nextLine().toCharArray();
        int[] values = new int[4]; //C,E,U,P

        for (int i = 0; i < input.length - 2; i += 3) {
            int card = (input[i] - '0') * 10 + (input[i + 1] - '0');
            char naipe = input[i + 2];

            if (values[naipeIndex(naipe)] != 0 && inputContains(input, i, card)) {
                updateValues(values, naipe, -99);
            } else {
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
        } else if (value < 13 && value >= 0) {
            System.out.println(13 - value);
        } else if (value < 0) {
            System.out.println("erro");
        }
    }

    public static void updateValues(int[] array, char naipe, int value) {
        array[naipeIndex(naipe)] += value;
    }

    public static int naipeIndex(char naipe) {
        return switch (naipe) {
            case 'C' -> 0;
            case 'E' -> 1;
            case 'U' -> 2;
            case 'P' -> 3;
            default -> -1;
        };
    }

    public static boolean inputContains(char[] input, int index, int card) {
        for (int i = 0; i < index; i += 3) {
            int currentCard = (input[i] - '0') * 10 + (input[i + 1] - '0');
            if (currentCard == card) {
                return true;
            }
        }
        return false;
    }
}
