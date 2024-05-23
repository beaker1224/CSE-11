import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Comparator;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class FileSystem {

    BST<String, FileData> nameTree;
    BST<String, ArrayList<FileData>> dateTree;
    
    // TODO
    public FileSystem() {
        this.nameTree = new BST<>();
        this.dateTree = new BST<>();
    }


    // TODO
    public FileSystem(String inputFile) {
    	// Add your code here
        this.nameTree = new BST<>();
        this.dateTree = new BST<>();

        try {
            File f = new File(inputFile);
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                String[] data = sc.nextLine().split(", ");
                // Add your code here
                add(data[0], data[1], data[2]);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);

        }
    }


    // TODO
    public void add(String name, String dir, String date) {
    	if(name == null || dir == null || date == null){return;}

        FileData newFile = new FileData(name, dir, date);
        FileData oldFile = nameTree.get(name);

        //If the file is new from name tree
        if(oldFile == null){
            //add to the name tree
            nameTree.set(name, newFile);
            ArrayList<FileData> files = dateTree.get(date);

            //if there is no such date in the dateTree
            if(files == null){
                files = new ArrayList<>();
                //add this arraylist box
                dateTree.set(date, files);
            }
            //add this to the dateTree
            files.add(newFile);

        }
        else{//if there is already file in the trees
            //add to the dateTree in order
            if(date.compareTo(oldFile.lastModifiedDate) > 0){
                //which means newer
                nameTree.set(name, newFile);

                ArrayList<FileData> newFiles = dateTree.get(date);
                //check null
                if(newFiles == null){
                    newFiles = new ArrayList<>();
                    dateTree.set(date, newFiles);
                }
                newFiles.add(newFile);

                ArrayList<FileData> oldFiles = dateTree.get(oldFile.lastModifiedDate);
                oldFiles.removeIf(fd -> fd.name.equals(name));

            }else if(date.compareTo(oldFile.lastModifiedDate) == 0){
                return;
            }
        }
    }


    // TODO
    public ArrayList<String> findFileNamesByDate(String date) {
        if(date == null){return null;}

        ArrayList<String> result = new ArrayList<>();
        ArrayList<FileData> oldFiles = dateTree.get(date);
        if(oldFiles == null){return new ArrayList<>();}

        List<String> orderedNames = nameTree.keys();
        

        for (FileData file : oldFiles){
            for (String fileName : orderedNames){
                if(file.name.equals(fileName)){
                    result.add(fileName);
                    break;
                }
            }
        }
        return result;
    }

    public FileSystem filter(String startDate, String endDate) {
        FileSystem result = new FileSystem();//create result lst
        List<String> AllKeys = dateTree.keys();//get keys list

        for(String k : AllKeys){
            if(k.compareTo(startDate) >= 0 && k.compareTo(endDate) < 0){
                ArrayList<FileData> files = dateTree.get(k);
                for(FileData f : files){
                    result.add(f.name, f.dir, f.lastModifiedDate);
                }
            }

        }
        return result;
    }
    
    
    public FileSystem filter(String wildCard) {
        FileSystem result = new FileSystem();
        List<String> AllKeys = nameTree.keys();

        for(String k:AllKeys){
            if(k.contains(wildCard)){
                FileData f = nameTree.get(k);
                result.add(f.name, f.dir, f.lastModifiedDate);
            }
        }
        return result;
    }
    
    
    // TODO
    public List<String> outputNameTree(){
        List<String> result = new ArrayList<>();
        List<String> keys = nameTree.keys();
        for(String k : keys){
            FileData file = nameTree.get(k);
            result.add(k + ": " + file.toString());
        }
        return result;
    }
    
    
    // TODO
    public List<String> outputDateTree(){
        List<String> result = new ArrayList<>();
        List<String> keys = dateTree.keys();
        for(String k : keys){
            ArrayList<FileData> files = dateTree.get(k);
            for(FileData f:files){
                result.add(f.lastModifiedDate + ": " + f.toString());
            }
            
        }
        //the order need to be reversed
        Collections.reverse(result);
        return result;
    }
    

}

