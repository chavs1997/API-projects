package forer.ApprovedDrugs;

import retrofit2.http.*;
import io.reactivex.Observable;

public interface DrugService {

    @GET("/chembl/api/data/molecule?max_phase=4&format=json")
    Observable<DrugFeed> getApprovedDrugs();

}
