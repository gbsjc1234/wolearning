package top.wolearning.utils;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.UUID;

public class EncodeAndUUID {
    public static String encodeMD5Hex(String data) {
        return DigestUtils.md5Hex(data);
    }

    public static String getUUID() {
        return UUID.randomUUID().toString();
    }
}
