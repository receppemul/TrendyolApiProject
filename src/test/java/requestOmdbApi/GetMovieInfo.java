package requestOmdbApi;

import Enums.OmdbEnum;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import org.testng.annotations.BeforeTest;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class GetMovieInfo extends BaseRequest {
    RequestSpecification requestSpecification;
    Response response;

    @BeforeTest
    public void setupRequestSpecification() {
        requestSpecification = RestAssured.given()
                .baseUri(url);
    }

    @Test
    //check movie parameters of year,title, released
    public void searchMovie() {
        checkMovieWithId(getMovieWithId());
    }

    public String getMovieWithId() {
        response = requestSearchWithData(searchKey).when().get(url + "/?t=" + searchKey).then().extract().response();
        return response.jsonPath().getString("imdbID");
    }

    public void checkMovieWithId(String movieId) {
        RestAssured
                .given(requestSpecification).
                param(OmdbEnum.API_KEY.getMovieInfo(), apiKey).
                param(OmdbEnum.MOVIE_ID.getMovieInfo(), movieId).
                param(OmdbEnum.MOVIE_TITLE.getMovieInfo(), "").
                param(OmdbEnum.MOVIE_TYPE.getMovieInfo(), "movie").
                param(OmdbEnum.MOVIE_YEAR.getMovieInfo(), "").
                param(OmdbEnum.DATA_TYPE.getMovieInfo(), "json").
                param(OmdbEnum.APIVERSION.getMovieInfo(), "1").
                param(OmdbEnum.PLOT.getMovieInfo(), "full").
                param(OmdbEnum.CALLBACK.getMovieInfo(), "")

                .when()

                .then()
                .statusCode(200)
                .body("Title", equalTo(notNullValue()))
                .body("Year", equalTo(notNullValue())).and()
                .body("Released", equalTo(notNullValue()));
    }

    private RequestSpecification requestSearchWithData(String movieTitle) {
        requestSpecification = given().
                param(OmdbEnum.API_KEY.getMovieInfo(), apiKey).
                param(OmdbEnum.MOVIE_TITLE.getMovieInfo(), movieTitle).
                param(OmdbEnum.MOVIE_TYPE.getMovieInfo(), "movie").
                param(OmdbEnum.MOVIE_YEAR.getMovieInfo(), "").
                param(OmdbEnum.DATA_TYPE.getMovieInfo(), "json").
                param(OmdbEnum.MOVIE_PAGE.getMovieInfo(), "").
                param(OmdbEnum.CALLBACK.getMovieInfo(), "").
                param(OmdbEnum.APIVERSION.getMovieInfo(), "1").
                param(OmdbEnum.PLOT.getMovieInfo(), "full");
        return requestSpecification;
    }
}
