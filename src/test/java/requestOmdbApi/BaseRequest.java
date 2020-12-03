package requestOmdbApi;

import org.junit.Before;

public class BaseRequest {
    public String searchKey;
    public String apiKey;
    public String url;
    @Before
    public void  setUp()throws  Exception{
        init();
    }
    private  void init() throws  Exception{
        url="http://www.omdbapi.com/";
        searchKey="Harry Potter";
        apiKey="8359918f";
    }
}
