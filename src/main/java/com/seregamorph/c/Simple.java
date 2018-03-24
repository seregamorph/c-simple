package com.seregamorph.c;

import java.util.Scanner;

public class Simple {

    public static void main(String[] args) {
        int n;
        if (args.length == 0) {
            System.out.print("Enter N (must be positive integer): ");
            Scanner in = new Scanner(System.in);
            n = in.nextInt();
        } else if (args.length == 1) {
            n = Integer.parseInt(args[0]);
        } else {
            printUsage();
            return;
        }
        if (n <= 0) {
            printUsage();
            return;
        }

        int s = arraySimpleInt(n, false);
        System.out.println(s);
    }

    private static void printUsage() {
        System.err.println("Program expects none or single parameter N > 0");
    }

    @Deprecated // не представляет большого интереса
    static int basicSimpleInt(int n, boolean trace) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        // i - отсчет простых чисел (до n)
        int i = 2;
        // m - число, которое проверяем на простоту
        cm:
        for (int m = 3; ; m += 2) {
            if (m < 0) {
                throw new IllegalStateException("int overload, last i=" + i);
            }
            int maxd = (int) Math.round(Math.sqrt(m));

            // d - делитель
            for (int d = 3; d <= maxd; d += 2) {
                if (m % d == 0) {
                    continue cm;
                }
            }
            // число m простое
            if (++i >= n) {
                return m;
            }

            if (trace && i % 1_000_000 == 0) {
                System.out.println(i + " " + m);
            }
        }
    }

    @Deprecated // не представляет большого интереса
    static long basicSimpleLong(int n, boolean trace) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        // i - отсчет простых чисел (до n)
        int i = 2;
        // m - число, которое проверяем на простоту
        cm:
        for (long m = 3; ; m += 2) {
            if (m < 0) {
                throw new IllegalStateException("long overload, last i=" + i);
            }
            long maxd = Math.round(Math.sqrt(m));

            // d - делитель
            for (long d = 3; d <= maxd; d += 2) {
                if (m % d == 0) {
                    continue cm;
                }
            }
            // число m простое
            if (++i >= n) {
                return m;
            }

            if (trace && i % 1_000_000 == 0) {
                System.out.println(i + " " + m);
            }
        }
    }

    static int arraySimpleInt(int n, boolean trace) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        int[] arr = new int[n - 3];
        // i - индекс в массиве
        int i = 0;
        // m - число, которое проверяем на простоту
        int m = 3;
        cm:
        for (; ; m += 2) {
            if (m < 0) {
                // здесь можно в принципе ограничиться известным максимальным N
                throw new IllegalStateException("int overload, last i=" + i + " and m=" + arr[i - 1]);
            }

            double sqrt = Math.sqrt(m);
            int maxd = (int) Math.round(sqrt);

            // d - делитель
            int d;
            for (int j = 0; j < i && (d = arr[j]) <= maxd; j++) {
                if (m % d == 0) {
                    continue cm;
                }
            }
            // m - простое
            if (++i >= n - 2) {
                return m;
            }
            arr[i - 1] = m;
            if (trace && i % 1_000_000 == 0) {
                System.out.println(i + " " + m);
            }
        }
    }

    static long arraySimpleLong(int n, boolean trace) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        long[] arr = new long[n - 3];
        // i - индекс в массиве
        int i = 0;
        // m - число, которое проверяем на простоту
        long m = 3;
        cm:
        for (; ; m += 2) {
            if (m < 0) {
                throw new IllegalStateException("long overload, last i=" + i);
            }

            double sqrt = Math.sqrt(m);
            long maxd = Math.round(sqrt);

            // d - делитель
            long d;
            for (int j = 0; j < i && (d = arr[j]) <= maxd; j++) {
                if (m % d == 0) {
                    continue cm;
                }
            }
            // m - простое
            if (++i >= n - 2) {
                return m;
            }
            arr[i - 1] = m;
            if (trace && i % 1_000_000 == 0) {
                System.out.println(i + " " + m);
            }
        }
    }
}
