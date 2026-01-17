package LLDofFileSys;

public class Main {
    public static void main(String[] args) {
        Directory movie = new Directory("Movies");
        FileSystem border = new File("Border");
        movie.add(border);
        FileSystem hulchul = new File("Hulchul");
        Directory comedyMovie = new Directory("Comedy Movies");
        movie.add(comedyMovie);
        comedyMovie.add(hulchul);
        movie.ls();
    }
}
