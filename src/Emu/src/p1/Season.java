package p1;

public class Season {
    private final String sName;
    private final String sDscr;

    //利用构造器对属性进行赋值操作：
    private Season(String sName, String sDscr) {
        this.sName = sName;
        this.sDscr = sDscr;
    }

    // 提供枚举类的有限的  确定的对象：
    public final static Season SPRING = new Season("春天", "春暖花开");
    public final static Season SUMMER = new Season("夏天", "烈日炎炎");
    public final static Season AUTUMN = new Season("秋天", "硕果累累");
    public final static Season WINTER = new Season("冬天", "冰天雪地");

    // 额外因素

    public String getsName() {
        return sName;
    }

    public String getsDscr() {
        return sDscr;
    }

    @Override
    public String toString() {
        return "Season{" +
                "sName='" + sName + '\'' +
                ", sDscr='" + sDscr + '\'' +
                '}';
    }
}
