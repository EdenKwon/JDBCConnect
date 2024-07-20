package NewBoardProgramming.controller;

import java.sql.SQLException;

public class ExecuteBoard {

  public static void main(String[] args) throws SQLException {
    MainMenu menu = new MainMenu();

    while (true) {
      menu.list();
    }

  }

  // 예외처리 enum
}
