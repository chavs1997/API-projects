package forer.ApprovedDrugs;

import com.google.inject.AbstractModule;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class DrugModule extends AbstractModule{
        @Override
        protected void configure() {
            super.configure();
            Retrofit retrofit = new Retrofit.Builder().
                    baseUrl("https://www.ebi.ac.uk")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();

            DrugService service = retrofit.create(DrugService.class);
            bind(DrugService.class).toInstance(service);
        }

}
