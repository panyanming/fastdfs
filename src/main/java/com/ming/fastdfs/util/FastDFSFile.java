package com.ming.fastdfs.util;

/**
 * Created by 86189 on 2020/8/6.
 */


// TODO 使用lombok
public class FastDFSFile implements FileManagerConfig{
    private byte[] content;
    private String name;
    private String ext;
    private String length;

    public FastDFSFile(byte[] content, String ext) {
        this.content = content;
        this.ext = ext;
    }

    public FastDFSFile(byte[] content, String name, String ext) {
        this.content = content;
        this.name = name;
        this.ext = ext;
    }

    public FastDFSFile(byte[] content, String name, String ext, String length,
                       String author) {
        this.content = content;
        this.name = name;
        this.ext = ext;
        this.length = length;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

}
