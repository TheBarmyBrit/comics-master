package uk.co.alexander.barmymarvel.retrofit;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import uk.co.alexander.barmymarvel.model.Constants;
import uk.co.alexander.barmymarvel.model.retrofit.MarvelResponse;


public interface IMarvelApi {
    @GET(Constants.COMIC_API)
    Flowable<MarvelResponse> getComics(@Query("apikey") String apiKey, @Query("ts") String timeStamp, @Query("hash") String hash, @Query("limit") int limit) ;
}
