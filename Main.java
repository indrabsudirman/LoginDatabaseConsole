
/**
 * Login Database dengan Console mySQL
 *
 * @author (indrabsudirman - Github)
 * @version (Trail and Learning)
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.io.Console;
import java.util.Scanner;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main
{
    static InputStreamReader inputStreamReader = new InputStreamReader (System.in);
    static BufferedReader input = new BufferedReader (inputStreamReader);
    
    static Statement statement;
    static ResultSet resultSet;
    
    public static void main (String [] args) throws ClassNotFoundException {
        
        System.out.println("Mencoba menghubung dengan database");
        ConnectionDatabase connectionDatabase = new ConnectionDatabase();
        try {
            if (connectionDatabase.getConnection() != null) {
                System.out.println("Connected to database");
                System.out.println();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        mainMenu();
        
        
        
        //DataBaseHelper dataBaseHelper = new DataBaseHelper();
        //dataBaseHelper.databaseHelper();
        
        
        
        
    
    }
    
    public static void mainMenu(){
        
        System.out.println("+-------------------------------------+");
        System.out.println("| LOGIN DATABASE CONSOLE DENGAN MYSQL |");
        System.out.println("+-------------------------------------+");
        System.out.print("");
        
        System.out.println("1. Login");
        System.out.println("2. Tidak punya akun? Buat Akun baru");
        System.out.println("0. Keluar");
        System.out.println("");
        System.out.print("Pilihan> ");
        
        try {
            int pilihan = Integer.parseInt(input.readLine());
            
            switch (pilihan) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    login();
                    break;
                case 2:
                    buatAkun();
                    break;
                default:
                    System.out.println("Pilihan Anda salah!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void login() {
        System.out.println("Anda pilih login");
        
        Console console = System.console();
        Scanner inputScanner = new Scanner (System.in);
        
        String userName;
        
        System.out.print("Please enter your Username: ");
        userName = inputScanner.nextLine();
        
        char [] passwordArray = console.readPassword("Please enter your Password: ");
        
        System.out.println();
        System.out.println();
        
        System.out.println("Your Username is: " + userName);
        console.printf("Your Password is: %s%n", new String(passwordArray));
        
        //String passwordArray;
        try {
            //Statement statement; 
            ConnectionDatabase connectionDatabase = new ConnectionDatabase();
            statement = connectionDatabase.getConnection().createStatement();
            String sql = "SELECT * FROM users WHERE USERNAME = ? AND PASSWORD = ?";
            PreparedStatement preparedStatement = connectionDatabase.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, new String(passwordArray));
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                String passwordNew = new String(passwordArray);
                //userName = resultSet.getString(2);
                //String passwordNew = resultSet.getString(3);
                //passwordNew = resultSet.getString(2);
                //System.out.println("username : "+ userName + " dan password: " + passwordNew );
                if (userName.equals(resultSet.getString(2)) && passwordNew.equals(resultSet.getString(3))) {
                    System.out.println("You are successfully login");
                
                } else {
                    System.out.println("Username and Password did not find");
                }
            
            } 
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }
    
    public static void buatAkun() {
        System.out.println("Anda pilih Buat Akun");
        System.out.println();
                
        Console console = System.console();
        Scanner inputScanner = new Scanner (System.in);
        
        String userName;
        
        System.out.print("Please enter your e-mail: ");
        userName = inputScanner.nextLine();
        
        char [] passwordArray = console.readPassword("Please enter your Password: ");
        char [] passwordArrayAgain = console.readPassword("Please re-enter your Password again: ");
        
        System.out.println();
        System.out.println();
        
        //String passwordOne, passwordTwo;
        //passwordOne = new String (passwordArray);
        //passwordTwo = new String (passwordArrayAgain);
        if (!Array.equals(passwordArray.getPassword(), passwordArrayAgain.getPassword())) {
            //String password = passwordOne.equals(passwordTwo);
            System.out.println("Your Username is: " + userName + "Password" + password);
        }
        
        System.out.println("Your Username is: " + userName);
        console.printf("Your Password is: %s%n", new String(passwordArray));
    }
}
