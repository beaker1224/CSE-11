import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

public class FileSystem {

    MyHashMap<String, ArrayList<FileData>> nameMap;
    MyHashMap<String, ArrayList<FileData>> dateMap;

    public FileSystem() {
        this.nameMap = new MyHashMap<String, ArrayList<FileData>>();
        this.dateMap = new MyHashMap<String, ArrayList<FileData>>();
    }

    public FileSystem(String inputFile) {
        this.nameMap = new MyHashMap<String, ArrayList<FileData>>();
        this.dateMap = new MyHashMap<String, ArrayList<FileData>>();
        try {
            File f = new File(inputFile);
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                String[] data = sc.nextLine().split(", ");
                add(data[0], data[1], data[2]);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    public boolean add(String fileName, String directory, String modifiedDate) {
        if(fileName == null){fileName = "";}
        if(directory == null){directory = "/";}
        if(modifiedDate == null){modifiedDate = "01/01/2021";}

        FileData file = new FileData(fileName, directory, modifiedDate);
        ArrayList<FileData> fns = nameMap.get(fileName);
        if(fns != null){
            for(FileData d:fns){
                if(d.dir.equals(directory)){ // the file with same name and same dir
                    return false;
                }
            }
            fns.add(file);
        }else{
            fns = new ArrayList<>();
            fns.add(file);
            nameMap.set(fileName, fns);
        }

        ArrayList<FileData> fds = dateMap.get(modifiedDate);
        if(fds == null){
            fds = new ArrayList<>();
        }
            fds.add(file);
            dateMap.set(directory, fds);
        return true;
    }

    // TODO
    public FileData findFile(String name, String directory) {
        ArrayList<FileData> files = nameMap.get(name);
        if(files == null){
            return null;
        }
        for(FileData d:files){
            if(d.dir.equals(directory)){
                return d;
            }
        }
        return null;
    }

    public ArrayList<String> findAllFilesName() {
        //ArrayList<String> Names = new ArrayList<>();
        return (ArrayList<String>) nameMap.keys();
    }

    public ArrayList<FileData> findFilesByName(String name) {
        if(nameMap.get(name) == null){
            return new ArrayList<FileData>();
        }
        return nameMap.get(name);
        
    }

    public ArrayList<FileData> findFilesByDate(String modifiedDate) {
        ArrayList<FileData> files = dateMap.get(modifiedDate);
        
        if(files == null){
            return new ArrayList<FileData>();
        }
        return files;
    }

    public ArrayList<FileData> findFilesInMultDir(String modifiedDate) {
        ArrayList<FileData> files = dateMap.get(modifiedDate);
        ArrayList<FileData> result = new ArrayList<>();

        if(files == null){
            return new ArrayList<FileData>();
        }

        for(FileData d:files){
            if(nameMap.get(d.name) != null && nameMap.get(d.name).size() > 1){
                result.add(d);
            }
        }
        return result;
    }

    public boolean removeByName(String name) {
        ArrayList<FileData> files = nameMap.get(name);
        if (files == null){
            return false;
        }
        boolean d = true;
        boolean b = nameMap.remove(name);
        for(FileData f:files){
            ArrayList<FileData> date = dateMap.get(f.lastModifiedDate);
            if(date != null){
                d = date.remove(f);
            }
        }

        return b&&d;
    }

    public boolean removeFile(String name, String directory) {
        ArrayList<FileData> files = nameMap.get(name);
        ArrayList<FileData> dates = new ArrayList<>();
        ArrayList<FileData> removed = new ArrayList<>();

        if(files == null){return false;}

        for(FileData f:files){
            if(f.dir.equals(directory)){
                removed.add(f);
            }
        }
        // if we find the files need to be removed, remove from nameMap
        if(!removed.isEmpty()){
            files.removeAll(removed);

        
        // then do it for dateMap
        for(FileData f:files){
            dates = dateMap.get(f.lastModifiedDate);
            if(dates != null){
                dates.remove(f);
            }
        }
        return true;
    }
    return false; // if it is empty for nameMap
}
}
