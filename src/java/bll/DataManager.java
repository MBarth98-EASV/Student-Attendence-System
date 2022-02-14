/**
 * @Author Philip E. Zadeh
 */

package bll;

import dal.DataMock;

public class DataManager {

    DataMock data = null;
    private static DataManager instance = null;

    /**
     *  Singleton pattern. Ensures there is no more than a single instance of this class at a time.
     */
    public static DataManager getInstance()
    {
        if (instance == null)
        {
            instance = new DataManager();
        }

        return instance;
    }

    public DataManager()
    {
        data = new DataMock();
    }

    public String getUserLogin()
    {
        return data.userLogin();
    }

    public String getUserPassword()
    {
        return data.userPassword();
    }

    public String getUser()
    {
        return data.User();
    }


}
