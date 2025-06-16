package LLDofFileSystem;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem{

    String name;
    List<FileSystem> fileSystemList;

    public Directory(String name) {
        this.name = name;
        fileSystemList = new ArrayList<>();
    }

    public void add(FileSystem fileSystem) {
        this.fileSystemList.add(fileSystem);
    }

    @Override
    public void ls() {
        System.out.println("Directory Name -> " + this.name);
        for(FileSystem fileSystem : this.fileSystemList) {
            fileSystem.ls();
        }
    }
}
