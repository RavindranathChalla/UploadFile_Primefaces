package com.bean;

import javax.faces.bean.ManagedBean;

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

  public void upload() {
    uploadedFile.getFileName();
    uploadedFile.getContentType();
    uploadedFile.getContents();

    System.out.println("Uploaded File Name Is :: " + uploadedFile.getFileName()
        + " :: Uploaded File Size :: " + uploadedFile.getSize());
  }

  public void handleFileUpload(FileUploadEvent event) {
    uploadedFile = event.getFile();
    /*
     * FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() +
     * " is uploaded."); FacesContext.getCurrentInstance().addMessage(null, message);
     */
  }
}
