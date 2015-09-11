package com.vijfhart.casus.tree.file;

import com.vijfhart.casus.tree.NodeTree;
import com.vijfhart.casus.tree.Tree;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by Vincent Free on 10-9-2015.
 */
public class FileTree {
    NodeTree<PathNode> nodeTree = new NodeTree<>();
    FileTree() {    }

    FileTree(String pathName) {
        try {
            fillTree(pathName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void fillTree(String dirStart) throws IOException {
        Path path = Paths.get(dirStart);
        PathNode currentDir = null;
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                if(Files.isDirectory(dir)){
                    //currentDir(,dir);

                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                return super.visitFile(file, attrs);
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                return super.postVisitDirectory(dir, exc);
            }
        });

    }
}