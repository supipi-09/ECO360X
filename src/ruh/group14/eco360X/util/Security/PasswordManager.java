package ruh.group14.eco360X.util.Security;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordManager {
    public String encrypt(String rawPassword) {
        return BCrypt.hashpw(rawPassword, BCrypt.gensalt(10));
    }

    public boolean checkPassword(String rawPassword, String hashPassword) {
        return BCrypt.checkpw(rawPassword, hashPassword);
    }
}
