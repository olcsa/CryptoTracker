package com.oliwasi.cryptotracker.network;//retrofit2

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.*;
import com.oliwasi.cryptotracker.model.*;

public interface PublicApi {
  /**
   * public endpoint which returns Currencies
   *
   * @return Call&lt;CurrencyList&gt;
   */
  @GET("public?command=returnCurrencies")
  Observable<CurrencyList> returnCurrencies();

  /**
   * public endpoint which returns CurrencyPairs
   *
   * @return Call&lt;CurrencyPairList&gt;
   */
  @GET("public?command=returnTicker")
  Observable<CurrencyPairList> returnTicker();

}
