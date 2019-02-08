package interfaces;

import model.RandomUsers;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RandomUsersApi {
    @GET("api")
    Call<RandomUsers> getRandomUsers();
}
