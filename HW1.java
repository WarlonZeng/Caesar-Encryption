package homeworks.hw1;

import java.util.Scanner;
import java.io.PrintStream;
import java.io.File;
import java.io.IOException;

/**
 * @author warlon zeng
 **/

public class HW1 {
    static void encrypt(String encryptKey, String userFileInput, String userFileOutput) throws IOException {
        Scanner fileInput = new Scanner(new File(userFileInput));
        PrintStream fileOutput = new PrintStream(userFileOutput); // throws IOException if something weird happens
        while (fileInput.hasNext()) {
            String lineToConvert = fileInput.nextLine(); // user string
            //System.out.print(lineToConvert);
            char[] encryptedChars = new char[lineToConvert.length()];
            char encrypted;
            for (int i = 0, j = 0; i < lineToConvert.length(); i++, j++) {
                if (j > encryptKey.length() - 1) {
                    j = 0;
                }
                // Hello World! Password
                    if ((lineToConvert.charAt(i) >= 'a') && (lineToConvert.charAt(i) <= 'z')) {
                        if (((lineToConvert.charAt(i)-97) + (encryptKey.charAt(j)-97)) > 25)
                            if (encryptKey.charAt(j) < 'a') {
                                encrypted = (char)(((lineToConvert.charAt(i)) + (encryptKey.charAt(j)+32) -26 -97));
                            }
                            else 
                                encrypted = (char)(((lineToConvert.charAt(i)) + (encryptKey.charAt(j)) - 26 -97));
                        else 
                            encrypted = (char)((lineToConvert.charAt(i) + encryptKey.charAt(j) -97));
                        encryptedChars[i] = encrypted;
                        //System.out.print(lineToConvert.charAt(i));
                        //System.out.print(encryptKey.charAt(j));
                        //System.out.print(encrypted);
                    } 
                    else if ((lineToConvert.charAt(i) >= 'A') && (lineToConvert.charAt(i) <= 'Z')) {
                        if (((lineToConvert.charAt(i)-65) + (encryptKey.charAt(j)-65)) > 25)
                            if (encryptKey.charAt(j) > 'Z') {
                                encrypted = (char)(((lineToConvert.charAt(i)) + (encryptKey.charAt(j)-32) -26 -65));
                            }
                            else 
                                encrypted = (char)(((lineToConvert.charAt(i)) + (encryptKey.charAt(j)) - 26 -65));
                        else 
                            encrypted = (char)((lineToConvert.charAt(i) + encryptKey.charAt(j) - 65));
                        encryptedChars[i] = encrypted;
                        //System.out.print(lineToConvert.charAt(i));
                        //System.out.print(encryptKey.charAt(j));
                        //System.out.print(encrypted);
                    }
                    else {
                        encryptedChars[i] = lineToConvert.charAt(i);
                    }
            }
            String encryptedString = new String(encryptedChars);
            fileOutput.println(encryptedString);
        }
    }
    
    static void decrypt(String decryptKey, String userFileInput, String userFileOutput) throws IOException {
    Scanner fileInput = new Scanner(new File(userFileInput));
    PrintStream fileOutput = new PrintStream(userFileOutput); // throws IOException if something weird happens
        while (fileInput.hasNext()) {
            String lineToConvert = fileInput.nextLine(); // user string
            //System.out.print(lineToConvert);
            char[] decryptedChars = new char[lineToConvert.length()];
            char decrypted;
            for (int i = 0, j = 0; i < lineToConvert.length(); i++, j++) {
                if (j > decryptKey.length() - 1) {
                    j = 0;
                }
                // Hello World! Password
                    if ((lineToConvert.charAt(i) >= 'a') && (lineToConvert.charAt(i) <= 'z')) {
                        if (((lineToConvert.charAt(i)-97) - (decryptKey.charAt(j)-97)) < 0)
                            if (decryptKey.charAt(j) < 'a') {
                                decrypted = (char)(((lineToConvert.charAt(i)) - (decryptKey.charAt(j)+32) +26 +97));
                            }
                            else 
                                decrypted = (char)(((lineToConvert.charAt(i)) - (decryptKey.charAt(j)) + 26 +97));
                        else 
                            decrypted = (char)((lineToConvert.charAt(i) - decryptKey.charAt(j) + 97));
                        decryptedChars[i] = decrypted;
                        System.out.print(lineToConvert.charAt(i));
                        System.out.print(decryptKey.charAt(j));
                        System.out.print(decrypted);
                    } 
                    else if ((lineToConvert.charAt(i) >= 'A') && (lineToConvert.charAt(i) <= 'Z')) {
                        if (((lineToConvert.charAt(i)-65) - (decryptKey.charAt(j)-65)) < 0)
                            if (decryptKey.charAt(j) > 'Z') {
                                decrypted = (char)(((lineToConvert.charAt(i)) - (decryptKey.charAt(j)-32) +26 +65));
                            }
                            else 
                                decrypted = (char)(((lineToConvert.charAt(i)) - (decryptKey.charAt(j)) + 26 +65));
                        else 
                            decrypted = (char)((lineToConvert.charAt(i) - decryptKey.charAt(j) + 65));
                        decryptedChars[i] = decrypted;
                        System.out.print(lineToConvert.charAt(i));
                        System.out.print(decryptKey.charAt(j));
                        System.out.print(decrypted);
                    }
                    else {
                        decryptedChars[i] = lineToConvert.charAt(i);
                    }
            }
            String encryptedString = new String(decryptedChars);
            fileOutput.println(encryptedString);
        }
    }
    
    public static void main(String[] args) throws IOException {
        Scanner userInput = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            System.out.println("1 - Encrypt a file");
            System.out.println("2 - Decrypt a file");
            System.out.println("0 - Exit");
            
            System.out.print("Choice: ");
            choice = userInput.nextInt();
            
            System.out.print("Encryption Key: "); 
            userInput.nextLine();
            String key = userInput.nextLine();
            
            System.out.print("Enter input filename: ");
            String inputFileName = userInput.nextLine();
            
            while (!new File(inputFileName).canRead())
            {
                System.out.println("Bad filename");
                System.out.print("Enter input filename: ");
                inputFileName = userInput.nextLine();
            }
            System.out.print("Enter output filename: ");
            String outputFileName = userInput.nextLine();
            if (choice == 1) {
            encrypt(key, inputFileName, outputFileName);
            }
            else
            decrypt(key, inputFileName, outputFileName);
          }
        } 
    }