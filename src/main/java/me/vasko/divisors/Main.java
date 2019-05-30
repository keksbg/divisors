package me.vasko.divisors;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    boolean isPrime = true;
    boolean isNPrime = true;
    int n;
    int divisor;
    String prime = null;
    String nmb = "Please provide a number.";
    String err = "Please provide a valid number.";
    String isprime = "prime";
    String inprime = "not prime";
    String oldver = "It is recomended to check for a newer release here: https://keksbg.pw/releases";
    if(args.length == 1) {
      if(args[0].equals("-it")) {
        prime = null;
        nmb = "Per favore dia un numero.";
        err = "Per favore dia un numero valido.";
        isprime = "primo";
        inprime = "non primo";
        oldver = "È racommandato di rivedere per una nuova versione qui: https://keksbg.pw/releases";
      }
    }
    /*

      TODO: nodejs server for releases
      TODO: requests to the server to check
      TODO: parse responses correctly

    */
    Scanner scanner = new Scanner(System.in);
    System.out.printf("[RECOMMENDATION] %s%n", oldver);
      while (true) {
        System.out.printf("[REQUEST] %s%n", nmb);
        String integer = scanner.nextLine();
        try {
          n = Integer.parseUnsignedInt(integer);
        } catch (Exception e) {
          System.out.printf("[ERROR] %s%n", err);
          return;
        }
        for(int i = 2; i <= n/2; ++i)
        {
          isNPrime = true;
          if(n % i == 0)
          {
            isNPrime = false;
            break;
          }
        }
        System.out.printf("[INPUT] %s%n", n);
        System.out.printf("[OUTPUT] %s, %s%n", "1", isprime);
          for(divisor = 2; divisor <= n / 2; divisor++) {
            isPrime = true;
            for(int i = 2; i <= divisor/2; i++)
            {
              if(divisor % i == 0)
              {
                isPrime = false;
                break;
              }
            }
            if (n % divisor == 0) {
              if(isPrime){ prime = isprime;} else {prime = inprime;}
              System.out.printf("[OUTPUT] %s, %s%n", divisor, prime);
            }
          }
          if(isNPrime) {prime = isprime;} else {prime = inprime;}
        System.out.printf("[OUTPUT] %s, %s%n%n%n", n, prime);
      }

  }
}