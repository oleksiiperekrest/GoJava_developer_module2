package controller;

import java.math.BigDecimal;
import java.util.*;

public class Input {
    private static Scanner input = new Scanner(System.in);

    public static String getStringInput() {
        return input.next();
    }

    public static String getStringInput(String message) {
        System.out.println(message);
        return input.next();
    }

    public static String getStringInputLimit(int limit, String message) {
        System.out.println(message);
        String in;
        while (true) {
            in = input.next();
            if (in.length() > limit) {
                System.out.println("(Enter a line no more than " + limit + " symbols!)");
            } else break;
        }
        return in;
    }

    public static String getStringInputLimitNotNull(int limit, String message) {
        System.out.println(message);
        String in;
        while (true) {
            in = input.next();
            if (in.length() > limit || in.length() == 0) {
                System.out.println("(Enter a *not empty* line no more than " + limit + " symbols!)");
            } else break;
        }
        return in;
    }


    public static void readEmptyLine() {
        Scanner input = new Scanner(System.in);
        input.next();
    }

    /**
     * @return An integer input from the user.
     */
    public static int getIntInput() {
        Scanner input = new Scanner(System.in);
        while (!input.hasNextInt()) {
            System.out.println("(Enter a whole number!)");
            input.next();
        }
        return input.nextInt();
    }

    /**
     * @return An integer input from the user.
     */
    public static int getIntInput(String message) {
        System.out.println(message);
        while (!input.hasNextInt()) {
            System.out.println("(Enter a whole number!)");
            input.next();
        }
        return input.nextInt();
    }

    public static int getAllowedIntInput(String message, List<Integer> allowed) {
        while (true) {
        int i = getIntInput(message);
        if (allowed.contains(i)) return i;
        }
    }

    /**
     * Gets user input of a positive integer.
     *
     * @param message Message to be displayed to invite input.
     * @return Positive integer entered by user.
     */
    public static int getPositiveIntInput(String message) {
        System.out.println(message);
        while (true) {
            String line = input.next();
            try {
                int n = Integer.parseInt(line);
                if (n >= 0) {
                    return n;
                }
            } catch (NumberFormatException e) {

            }
            System.out.print("(Enter a positive whole number!)\n" + message);
        }
    }

    public static int getBoundIntInput(String message, int lowerBound, int upperBound) {
        System.out.println(message);

        while (true) {
            String line = input.next();
            try {
                int n = Integer.parseInt(line);
                if (n >= lowerBound && n <= upperBound) {
                    return n;
                } else throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.print("(Enter a positive whole number between " + lowerBound + " and " + upperBound +
                        "!)\n" + message);
            }

        }
    }

    public static int getBoundIntInput(String message, String errorMessage, int lowerBound, int upperBound) {
        System.out.println(message);

        while (true) {
            String line = input.next();
            try {
                int n = Integer.parseInt(line);
                if (n >= lowerBound && n <= upperBound) {
                    return n;
                }
            } catch (NumberFormatException e) {

            }
            System.out.print(errorMessage);
        }
    }

    /**
     * @return An float number input by user.
     */
    public static float getFloatInput() {
        while (!input.hasNextFloat()) {
            System.out.println("(Enter a number!)");
            input.next();
        }
        return input.nextFloat();
    }

    /**
     * @param message Message shown to user to invite input.
     * @return An float number input by user.
     */
    public static float getFloatInput(String message) {
        System.out.println(message);
        while (!input.hasNextFloat()) {
            System.out.println("(Enter a number!)");
            input.next();
        }
        return input.nextFloat();
    }

    /**
     * @param message Message shown to user to invite input.
     * @return An float number input by user.
     */
    public static double getDoubleInput(String message) {
        System.out.println(message);
        while (!input.hasNextDouble()) {
            System.out.println("(Enter a number!)");
            input.next();
        }
        return input.nextDouble();
    }

    public static double getPositiveDoubleInput(String message) {
        System.out.println(message);

        while (true) {
            String line = input.next();
            try {
                double d = Double.parseDouble(line);
                if (d >= 0.0) {
                    return d;
                }
            } catch (NumberFormatException e) {
            }
            System.out.print("(Enter a positive number!)\n" + message);
        }
    }

    /**
     * @param length  Predetermined length of array.
     * @param message Message shown to user to invite input.
     * @return Array of integers entered by user.
     */
    public static int[] getIntsArrayInput(int length, String message) {
        System.out.println(message);
        int[] array = new int[length];

        for (int i = 0; i < array.length; i++) {
            array[i] = getIntInput("Enter integer number (" + (i + 1) + " of " + length + ").");
        }
        return array;
    }

    public static List<Integer> getIntegerList(String message) {
        System.out.println(message);
        System.out.println("Enter integer numbers separated by space symbol (\" \")");
        String in = input.nextLine();
        if (in.equals("")) in = input.nextLine();
        List<Integer> integers = new ArrayList<>();
        try {
            String[] numbers = in.split(" ");
            for (String number : numbers) {
                integers.add(Integer.parseInt(number));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return integers;
    }

    public static List<Integer> getAllowedIntegerList(String message, List<Integer> allowed) {
        while (true) {
            System.out.println(message);
            System.out.println("Enter integer numbers separated by space symbol (\" \")");
            System.out.println("Only following numbers are valid:");
            System.out.println(allowed);
            String in = input.nextLine();
            if (in.equals("")) in = input.nextLine();
            List<Integer> integers = new ArrayList<>();
            try {
                String[] numbers = in.split(" ");
                for (String number : numbers) {
                    integers.add(Integer.parseInt(number));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            for (int i = integers.size() - 1; i >= 0; i--) {
                Integer integer = integers.get(i);
                if (!allowed.contains(integer)) {
                    integers.remove(integer);
                    System.out.println(integer + " is invalid input, removed from list");
                }
            }
            if (integers.size() > 0) {
                //removing repeating numbers
                Set<Integer> set = new HashSet<>(integers);
                integers.clear();
                integers.addAll(set);
                //sort ascending
                Collections.sort(integers);
                return integers;
            }
        }
    }

    /**
     * @param length  Predetermined length of array.
     * @param message Message shown to user to invite input.
     * @return Array of floats entered by user.
     */
    public static float[] getFloatsArrayInput(int length, String message) {
        System.out.println(message);
        float[] array = new float[length];

        for (int i = 0; i < array.length; i++) {
            array[i] = getFloatInput("Enter a number (" + (i + 1) + " of " + length + ").");
        }
        return array;
    }

    public static boolean yesNo(String message) {
        String line;
        boolean yn;

        System.out.println(message + " (y/n)");
        while (true) {
            line = input.next().trim().toLowerCase();

            if (line.equals("y")) {
                yn = true;
                break;
            } else if (line.equals("n")) {
                yn = false;
                break;
            } else {
                System.out.println("Please answer \"y\" or \"n\".");
            }
        }
        return yn;
    }

    public static BigDecimal getBigDecimalPositive(String message) {
        System.out.println(message);
        while (true) {
            String line = input.next();
            try {
                BigDecimal in = new BigDecimal(line);
                if (in.compareTo(new BigDecimal("0")) >= 0) {
                    return in;
                }
            } catch (NumberFormatException e) {
            }
            System.out.print("(Enter a positive number!)\n" + message);
        }
    }
}