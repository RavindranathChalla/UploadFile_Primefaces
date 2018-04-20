package com.bean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ResourceBundle;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@ManagedBean(name = "fileUploadView")
public class FileUploadView {

  /**
   * @return the ravi
   */
  public String getRavi() {
    return "Ravindra";
  }

  /**
   * @param ravi the ravi to set
   */
  public void setRavi(String ravi) {}

  private UploadedFile uploadedFile; // +getter+setter

  /**
   * @return the uploadedFile
   */
  public UploadedFile getUploadedFile() {
    return uploadedFile;
  }

  /**
   * @param uploadedFile the uploadedFile to set
   */
  public void setUploadedFile(UploadedFile uploadedFile) {
    this.uploadedFile = uploadedFile;
  }

  public void upload() throws IOException {
    uploadedFile.getFileName();
    uploadedFile.getContentType();
    final byte[] content = uploadedFile.getContents();
    FacesContext context = FacesContext.getCurrentInstance();
    ResourceBundle bundle = context.getApplication().getResourceBundle(context, "uploadMsg");
    String key = "upload.var.filename";
    String message = bundle.getString(key);
    System.out.println("value from property file--->" + message);

    System.out.println("Uploaded File Name Is :: " + uploadedFile.getFileName()
        + " :: Uploaded File Size :: " + uploadedFile.getSize());

    String targetPath = "D:\\Ravi";
    String fileName = uploadedFile.getFileName();
    fileName =
        fileName.substring(fileName.lastIndexOf("/") + 1).substring(fileName.lastIndexOf("\\") + 1);

    String newFilePath = targetPath + File.separator + fileName;
    FileOutputStream out = new FileOutputStream(newFilePath);

    int c;
    for (int x = 0; x < content.length; x++) {
      out.write(content[x]); // writes the bytes
    }
    out.close();
  }

  public void handleFileUpload(FileUploadEvent event) {
    uploadedFile = event.getFile();
    /*
     * FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() +
     * " is uploaded."); FacesContext.getCurrentInstance().addMessage(null, message);
     */
  }
}
