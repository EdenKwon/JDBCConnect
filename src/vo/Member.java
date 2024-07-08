package vo;

public class Member {
  private String memberId;
  private String memberName;
  private String memberAge;

  public Member(String memberId, String memberName, String memberAge) {
    this.memberId = memberId;
    this.memberName = memberName;
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

  public String getMemberAge() {
    return memberAge;
  }

  public void setMemberAge(String memberAge) {
    this.memberAge = memberAge;
  }

  @Override
  public String toString() {
    return "Member{" +
        "memberId='" + memberId + '\'' +
        ", memberName='" + memberName + '\'' +
        ", memberAge='" + memberAge + '\'' +
        '}';
  }
}
