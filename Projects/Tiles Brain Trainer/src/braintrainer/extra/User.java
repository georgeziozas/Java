package braintrainer.extra;

/**
 * Write a description of class User here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class User {

    // instance variables - replace the example below with your own
    private String username;
    public static String diffLvl;
    private String score;

    /**
     * Constructor for objects of class User
     *
     * @param username
     * @param diffLvl
     * @throws java.lang.Exception
     */
    public User(String username, String diffLvl) {
        // initialise instance variables
        this.username = username;
        this.diffLvl = diffLvl;

    }

    public String getUsername() {
        return this.username;
    }

    public String getDiffLvl() {
        return this.diffLvl;
    }

}

