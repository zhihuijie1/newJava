package p1;

public enum Season2 {
    SPRING("春天", "春暖花开"),
    SUMMER("夏天", "夏日燕燕"),
    FULL("秋天", "士大夫大师傅"),
    WINTER("冬天", "第三方接口");

    private final String name;
    private final String desc;

    Season2(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
