package uk.co.alexander.barmymarvel.retrofit;

import io.reactivex.Flowable;
import uk.co.alexander.barmymarvel.model.Constants;
import uk.co.alexander.barmymarvel.model.retrofit.MarvelResponse;
import uk.co.alexander.barmymarvel.utility.MD5Generator;

import static uk.co.alexander.barmymarvel.model.Constants.NUM_COMICS;
import static uk.co.alexander.barmymarvel.model.Constants.PUBLIC_API_KEY;
import static uk.co.alexander.barmymarvel.model.Constants.TIME_STAMP;

/**
 * Facade class to interact with the retrofit API
 */

public class MarvelInteractor {
    IMarvelApi mApi;

    public MarvelInteractor(IMarvelApi api) {
        mApi = api;
    }

    public Flowable<MarvelResponse> getComicList() {
        String hash = MD5Generator.getMd5Hash(TIME_STAMP + Constants.PRIVATE_API_KEY + PUBLIC_API_KEY);

        final Flowable<MarvelResponse> response = mApi.getComics(PUBLIC_API_KEY, TIME_STAMP, hash, NUM_COMICS);

        return response;
    }

}
