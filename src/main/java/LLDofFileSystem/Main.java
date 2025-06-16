package LLDofFileSystem;

public class Main {

    public static void main(String[] args) {
        Directory movieDirectory = new Directory("Movies");
        FileSystem border = new File("Border");
        movieDirectory.add(border);
        Directory comedyMovieDirectory = new Directory("ComedyMovies");
        File hulchul = new File("Hulchul");
        comedyMovieDirectory.add(hulchul);
        movieDirectory.add(comedyMovieDirectory);
        movieDirectory.ls();
    }

}
