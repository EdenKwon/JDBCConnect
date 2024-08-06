package BoardProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BoardExample {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) {
    MainMenu menu = new MainMenu();
    menu.list();
  }
}
