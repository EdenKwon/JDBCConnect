package NewBoardProgramming.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

public class ExecuteBoard {

  public static void main(String[] args) throws SQLException, IOException {
    MainMenu menu = new MainMenu();
    menu.list();
  }
}
