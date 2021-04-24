package com.oliwasi.cryptotracker.network;//retrofit2

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
  Call<CurrencyList> returnCurrencies();

  /**
   * public endpoint which returns CurrencyPairs
   *
   * @return Call&lt;CurrencyPairList&gt;
   */
  @GET("public?command=returnTicker")
  Call<CurrencyPairList> returnTicker();

}
