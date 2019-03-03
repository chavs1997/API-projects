package forer.FlightsAndMovies;

public class Movie {
    int id;
    String overview;
    int runtime;
    String title;
    String poster_path;

    public Movie(int id, String overview, int runtime, String title, String poster_path) {
        this.id = id;
        this.overview = overview;
        this.runtime = runtime;
        this.title = title;
        this.poster_path = poster_path;
    }

    public int getId() {
        return id;
    }

    public String getOverview() {
        return overview;
    }

    public int getRuntime() {
        return runtime;
    }

    public String getTitle() {
        return title;
    }

    public String getPoster_path() {
        return poster_path;
    }
}
