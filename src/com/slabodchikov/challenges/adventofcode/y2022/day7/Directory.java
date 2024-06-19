package com.slabodchikov.challenges.adventofcode.y2022.day7;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Roman Slabodchikov
 */
public class Directory {

    private final String path;
    private Long size;
    private final List<Directory> subDirectories;
    private final Directory parentDirectory;

    public Directory(String path, Directory parentDirectory) {
        this.path = path;
        this.subDirectories = new ArrayList<>();
        this.size = 0L;
        this.parentDirectory = parentDirectory;
        if (parentDirectory != null) {
            parentDirectory.addSubDirectory(this);
        }
    }

    public void addSubDirectory(Directory subDirectory) {
        this.subDirectories.add(subDirectory);
    }

    public void addFile(Long fileSize) {
        this.size += fileSize;
        if (parentDirectory != null) {
            parentDirectory.addFile(fileSize);
        }
    }

    public String getPath() {
        return path;
    }

    public Long getSize() {
        return size;
    }

    public List<Directory> getSubDirectories() {
        return subDirectories;
    }

    public Directory getParentDirectory() {
        return parentDirectory;
    }
}
