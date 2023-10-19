/**
 * 文件和目录路径
 */

package codeOnJava_17_1.files;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;

public class PathInfo {
    static void show(String id, Object p) {
        System.out.println(id + p);
    }
     static void info(Path p) {
        show("toString:\n", p);
        show("Exists: ", Files.exists(p));
        show("RegularFile: ", Files.isRegularFile(p));
        show("Directory: ", Files.isDirectory(p));
        show("Absolute: ", p.isAbsolute());
        show("FileName: ", p.getFileName());
        show("Parent: ", p.getParent());
        show("Root: ", p.getRoot());
        System.out.println("************************************\n");
     }

    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        System.out.println();

        // 这里描述的是一个不存在的文件，这个行为相当于创建一个路径
        info(Path.of("C:", "path", "to", "nowhere", "NoFile.txt"));

        Path p = Path.of("PathInfo.java");
        info(p);

        Path ap = p.toAbsolutePath();
        info(ap);

        // toRealPath() 真实路径这个定义有些模糊，取决于操作系统
        try {
            info(p.toRealPath());
        } catch (IOException e) {
            System.out.println(e);
        }

        // 文件的 URI
        URI u = p.toUri();
        System.out.println("URI:\n" + u);

        Path puri = Path.of(u);
        System.out.println(Files.exists(puri));
        File f = ap.toFile();   // 不要被骗了，只是为了向后兼容
    }
}
