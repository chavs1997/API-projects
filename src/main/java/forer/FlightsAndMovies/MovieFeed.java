package forer.FlightsAndMovies;

public class MovieFeed {
    int page;
    int total_pages;
    MovieID[] results;

    public MovieFeed(int page, int total_pages, MovieID[] results) {
        this.page = page;
        this.total_pages = total_pages;
        this.results = results;
    }

    public int getPage() {
        return page;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public MovieID[] getResults() {
        return results;
    }
}
