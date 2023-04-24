package magicalpipelines.serialization;

import com.google.gson.annotations.SerializedName;

public class Gaze {

  @SerializedName("Timestamp")
  long timestamp;
  @SerializedName("XposLeft")
  int xposLeft;
  @SerializedName("YposLeft")
  int yposLeft;
  @SerializedName("XposRight")
  int xposRight;
  @SerializedName("YposRight")
  int yposRight;
  @SerializedName("ValidGazeLeft")
  boolean validGazeLeft;
  @SerializedName("ValidGazeRight")
  boolean validGazeRight;
  @SerializedName("PupilSizeLeft")
  double pupilSizeLeft;
  @SerializedName("PupilSizeRight")
  double pupilSizeRight;
  @SerializedName("ValidPupilSizeLeft")
  boolean validPupilSizeLeft;
  @SerializedName("ValidPupilSizeRight")
  boolean validPupilSizeRight;
  @SerializedName("XDistance")
  double xDistance;
  @SerializedName("YDistance")
  double yDistance;
  @SerializedName("ZDistance")
  double zDistance;
  @SerializedName("EventSource")
  int eventSource;
  @SerializedName("SystemMemory")
  double systemMemory;


  // attributes after event translation
  int xpos;
  int ypos;
  double pupilSize;
  String aoi;



  public long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(long timestamp) {
    this.timestamp = timestamp;
  }

  public int getXposLeft() {
    return xposLeft;
  }

  public void setXposLeft(int xposLeft) {
    this.xposLeft = xposLeft;
  }

  public int getYposLeft() {
    return yposLeft;
  }

  public void setYposLeft(int yposLeft) {
    this.yposLeft = yposLeft;
  }

  public int getXposRight() {
    return xposRight;
  }

  public void setXposRight(int xposRight) {
    this.xposRight = xposRight;
  }

  public int getYposRight() {
    return yposRight;
  }

  public void setYposRight(int yposRight) {
    this.yposRight = yposRight;
  }

  public boolean isValidGazeLeft() {
    return validGazeLeft;
  }

  public void setValidGazeLeft(boolean validGazeLeft) {
    this.validGazeLeft = validGazeLeft;
  }

  public boolean isValidGazeRight() {
    return validGazeRight;
  }

  public void setValidGazeRight(boolean validGazeRight) {
    this.validGazeRight = validGazeRight;
  }

  public double getPupilSizeLeft() {
    return pupilSizeLeft;
  }

  public void setPupilSizeLeft(double pupilSizeLeft) {
    this.pupilSizeLeft = pupilSizeLeft;
  }

  public double getPupilSizeRight() {
    return pupilSizeRight;
  }

  public void setPupilSizeRight(double pupilSizeRight) {
    this.pupilSizeRight = pupilSizeRight;
  }

  public boolean isValidPupilSizeLeft() {
    return validPupilSizeLeft;
  }

  public void setValidPupilSizeLeft(boolean validPupilSizeLeft) {
    this.validPupilSizeLeft = validPupilSizeLeft;
  }

  public boolean isValidPupilSizeRight() {
    return validPupilSizeRight;
  }

  public void setValidPupilSizeRight(boolean validPupilSizeRight) {
    this.validPupilSizeRight = validPupilSizeRight;
  }

  public double getxDistance() {
    return xDistance;
  }

  public void setxDistance(double xDistance) {
    this.xDistance = xDistance;
  }

  public double getyDistance() {
    return yDistance;
  }

  public void setyDistance(double yDistance) {
    this.yDistance = yDistance;
  }

  public double getzDistance() {
    return zDistance;
  }

  public void setzDistance(double zDistance) {
    this.zDistance = zDistance;
  }

  public int getEventSource() {
    return eventSource;
  }

  public void setEventSource(int eventSource) {
    this.eventSource = eventSource;
  }

  public double getSystemMemory() {
    return systemMemory;
  }

  public void setSystemMemory(double systemMemory) {
    this.systemMemory = systemMemory;
  }

  public int getXpos() {
    return xpos;
  }

  public void setXpos(int xpos) {
    this.xpos = xpos;
  }

  public int getYpos() {
    return ypos;
  }

  public void setYpos(int ypos) {
    this.ypos = ypos;
  }

  public double getPupilSize() {
    return pupilSize;
  }

  public void setPupilSize(double pupilSize) {
    this.pupilSize = pupilSize;
  }

  public String getAoi() {
    return aoi;
  }

  public void setAoi(String aoi) {
    this.aoi = aoi;
  }
}
