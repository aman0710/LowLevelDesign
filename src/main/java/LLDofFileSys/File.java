package LLDofFileSys;

public class File implements FileSystem{

    String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void ls() {
        System.out.println("File name:" + this.name);
    }
}
