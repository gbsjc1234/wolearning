package top.wolearning.entity;

public enum  ErrorEnum {
    OK("OK", 0),
    ERROR_INSERT("insert_error", 101),
    ERROR_UPDATE("update_error", 102),
    ERROR_GET_LIST("get_list_error", 201),
    ERROR_HAS_EXIST("has_exist", 202),
    ERROR_HAS_CHILDREN("has_children", 203),
    ;
    private String name;
    private int code;

    private ErrorEnum(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public static String getName(int code) {
        for (ErrorEnum c : ErrorEnum.values()) {
            if (c.getCode() == code) {
                return c.name;
            }
        }
        return null;
    }
    // get set 方法
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
}
