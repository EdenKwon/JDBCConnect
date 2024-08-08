package JDBCMemberManagement.vo;

public class Member {
  private String memberId;
  private String memberName;
  private String memberPassword;
  private int memberAge;
  private String newPassword;

  public Member(String memberId, String memberName, String memberPassword, int memberAge) {
    this.memberId = memberId;
    this.memberName = memberName;
    this.memberPassword = memberPassword;
    this.memberAge = memberAge;
  }

  public Member() {};

  public String getmemberId() {
    return memberId;
  }

  public void setmemberId(String memberId) {
    this.memberId = memberId;
  }

  public String getMemberName() {
    return memberName;
  }

  public void setMemberName(String memberName) {
    this.memberName = memberName;
  }

  public int getMemberAge() {
    return memberAge;
  }

  public void setMemberAge(int memberAge) {
    this.memberAge = memberAge;
  }

  public String getMemberPassword() {
    return memberPassword;
  }

  public void setMemberPassword(String memberPassword) {
    this.memberPassword = memberPassword;
  }

  public String getNewPassword() {
    return newPassword;
  }

  public void setNewPassword(String newPassword) {
    this.newPassword = newPassword;
  }

  @Override
  public String toString() {
    return "Member{" +
        "memberId='" + memberId + '\'' +
        ", memberName='" + memberName + '\'' +
        ", memberPassword='" + memberPassword + '\'' +
        ", memberAge='" + memberAge +
        '}';
  }
}
