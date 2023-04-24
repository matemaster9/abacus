package org.mastercs.bigdata.biz;

public class CustomerInfo {

    private String name;
    private String idCard;
    private String phone;
    private String address;

    // 构造方法
    public CustomerInfo(String name, String idCard, String phone, String address) {
        this.name = name;
        this.idCard = idCard;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // 姓名脱敏
    public String maskName() {
        if (name == null || name.length() < 2) {
            return name;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(name.charAt(0));
        for (int i = 1; i < name.length(); i++) {
            builder.append("*");
        }
        return builder.toString();
    }

    // 身份证号码脱敏
    public String maskIdCard() {
        if (idCard == null || idCard.length() < 7) {
            return idCard;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(idCard.substring(0, 6));
        for (int i = 6; i < idCard.length() - 4; i++) {
            builder.append("*");
        }
        builder.append(idCard.substring(idCard.length() - 4));
        return builder.toString();
    }

    // 手机号码脱敏
    public String maskPhone() {
        if (phone == null || phone.length() < 7) {
            return phone;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(phone.substring(0, 3));
        for (int i = 3; i < phone.length() - 4; i++) {
            builder.append("*");
        }
        builder.append(phone.substring(phone.length() - 4));
        return builder.toString();
    }

    // 地址脱敏
    public String maskAddress() {
        if (address == null || address.length() < 7) {
            return address;
        }
        StringBuilder builder = new StringBuilder();
        String[] arr = address.split(" ");
        if (arr.length > 0) {
            builder.append(arr[0]);
        }
        if (arr.length > 1) {
            builder.append(" ").append(arr[1]);
        }
        if (arr.length == 0) {
            return null;
        }

        return null;
    }
}
