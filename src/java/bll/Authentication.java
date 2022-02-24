package bll;

public class Authentication
{
    public TYPE getUserType()
    {
        return loggedInUserType;
    }

    public void setUserType(TYPE loggedInUserType)
    {
        // todo: real auth.
        this.loggedInUserType = loggedInUserType;
    }

    public enum TYPE
    {
        STUDENT,
        TEACHER
    }

    private TYPE loggedInUserType;

    private static Authentication instance;

    public static Authentication getInstance()
    {
        if (instance == null)
        {
            instance = new Authentication();
        }

        return instance;
    }
}
