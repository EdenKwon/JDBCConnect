package NewBoardProgramming.vo;

public enum Messages {
  // 메뉴
  MAIN_MENU("메인 메뉴 : 1.Create | 2.Read | 3.Clear | 4.Exit"),
  MENU_CHOICE("메뉴 선택 : "),
  SUB_MENU("보조 메뉴 : 1.Update | 2.Delete | 3.List"),
  SUB_MENU_CHECK("보조 메뉴 : 1.OK | 2. Cancel"),
  // 목록
  BOARD_LIST("[게시물 목록]"),
  BOARD_LIST_HEADER("no\twriter\tdate\t\ttitle"),
  BOARD_LIST_DIVIDER("--------------------------------------------"),
  //정보 입력
  INPUT_LIST("[새 게시물 입력]"),
  INPUT_MODIFY("[수정 내용 입력]"),
  INPUT_BNO("번호 : "),
  INPUT_TITLE("제목 : "),
  INPUT_CONTENT("내용 : "),
  INPUT_WRITER("작성자 : "),
  INPUT_DATE("날짜 : "),
  // 메시지
  INPUT_NUMBER("숫자를 입력해주세요."),
  WRONG_INPUT("잘못 입력하셨습니다. 다시 입력해주세요."),
  NO_BOARD("해당 게시물이 없습니다."),
  // 결과
  SUCCESS("완료했습니다."),
  CANCEL("취소했습니다."),
  TRY_AGAIN("다시 시도해주세요."),
  // 기타
  NEXTLINE("\n"),
  EXIT("프로그램을 종료합니다.");

  private final String message;

  Messages(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public void println() {
    System.out.println(message);
  }

  public void print() {
    System.out.print(message);
  }
}
