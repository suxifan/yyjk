package com.cictec.yyjk.commons.core;

import java.io.File;
import java.io.IOException;

import javax.activation.FileTypeMap;

import org.springframework.mail.javamail.ConfigurableMimeFileTypeMap;
import org.springframework.util.FileCopyUtils;

public class AFile {
    private final String fullPath;
    private String MIMEType;
    private byte[] bytes;
    private final File file;
    private String fileLabel;
    private static FileTypeMap map = new ConfigurableMimeFileTypeMap();

    public AFile(String fullPath) {
        super();
        this.fullPath = fullPath;
        file = new File(fullPath);
        MIMEType = map.getContentType(file);
    }

    public String getMIMEType() {
        return MIMEType;
    }

    public void setMIMEType(String mIMEType) {
        MIMEType = mIMEType;
    }

    public byte[] getBytes() throws IOException {
        if (bytes == null) {
            return FileCopyUtils.copyToByteArray(file);
        } else {
            return bytes;
        }
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public String getFullPath() {
        return fullPath;
    }

    public String getFileName() {
        if (fileLabel != null && fileLabel.length() > 0) {
            return fileLabel;
        }
        return file.getName();
    }

    public File getFile() {
        return file;
    }

    public boolean isExcel() {
        if (MIMEType.endsWith("excel")) {
            return true;
        }
        if (file != null
                && (file.getName().endsWith("xls") || file.getName().endsWith(
                        "xlsx"))) {
            return true;
        }
        return false;
    }

    public String getFileLabel() {
        return fileLabel;
    }

    public void setFileLabel(String fileLabel) {
        this.fileLabel = fileLabel;
    }

    // TODO need file type code table
    public int getFileType() {
        if (isExcel()) {
            return 1;
        } else {
            // TODO
            return 0;
        }
    }
}
