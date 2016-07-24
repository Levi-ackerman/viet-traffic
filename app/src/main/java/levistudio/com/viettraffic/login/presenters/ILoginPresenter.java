package levistudio.com.viettraffic.login.presenters;

/**
 * Created by Levi on 7/24/2016.
 */

public interface ILoginPresenter {
    /**
     * Do login with email and password
     * @param email
     * @param password
     */
    void doLogin(String email, String password);

    /**
     * For test purpose
     * @param email
     * @param password
     */
    void doRegister(String email, String password);
}
