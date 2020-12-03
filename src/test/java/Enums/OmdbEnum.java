package Enums;

public enum OmdbEnum {
    API_KEY("apikey"),
    MOVIE_TYPE("movieType"),
    MOVIE_YEAR("movieYear"),
    DATA_TYPE("dataType"),
    APIVERSION("apiVersion"),
    MOVIE_PAGE("moviePage"),
    MOVIE_ID("movieId"),
    MOVIE_TITLE("movie_Title"),
    PLOT("plot"),
    CALLBACK("callback");


    private String movieInfo;
    OmdbEnum (String movieInfo){
        this.movieInfo=movieInfo;
    }
    public  String getMovieInfo(){
        return  movieInfo;
    }
}
